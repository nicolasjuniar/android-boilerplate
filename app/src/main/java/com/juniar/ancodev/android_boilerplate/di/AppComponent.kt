package com.juniar.ancodev.android_boilerplate

import android.app.Application
import com.example.mvvm_movie.di.FragmentBuilder
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, NetworkModule::class, ActivityBuilder::class, FragmentBuilder::class])
interface AppComponent : AndroidInjector<DaggerApplication> {
    fun inject(application: MainApp)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun networkModule(networkModule: NetworkModule): Builder
        fun build(): AppComponent
    }
}
