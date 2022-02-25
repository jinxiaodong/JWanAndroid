package com.jarvis.home

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.LinearLayoutManager
import com.jarvis.home.databinding.FragmentHomeBinding
import com.jarvis.home.repo.bean.ArticleResponse
import com.jarvis.home.ui.HomeAdapter
import com.jarvis.home.viewmodel.HomeViewModel
import com.jarvis.lib.base.BaseFragment

/**
 * @author jinxiaodong
 * @description：
 * @date 2022/2/22
 */
class HomeFragment : BaseFragment() {

    private val homeViewModel: HomeViewModel by viewModel()
    private lateinit var homeAdapter: HomeAdapter

    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }

    override fun getLayoutRes() = R.layout.fragment_home

    override fun bindView(view: View, savedInstanceState: Bundle?): ViewDataBinding {
        return FragmentHomeBinding.bind(view).apply {
            homeAdapter = HomeAdapter(arrayListOf())
            recyclerView.layoutManager = LinearLayoutManager(this@HomeFragment.context)
            recyclerView.adapter = homeAdapter
            smartrefresh.setOnRefreshListener { smartrefresh.finishRefresh(2000) }
            smartrefresh.setOnLoadMoreListener { smartrefresh.finishLoadMore(1000) }
        }
    }


    override fun initConfig() {
        super.initConfig()
        observeLoadingUI(homeViewModel)

    }

    override fun initData() {
        super.initData()
        val mutableList = arrayListOf<ArticleResponse>()
        val articleResponse = ArticleResponse(
            "", "", 1, "", false, 0, "", "",
            false, 1, "", "", "", "", "", 1,
            1, "", "", arrayListOf(), "", 1, 1, 1, 1
        )
        for (i in 0..20) {
            if (i % 2 == 0) mutableList.add(articleResponse.copy(envelopePic = "111"))
            else mutableList.add(articleResponse.copy())
        }
        homeAdapter.setList(mutableList)
        homeViewModel.getBanner()


    }

}