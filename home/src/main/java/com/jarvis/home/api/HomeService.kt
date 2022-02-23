package com.jarvis.home.api

import com.jarvis.home.repo.bean.BannerResponse
import com.jarvis.libbase.network.response.ApiResponse
import retrofit2.Call
import retrofit2.http.GET

/**
 * @author jinxiaodong
 * @description：
 * @date 2022/2/23
 */
interface HomeService {

    /**
     * 获取banner数据
     */
    @GET("banner/json")
     fun getBanner(): Call<ApiResponse<ArrayList<BannerResponse>>>

}