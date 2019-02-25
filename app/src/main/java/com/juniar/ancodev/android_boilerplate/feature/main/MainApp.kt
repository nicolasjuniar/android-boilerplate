package com.juniar.ancodev.android_boilerplate.feature.main

import com.juniar.ancodev.android_boilerplate.DaggerAppComponent
import com.juniar.ancodev.android_boilerplate.NetworkModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class MainApp : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val appComponent = DaggerAppComponent.builder()
            .application(this)
            .networkModule(NetworkModule())
            .build()
        appComponent.inject(this)
        return appComponent
    }
}