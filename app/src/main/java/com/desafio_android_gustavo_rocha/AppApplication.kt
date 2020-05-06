package com.desafio_android_gustavo_rocha

import android.app.Application
import com.desafio_android_gustavo_rocha.di.modules.AppModules
import com.desafio_android_gustavo_rocha.di.modules.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AppApplication)
            modules(listOf(AppModules, uiModule))
        }
    }
}