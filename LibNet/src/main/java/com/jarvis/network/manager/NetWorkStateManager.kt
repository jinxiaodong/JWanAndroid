package com.jarvis.network.manager

import com.jarvis.libbase.liveData.event.EventLiveData

/**
 * @author jinxiaodong
 * @description：
 * @date 2022/2/10
 */
class NetWorkStateManager private constructor(){

    val netWorkStateCallback  = EventLiveData<NetState>()


    companion object{
        val instance: NetWorkStateManager by lazy(mode= LazyThreadSafetyMode.SYNCHRONIZED) {
            NetWorkStateManager()
        }
    }
}
