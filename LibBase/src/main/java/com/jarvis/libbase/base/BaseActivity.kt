package com.jarvis.libbase.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import com.blankj.utilcode.util.ToastUtils
import com.jarvis.libbase.ktx.bindView
import com.jarvis.libbase.ktx.dismissLoading
import com.jarvis.libbase.ktx.showLoading
import com.jarvis.libbase.liveData.observeLoadingUI
import com.jarvis.libbase.network.manager.NetState
import com.jarvis.libbase.network.manager.NetWorkStateManager
import com.jarvis.libbase.view.LoadingDialog

/**
 * @author jinxiaodong
 * @description：
 * @date 2022/2/10
 */
abstract class BaseActivity<bindingType : ViewDataBinding> : AppCompatActivity() {


    lateinit var loadingDialog: LoadingDialog

    protected lateinit var binding: bindingType


    @LayoutRes
    abstract fun getContentLayout(): Int


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadingDialog = LoadingDialog(this)
        binding = bindView(getContentLayout())
        createObserver()
        initConfig()
        initView()
        initData()

    }

    open fun initConfig() {

    }

    open fun initView() {

    }

    open fun initData() {

    }

    open fun onNetworkStateChanged(netState: NetState) {

    }

    protected fun observeLoadingUI(viewModel: BaseViewModel) {
        viewModel.observeLoadingUI(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        if (this::binding.isLateinit) {
            binding.unbind()
        }
    }


    private fun createObserver() {
        observerNetWorkState()
    }

    private fun observerNetWorkState() {
        NetWorkStateManager.instance.netWorkStateCallback.observe(this) { onNetworkStateChanged(it) }
    }



}