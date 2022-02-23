package com.jarvis.home

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import com.jarvis.home.databinding.FragmentHomeBinding
import com.jarvis.home.viewmodel.HomeViewModel
import com.jarvis.libbase.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * @author jinxiaodong
 * @description：
 * @date 2022/2/22
 */
class HomeFragment : BaseFragment() {

    private val homeViewModel: HomeViewModel by viewModel()

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
        observeLoadingUI(homeViewModel)

    }

    override fun initData() {
        super.initData()

        homeViewModel.getBanner()


    }

}