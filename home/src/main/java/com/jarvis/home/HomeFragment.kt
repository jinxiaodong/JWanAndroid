package com.jarvis.home

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import com.jarvis.home.api.HomeService
import com.jarvis.home.databinding.FragmentHomeBinding
import com.jarvis.home.repo.HomeRepo
import com.jarvis.home.viewmodel.HomeViewModel
import com.jarvis.libbase.base.BaseFragment
import com.jarvis.libbase.network.RetrofitManager

/**
 * @author jinxiaodong
 * @description：
 * @date 2022/2/22
 */
class HomeFragment : BaseFragment() {


    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }

    override fun getLayoutRes() = R.layout.fragment_home

    override fun bindView(view: View, savedInstanceState: Bundle?): ViewDataBinding {
        return FragmentHomeBinding.bind(view)
    }


    override fun initConfig() {
        super.initConfig()
        HomeViewModel().getBanner()
    }

    override fun initData() {
        super.initData()


    }

}