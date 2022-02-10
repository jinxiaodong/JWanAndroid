package com.jarvis.libbase.base

import android.os.Bundle
import androidx.fragment.app.Fragment

/**
 * @author jinxiaodong
 * @description：
 * @date 2022/2/10
 */
abstract class BaseLazyLoadFragment : BaseFragment() {
    private var isFirstVisible = true
    private var mIsViewCreated = false
    private var isSupportVisible = false

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (mIsViewCreated) {
            if (isVisibleToUser && !isSupportVisible) {
                dispatchUserVisibleHint(true)
            } else {
                dispatchUserVisibleHint(false)
            }
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mIsViewCreated = true
        if (!isHidden && userVisibleHint) {
            dispatchUserVisibleHint(true)
        }
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        if (hidden) {
            dispatchUserVisibleHint(false)
        } else {
            dispatchUserVisibleHint(true)
        }
    }

    override fun onResume() {
        super.onResume()
        if (!isFirstVisible) {
            if (!isHidden && !isSupportVisible && userVisibleHint) {
                dispatchUserVisibleHint(true)
            }
        }
    }

    override fun onPause() {
        super.onPause()
        if (isSupportVisible && userVisibleHint) {
            dispatchUserVisibleHint(false)
        }
    }

    private fun isFragmentVisible(fragment: Fragment): Boolean {
        return !fragment.isHidden && fragment.userVisibleHint
    }

    private fun isParentInvisible(): Boolean {
        if (parentFragment != null && parentFragment is BaseLazyLoadFragment) {
            return !requireParentFragment().userVisibleHint
        }

        val fragment = parentFragment as BaseLazyLoadFragment?
        return fragment != null && !fragment.isSupportVisible
    }


    private fun dispatchUserVisibleHint(visible: Boolean) {
        if (visible && isParentInvisible()) {
            return
        }

        //对子fragment不可见的限制，因为子fragment先于父fragment会调本方法，将mCurVisibleState只为false
        if (isSupportVisible == visible) {
            return
        }
        isSupportVisible = visible
        if (visible) {
            onFragmentResume()
            if (isFirstVisible && mIsViewCreated) {
                isFirstVisible = false
                onFragmentFirstVisible()
            }
            dispatchUserVisibleHint(true)
        } else {
            dispatchUserVisibleHint(false)
            onFragmentPause()
        }
    }

    open fun onFragmentFirstVisible() {}

    open fun onFragmentResume() {}

    open fun onFragmentPause() {}
}