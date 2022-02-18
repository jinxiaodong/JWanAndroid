package com.jarvis.login

import androidx.databinding.Observable
import androidx.databinding.ObservableField
import com.jarvis.libbase.base.BaseViewModel
import com.jarvis.login.repo.ILoginResource

/**
 * @author jinxiaodong
 * @description：
 * @date 2022/2/17
 */
class LoginViewModel(private val repo: ILoginResource) : BaseViewModel() {
    val userName = ObservableField<String>()
    val password = ObservableField<String>()
    val confirmPassword = ObservableField<String>()




}