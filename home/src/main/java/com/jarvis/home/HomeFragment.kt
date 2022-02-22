package com.jarvis.home

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import com.jarvis.common.base.BaseFragment
import com.jarvis.home.databinding.FragmentHomeBinding

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

}