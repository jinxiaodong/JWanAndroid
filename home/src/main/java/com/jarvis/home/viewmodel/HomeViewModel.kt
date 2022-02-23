package com.jarvis.home.viewmodel

import androidx.lifecycle.viewModelScope
import com.jarvis.home.api.HomeService
import com.jarvis.home.repo.HomeRepo
import com.jarvis.home.repo.IHomeResource
import com.jarvis.libbase.base.BaseViewModel
import com.jarvis.libbase.network.RetrofitManager
import kotlinx.coroutines.launch

/**
 * @author jinxiaodong
 * @description：
 * @date 2022/2/23
 */
class HomeViewModel(private val repo: IHomeResource) : BaseViewModel() {


    fun getBanner() = serverAwait(true) { repo.getBanner() }


}