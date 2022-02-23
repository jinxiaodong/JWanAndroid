package com.jarvis.home.repo

import com.blankj.utilcode.util.LogUtils
import com.jarvis.home.api.HomeService
import com.jarvis.libbase.network.response.*

/**
 * @author jinxiaodong
 * @description：
 * @date 2022/2/23
 */
class HomeRepo(private val service: HomeService) : IHomeResource {

    override suspend fun getBanner() {
        service.getBanner()
            .serverData()
            .onSuccess {
                onBizOK { code, data, message ->
                    LogUtils.d(data?.get(0)?.imagePath)
                }
                onBizError { code, message ->

                }

            }.onFailure {

            }

    }
}