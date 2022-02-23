package com.jarvis.home.di

import com.jarvis.home.api.HomeService
import com.jarvis.home.repo.HomeRepo
import com.jarvis.home.repo.IHomeResource
import com.jarvis.home.viewmodel.HomeViewModel
import com.jarvis.libbase.network.RetrofitManager
import com.jarvis.libbase.network.config.getBaseHost
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.parameter.parametersOf
import org.koin.dsl.bind
import org.koin.dsl.module

/**
 * @author jinxiaodong
 * @description：
 * @date 2022/2/21
 */

val moduleHome = module {

    single { get<RetrofitManager> { parametersOf(getBaseHost()) }.getService(HomeService::class.java) }

    single { HomeRepo(get()) } bind IHomeResource::class

    viewModel { HomeViewModel(get()) }

}