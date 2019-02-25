package com.juniar.ancodev.android_boilerplate.feature.splashscreen

import android.content.Intent
import android.os.Handler
import com.juniar.ancodev.android_boilerplate.R
import com.juniar.ancodev.android_boilerplate.base.BaseActivity
import com.juniar.ancodev.android_boilerplate.feature.main.MainActivity

class SplashScreenActivity : BaseActivity() {

    override fun setupLayout() {
        setContentView(R.layout.activity_splashscreen)
    }

    override fun onViewReady() {
        Handler().postDelayed({
            startActivity(Intent(this@SplashScreenActivity, MainActivity::class.java))
            finish()
        }, 2000)
    }
}