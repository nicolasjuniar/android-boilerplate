package com.juniar.ancodev.android_boilerplate.feature.home

import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.juniar.ancodev.android_boilerplate.R
import com.juniar.ancodev.android_boilerplate.base.BaseActivity
import com.juniar.ancodev.android_boilerplate.feature.home.profile.ProfileFragment
import com.juniar.ancodev.android_boilerplate.feature.home.task.TaskFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.subjects.BehaviorSubject
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity() {

    private val subject: BehaviorSubject<Fragment> = BehaviorSubject.create()
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_task -> {
                subject.onNext(TaskFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_profile -> {
                subject.onNext(ProfileFragment())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun setupLayout() {
        setContentView(R.layout.activity_home)
        subject.onNext(TaskFragment())
    }

    override fun onViewReady() {
        subject.observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                supportFragmentManager.beginTransaction().replace(R.id.fl_content, it).commit()
            }.track()

        bottom_navigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }

}