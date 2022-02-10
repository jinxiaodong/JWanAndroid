package com.jarvis.libbase.liveData

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.jarvis.libbase.base.BaseViewModel
import com.jarvis.libbase.liveData.event.EventLiveData

/**
 * @author jinxiaodong
 * @description：
 * @date 2022/2/10
 */

fun ViewModel.observeLoadingUI(owner: LifecycleOwner) {

    if (this is BaseViewModel && owner is LoadingUI.CallBack) {
        this.loadingUI.showLoading.observe(owner){
            owner.showLoading()
        }

        this.loadingUI.disMiss.observe(owner){
            owner.dismissLoading()
        }
    }
}


class LoadingUI {

    val showLoading by lazy { EventLiveData<String>() }

    val disMiss by lazy { EventLiveData<Boolean>() }

    interface CallBack {
        fun showLoading(message: String = "正在加载...")

        fun showLoading() {
        }

        fun dismissLoading() {

        }
    }
}