package com.jarvis.network.model

import androidx.annotation.Keep

/**
 * @author jinxiaodong
 * @description： 错误码0为正确
 * @date 2022/2/17
 */

@Keep
data class WanResponse<T>(val errorCode: Int = -1, val errorMsg: String, var data: T? = null)

