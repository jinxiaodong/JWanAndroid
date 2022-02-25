package com.jarvis.login

import com.jarvis.lib.base.BaseActivity
import com.jarvis.login.databinding.ActivityLoginBinding

/**
 * @author jinxiaodong
 * @description：
 * @date 2022/2/17
 */
class LoginActivity : BaseActivity<ActivityLoginBinding>() {


    private val viewModel: LoginViewModel by viewModel()

    override fun getContentLayout() = R.layout.activity_login


    override fun initConfig() {
    }

    override fun initView() {
        binding.apply {
            model = viewModel
            close.setOnClickListener { finish() }
        }
    }


    override fun initData() {
    }

}