package com.juniar.ancodev.android_boilerplate

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class MainApp : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val appComponent = DaggerAppComponent
            .builder()
            .application(this)
            .networkModule(NetworkModule())
            .build()
        appComponent.inject(this)
        return appComponent
    }
}