package com.jarvis.libbase.ktx

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.jarvis.libbase.base.BaseActivity

/**
 * @author jinxiaodong
 * @description： Activity 方法扩展
 * @date 2022/2/10
 */

inline fun <reified T : Activity> Activity.startActivity(finishSelf: Boolean = false) {

    startActivity(Intent(this, T::class.java))
    finishSelf.yes {
        finish()
    }

}


inline fun <reified T : Activity> Activity.startActivity(extras: Bundle) {
    startActivity(Intent(this, T::class.java).putExtras(extras))
}

fun BaseActivity.showLoading(message: String = "正在加载中,请稍后...") {
    this.loadingDialog.showDialog(this)
}

fun BaseActivity.showError2() {

}


fun BaseActivity.dismissLoading() {
    this.loadingDialog.dismissDialog()

}
