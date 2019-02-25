package com.example.mvvm_movie.di

import android.annotation.SuppressLint
import com.juniar.ancodev.android_boilerplate.feature.home.profile.ProfileFragment
import com.juniar.ancodev.android_boilerplate.feature.home.task.TaskFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@SuppressLint("unused")
@Module
abstract class FragmentBuilder {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun provideTaskFragment(): TaskFragment


    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun provideProfileFragment(): ProfileFragment
}