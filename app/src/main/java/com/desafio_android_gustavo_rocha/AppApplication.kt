package com.desafio_android_gustavo_rocha

import android.app.Application
import com.desafio_android_gustavo_rocha.di.modules.daoModule
import com.desafio_android_gustavo_rocha.di.modules.retrofitModule
import com.desafio_android_gustavo_rocha.di.modules.uiModule
import com.desafio_android_gustavo_rocha.di.modules.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AppApplication)
            modules(
                listOf(
                    daoModule,
                    uiModule,
                    viewModelModule,
                    retrofitModule
                )
            )
        }
    }
}