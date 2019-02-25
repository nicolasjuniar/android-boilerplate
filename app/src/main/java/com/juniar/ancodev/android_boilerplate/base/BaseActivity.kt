package com.juniar.ancodev.android_boilerplate.base

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseActivity : DaggerAppCompatActivity() {

    private val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupLayout()
        onViewReady()
    }

    protected abstract fun setupLayout()
    protected abstract fun onViewReady()


    fun Disposable.track() {
        compositeDisposable.add(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }

}