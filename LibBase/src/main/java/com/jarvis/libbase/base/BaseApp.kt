package com.jarvis.libbase.base

import android.app.Application
import android.content.Context
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import com.blankj.utilcode.util.LogUtils
import com.jarvis.libbase.network.manager.NetWorkStateReceiver

/**
 * @author jinxiaodong
 * @description：
 * @date 2022/2/10
 */
open class BaseApp : Application() {
    companion object {
        private lateinit var instance: Application

        fun getInstance(): Application {
            return instance
        }
    }

    override fun onCreate() {
        super.onCreate()

        LogUtils.getConfig().globalTag = "Jarvis123"
        val netWorkStateReceiver = NetWorkStateReceiver()

        this.registerReceiver(
            netWorkStateReceiver,
            IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        )

        val cm = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        cm.registerNetworkCallback(
            NetworkRequest.Builder()
            .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
            .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
            .build(),
            object : ConnectivityManager.NetworkCallback() {
                override fun onCapabilitiesChanged(
                    network: Network,
                    networkCapabilities: NetworkCapabilities
                ) {
                    // 一般在此处获取网络类型然后判断网络类型，就知道时哪个网络可以用connected

                    val hasNet =
                        networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) || networkCapabilities.hasTransport(
                            NetworkCapabilities.TRANSPORT_CELLULAR
                        )
                    LogUtils.i("callback onCapabilitiesChanged :${if (hasNet) "有网" else "无网"}")

                }

                override fun onLost(network: Network) {
                    LogUtils.i("callback:无网")
                    // 如果通过ConnectivityManager#getActiveNetwork()返回null，表示当前已经没有其他可用网络了。


                }
            })

    }
}