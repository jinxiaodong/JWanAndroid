package com.jarvis.home.viewmodel

import com.jarvis.home.api.HomeService
import com.jarvis.lib.base.BaseViewModel
import com.jarvis.lib.network.response.*

/**
 * @author jinxiaodong
 * @description：
 * @date 2022/2/23
 */
class HomeViewModel(private val repo: HomeService) : BaseViewModel() {


    fun getBanner() = serverAwait(true) {
        repo.getBanner()
            .serverData()
            .onSuccess {
                onBizOK { code, data, message ->
                    val bannerList = data
                }

                onBizError { code, message ->

                }
            }
            .onFailure {

            }
    }


}