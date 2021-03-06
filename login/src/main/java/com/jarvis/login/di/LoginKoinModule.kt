package com.jarvis.login.di

import com.jarvis.login.LoginViewModel
import com.jarvis.login.api.LoginService
import com.jarvis.login.repo.ILoginResource
import com.jarvis.login.repo.LoginRepo
import com.jarvis.lib.network.RetrofitManager
import com.jarvis.lib.network.config.getBaseHost
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.parameter.parametersOf
import org.koin.dsl.bind
import org.koin.dsl.module


/**
 * @author jinxiaodong
 * @description：
 * @date 2022/2/18
 */

val moduleLogin = module {
    single { get<RetrofitManager> { parametersOf(getBaseHost()) }.getService(LoginService::class.java) }
    single { LoginRepo() } bind ILoginResource::class
    viewModel { LoginViewModel(get()) }
}