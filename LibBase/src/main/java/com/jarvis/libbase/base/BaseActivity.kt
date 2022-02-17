package com.jarvis.libbase.base

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.blankj.utilcode.util.ToastUtils
import com.jarvis.libbase.ktx.dismissLoading
import com.jarvis.libbase.ktx.showLoading
import com.jarvis.libbase.liveData.observeLoadingUI
import com.jarvis.network.manager.NetState
import com.jarvis.network.manager.NetWorkStateManager
import com.jarvis.libbase.view.LoadingDialog

/**
 * @author jinxiaodong
 * @description：
 * @date 2022/2/10
 */
abstract class BaseActivity : AppCompatActivity() {


    lateinit var loadingDialog: LoadingDialog

    private val baseViewModel: BaseViewModel?
        get() = lazyBaseViewModel?.value

    private var lazyBaseViewModel: Lazy<BaseViewModel>? = null


    abstract fun getContentLayout(): Int

    abstract fun initView(savedInstanceState: Bundle?)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadingDialog = LoadingDialog(this)
        setContentView(getContentLayout())
        init(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
    }


    private fun init(savedInstanceState: Bundle?) {
        initView(savedInstanceState)
        createObserver()
        registerUiChange()

        com.jarvis.network.manager.NetWorkStateManager.instance.netWorkStateCallback.observe(this) {
            onNetworkStateChanged(it)
        }
    }

    open fun onNetworkStateChanged(netState: com.jarvis.network.manager.NetState) {}


    private fun createObserver() {
        baseViewModel?.observeLoadingUI(this)

    }

    private fun registerUiChange() {

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


    fun toast(message: String) {
        ToastUtils.showShort(message)
    }

    /**
     * 创建ViewModel
     */
    inline fun <reified VM : BaseViewModel> viewModelsInBase(
        noinline factoryProducer: (() -> ViewModelProvider.Factory)? = null
    ): Lazy<VM> {
        val vm = viewModels<VM>(factoryProducer)
        initBaseViewModel(vm)
        return vm
    }
}