package com.jarvis.home.viewmodel

import androidx.lifecycle.viewModelScope
import com.jarvis.home.api.HomeService
import com.jarvis.home.repo.HomeRepo
import com.jarvis.home.repo.IHomeResource
import com.jarvis.libbase.base.BaseViewModel
import com.jarvis.libbase.network.RetrofitManager
import com.jarvis.libbase.network.response.*
import kotlinx.coroutines.launch

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