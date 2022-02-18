package com.jarvis.login

import com.jarvis.login.api.LoginService
import com.jarvis.network.RetrofitManager
import com.jarvis.network.config.getBaseHost
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module

/**
 * @author jinxiaodong
 * @description：
 * @date 2022/2/17
 */

val moduleLogin = module {

    //
    single {
        get<RetrofitManager> {
            parametersOf(getBaseHost())
        }.getService(LoginService::class.java)
    }

}