package com.jarvis.libbase.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build

/**
 * @author jinxiaodong
 * @description：
 * @date 2022/2/10
 */
fun isNetWorkAvailable(context: Context): Boolean {
    val connectivityManager =
        context.applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
        val info = connectivityManager.activeNetworkInfo
        return null != info && info.isAvailable

    } else {
        val netWork = connectivityManager.activeNetwork ?: return false
        val nc = connectivityManager.getNetworkCapabilities(netWork) ?: return false
        return nc.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) || nc.hasTransport(
            NetworkCapabilities.TRANSPORT_CELLULAR
        )
    }
}