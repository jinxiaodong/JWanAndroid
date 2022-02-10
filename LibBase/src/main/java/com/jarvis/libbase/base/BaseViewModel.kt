package com.jarvis.libbase.base

import androidx.lifecycle.ViewModel
import com.jarvis.libbase.liveData.LoadingUI

/**
 * @author jinxiaodong
 * @description：
 * @date 2022/2/10
 */
open class BaseViewModel : ViewModel() {

    val loadingUI: LoadingUI by lazy { LoadingUI() }

}