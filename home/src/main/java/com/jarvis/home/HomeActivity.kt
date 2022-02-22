package com.jarvis.home

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.jarvis.home.databinding.ActivityHomeBinding
import com.jarvis.libbase.base.BaseActivity

/**
 * @author jinxiaodong
 * @description：
 * @date 2022/2/21
 */
class HomeActivity : BaseActivity<ActivityHomeBinding>() {


    private val fragments: MutableList<Fragment> = ArrayList()

    override fun getContentLayout() = R.layout.activity_home

    override fun initConfig() {
    }

    override fun initView() {
        fragments.add(HomeFragment.newInstance())
        fragments.add(HomeFragment.newInstance())
        fragments.add(HomeFragment.newInstance())
        fragments.add(HomeFragment.newInstance())

        binding.viewPager.adapter = object : FragmentStateAdapter(this) {

            override fun getItemCount(): Int {
                return fragments.size
            }

            override fun createFragment(position: Int): Fragment {
                return fragments[position]
            }

        }

    }

    override fun initData() {
    }
}