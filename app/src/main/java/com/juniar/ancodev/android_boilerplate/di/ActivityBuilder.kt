package com.juniar.ancodev.android_boilerplate

import android.annotation.SuppressLint
import dagger.Module
import dagger.android.ContributesAndroidInjector


@SuppressLint("unused")
@Module
abstract class ActivityBuilder{

    @ActivityScoped
    @ContributesAndroidInjector
    abstract fun providesMainActivity() : MainActivity



}