package com.jarvis.libbase.core

import android.app.Application
import com.jarvis.libbase.exception.AppException
import java.lang.IllegalStateException

/**
 * @author jinxiaodong
 * @description：
 * @date 2022/2/10
 */
object ApplicationHolder {
    private lateinit var app: Application


    fun init(app: Application) {
        this.app = app
    }

    fun get(): Application {
        if (this::app.isInitialized) {
            return app
        }
        throw IllegalStateException("Application $this not init")
    }
}