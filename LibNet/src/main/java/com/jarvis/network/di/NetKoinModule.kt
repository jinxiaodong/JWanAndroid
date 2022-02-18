package com.jarvis.network

import org.koin.dsl.module

/**
 * @author jinxiaodong
 * @description：
 * @date 2022/2/17
 */
val moduleNetWork = module {

    single { (host: String) -> RetrofitManager.initConfig(host) }
}