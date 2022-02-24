package com.jarvis.home.ui

import android.text.TextUtils
import com.chad.library.adapter.base.BaseDelegateMultiAdapter
import com.chad.library.adapter.base.delegate.BaseMultiTypeDelegate
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.jarvis.home.R
import com.jarvis.home.repo.bean.ArticleResponse

/**
 * @author jinxiaodong
 * @description：
 * @date 2022/2/24
 */
class HomeAdapter(data: MutableList<ArticleResponse>) :
    BaseDelegateMultiAdapter<ArticleResponse, BaseViewHolder>(data) {


    companion object {

        const val ARTICLE = 1

        const val PROJECT = 2
    }


    init {

        //1.设置代理
        setMultiTypeDelegate(object : BaseMultiTypeDelegate<ArticleResponse>() {
            override fun getItemType(data: List<ArticleResponse>, position: Int): Int {
                return if (TextUtils.isEmpty(data[position].envelopePic)) ARTICLE else PROJECT
            }

        })

        //2. 绑定Item类型
        getMultiTypeDelegate()?.let {
            it.addItemType(ARTICLE, R.layout.item_article)
            it.addItemType(PROJECT, R.layout.item_project)
        }
    }

    override fun convert(holder: BaseViewHolder, item: ArticleResponse) {
        when (holder.itemViewType) {
            ARTICLE -> {
                item.run {


                }
            }

        }


    }
}