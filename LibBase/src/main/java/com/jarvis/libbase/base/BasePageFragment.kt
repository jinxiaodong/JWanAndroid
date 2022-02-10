package com.jarvis.libbase.base

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.jarvis.libbase.R
import com.jarvis.libbase.network.RequestStatus
import com.scwang.smart.refresh.layout.SmartRefreshLayout
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

/**
 * @author jinxiaodong
 * @description：
 * @date 2022/2/10
 */
abstract class BasePageFragment<T> : BaseFragment() {
    companion object {
        private const val PAGE_START_POSITION = 0
        private const val PAGE_SIZE_DEFAULT = 20
    }

    protected lateinit var mAdapter: BaseQuickAdapter<T, BaseViewHolder>
    protected lateinit var mRefreshLayout: SmartRefreshLayout
    protected lateinit var mRecyclerView: RecyclerView
    private lateinit var mLayoutManager: RecyclerView.LayoutManager
    private lateinit var mEmptyDataView: View
    private var mPage: Int = PAGE_START_POSITION
    private val mConfig = PageConfig()

    override fun getContentLayout() = R.layout.layout_refresh_list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initViewInternal(view)
        initDataInternal()
        super.onViewCreated(view, savedInstanceState)
    }

    override fun initView(rootView: View) {
    }

    override fun initData() {
    }

    abstract fun createAdapter(): BaseQuickAdapter<T, BaseViewHolder>//BaseQuickAdapterKt<T>

    private fun initViewInternal(view: View) {
        mRecyclerView = view.findViewById(R.id.recycler_view)
        mRefreshLayout = view.findViewById(R.id.layout_refresh)
        mLayoutManager = mConfig.layoutManager ?: LinearLayoutManager(requireContext())
        mRecyclerView.layoutManager = mLayoutManager
        mAdapter = createAdapter()
        mRecyclerView.adapter = mAdapter
    }

    private fun initDataInternal() {
        mRefreshLayout.setOnRefreshListener {
            onRefresh(false)
        }
        mRefreshLayout.setOnLoadMoreListener {
            onLoadMore()
        }
        if (mConfig.enableAutoRefresh) {
            onRefresh(true)
        }
    }

    open fun onRefresh(showLoading: Boolean) {
        mPage = PAGE_START_POSITION
        lifecycleScope.launch { getListData(showLoading) }
    }

    open fun onLoadMore() {
        lifecycleScope.launch { getListData(false) }
    }

    open suspend fun createPageFlow(page: Int): Flow<RequestStatus<List<T>>> {
        return flow {
            emit(RequestStatus.Success("",ArrayList()))
        }
    }

    private suspend fun getListData(showLoading: Boolean) {
        createPageFlow(mPage)
            .onCompletion {
                if (mPage <= PAGE_START_POSITION + 1) {
                    mRefreshLayout.finishRefresh()
                } else {
                    mRefreshLayout.finishLoadMore()
                }
            }.collect { state ->

                when (state) {
                    is RequestStatus.Loading -> {

                    }
                    is RequestStatus.Success -> {
                        state.data.let {
                            if (mPage == PAGE_START_POSITION) {
                                if (it.isEmpty()) {
                                    mRecyclerView.layoutManager =
                                        LinearLayoutManager(requireContext())
                                } else {
                                    mRecyclerView.layoutManager = mLayoutManager
                                }
                                mAdapter.setNewInstance(ArrayList(it))

                            } else {
                                if (it.size < PAGE_SIZE_DEFAULT) {
                                    mRefreshLayout.setNoMoreData(true)
                                    mAdapter.addData(it)
                                } else {
                                    mAdapter.addData(it)
                                }
                            }
                            mPage += 1
                        }
                    }
                    is RequestStatus.Error -> {

                    }
                }
            }
    }

    fun nowPage() = mPage

    fun pageConfig(config: PageConfig.() -> Unit) {
        mConfig.apply(config)
    }

    class PageConfig {
        var enableRefresh = true
        var enableAutoRefresh = true
        var enableLoadMore = true
        var pageSize = PAGE_SIZE_DEFAULT
        var layoutManager: RecyclerView.LayoutManager? = null
    }
}