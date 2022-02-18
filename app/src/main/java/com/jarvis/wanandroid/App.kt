package com.jarvis.wanandroid

import com.jarvis.libbase.base.BaseApp
import com.jarvis.login.di.moduleLogin
import com.jarvis.network.moduleNetWork
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

/**
 * @author jinxiaodong
 * @description：
 * @date 2022/2/18
 */
 class App :BaseApp() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@App)
            modules(moduleNetWork,moduleLogin)
        }
    }
}