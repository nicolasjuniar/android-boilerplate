package com.juniar.ancodev.android_boilerplate

import android.annotation.SuppressLint
import com.juniar.ancodev.android_boilerplate.feature.home.HomeActivity
import com.juniar.ancodev.android_boilerplate.feature.main.MainActivity
import com.juniar.ancodev.android_boilerplate.feature.splashscreen.SplashScreenActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@SuppressLint("unused")
@Module
abstract class ActivityBuilder {

    @ActivityScoped
    @ContributesAndroidInjector
    abstract fun provideSplashScreenActivity(): SplashScreenActivity

    @ActivityScoped
    @ContributesAndroidInjector
    abstract fun provideHomeActivity(): HomeActivity

    @ActivityScoped
    @ContributesAndroidInjector
    abstract fun provideMainActivity(): MainActivity

}