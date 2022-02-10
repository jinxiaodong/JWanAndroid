package com.jarvis.libbase.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.jarvis.libbase.ktx.dismissLoading
import com.jarvis.libbase.ktx.showLoading
import com.jarvis.libbase.liveData.observeLoadingUI
import com.jarvis.libbase.view.LoadingDialog

/**
 * @author jinxiaodong
 * @description：
 * @date 2022/2/10
 */
abstract class BaseFragment : Fragment() {

    private val baseViewModel: BaseViewModel?
        get() = lazyBaseViewModel?.value
    private var lazyBaseViewModel: Lazy<BaseViewModel>? = null

    lateinit var loadingDialog: LoadingDialog

    @LayoutRes
    private var mContentLayoutId = 0

    abstract fun getContentLayout(): Int

    abstract fun initView(rootView: View)

    abstract fun initData()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mContentLayoutId = getContentLayout()
        return if (mContentLayoutId != 0) {
            inflater.inflate(mContentLayoutId, container, false)
        } else null
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadingDialog = LoadingDialog(view.context)
        initView(view)
        createObserver()
        registerUIChange()
        initData()

    }

    private fun createObserver() {
        baseViewModel?.observeLoadingUI(this)

    }

    private fun registerUIChange() {
        baseViewModel?.loadingUI?.showLoading?.observe(this) {
            showLoading()
        }

        baseViewModel?.loadingUI?.disMiss?.observe(this) {
            dismissLoading()
        }

    }


    fun initBaseViewModel(vm: Lazy<BaseViewModel>) {
        lazyBaseViewModel = vm
    }

    inline fun <reified VM : BaseViewModel> viewModelsInBase(
        noinline ownerProducer: () -> ViewModelStoreOwner = { this },
        noinline factoryProducer: (() -> ViewModelProvider.Factory)? = null
    ): Lazy<VM> {
        val vm = viewModels<VM>(ownerProducer, factoryProducer)
        initBaseViewModel(vm)
        return vm
    }
}