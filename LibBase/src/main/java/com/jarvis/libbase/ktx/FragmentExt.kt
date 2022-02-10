package com.jarvis.libbase.ktx

import com.jarvis.libbase.base.BaseActivity
import com.jarvis.libbase.base.BaseFragment

/**
 * @author jinxiaodong
 * @description：
 * @date 2022/2/10
 */


fun BaseFragment.showLoading(message: String = "正在加载中,请稍后...") {
    context?.let {
        this.loadingDialog.showDialog(it)
    }
}

fun BaseFragment.showError1() {

}

fun BaseFragment.showError2() {

}


fun BaseFragment.dismissLoading() {
    this.loadingDialog.dismissDialog()
}