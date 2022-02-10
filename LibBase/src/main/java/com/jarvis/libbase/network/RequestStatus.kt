package com.jarvis.libbase.network

import androidx.lifecycle.MutableLiveData
import com.jarvis.libbase.exception.AppException
import com.jarvis.libbase.exception.ExceptionHandler
import com.jarvis.libbase.network.callback.BaseResponse

/**
 * @author jinxiaodong
 * @description：
 * @date 2022/2/10
 */
sealed class RequestStatus<out T> {
    companion object {

        fun <T> onAppSuccess(msg: String, data: T): RequestStatus<T> = Success(msg, data)

        fun <T> onAppLoading(loadingMessage: String): RequestStatus<T> = Loading(loadingMessage)

        fun <T> onAppError(error: AppException): RequestStatus<T> = Error(error)

    }


    data class Loading(val loadingMessage: String) : RequestStatus<Nothing>()

    data class Success<out T>(val msg: String, val data: T) : RequestStatus<T>()

    data class Error(var error: AppException) : RequestStatus<Nothing>()

}


fun <T> MutableLiveData<RequestStatus<T>>.paresResult(result: BaseResponse<T>) {
    value = when {
        result.isSuccess() -> {
            RequestStatus.onAppSuccess(result.getRespMsg(), result.getRespData())
        }
        else -> {
            RequestStatus.onAppError(AppException(result.getRespCode(), result.getRespMsg()))

        }
    }
}

/**
 * 异常转换异常处理
 */
fun <T> MutableLiveData<RequestStatus<T>>.paresException(e: Throwable) {
    value = RequestStatus.onAppError<T>(ExceptionHandler.handleException(e))
}


fun <T> MutableLiveData<RequestStatus<T>>.paresResult(result: T) {
    value = RequestStatus.onAppSuccess("", result)
}
