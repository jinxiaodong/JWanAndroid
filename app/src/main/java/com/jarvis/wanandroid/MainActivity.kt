package com.jarvis.wanandroid

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.jarvis.home.HomeFragment
import com.jarvis.lib.base.BaseActivity
import com.jarvis.wanandroid.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {


    private val fragments: ArrayList<Fragment> = ArrayList()

    override fun getContentLayout() = R.layout.activity_main


    override fun initConfig() {
    }

    override fun initView() {
        fragments.add(HomeFragment.newInstance())
        fragments.add(HomeFragment.newInstance())
        fragments.add(HomeFragment.newInstance())
        fragments.add(HomeFragment.newInstance())
        binding.viewpager.apply {
            adapter = HomePageAdapter(this@MainActivity, fragments)
            offscreenPageLimit = 2
            isUserInputEnabled = false
        }
    }

    override fun initData() {

    }


}

class HomePageAdapter(activity: FragmentActivity, private val fragments: ArrayList<Fragment>) :
    FragmentStateAdapter(activity) {

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }

}

