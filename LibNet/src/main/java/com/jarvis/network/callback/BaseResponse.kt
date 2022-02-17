package com.jarvis.network.callback

/**
 * @author jinxiaodong
 * @description：
 * @date 2022/2/10
 */
abstract class BaseResponse<T> {

    abstract fun isSuccess(): Boolean

    abstract fun getRespData(): T

    abstract fun getRespCode(): Int

    abstract fun getRespMsg(): String
}