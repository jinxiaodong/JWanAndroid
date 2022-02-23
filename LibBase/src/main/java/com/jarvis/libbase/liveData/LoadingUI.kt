package com.jarvis.libbase.liveData

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.jarvis.libbase.base.BaseActivity
import com.jarvis.libbase.base.BaseFragment
import com.jarvis.libbase.base.BaseViewModel
import com.jarvis.libbase.ktx.dismissLoading
import com.jarvis.libbase.ktx.showLoading
import com.jarvis.libbase.liveData.event.EventLiveData

/**
 * @author jinxiaodong
 * @description：
 * @date 2022/2/10
 */

fun ViewModel.observeLoadingUI(owner: LifecycleOwner) {
    if (this is BaseViewModel && owner is BaseActivity<*>) {
        showLoading.observe(owner) {
            owner.showLoading(it)
        }
        dismissLoading.observe(owner) {
            owner.dismissLoading()
        }
    }
    if (this is BaseViewModel && owner is BaseFragment) {
        showLoading.observe(owner) {
            owner.showLoading(it)
        }
        dismissLoading.observe(owner) {
            owner.dismissLoading()
        }
    }
}



