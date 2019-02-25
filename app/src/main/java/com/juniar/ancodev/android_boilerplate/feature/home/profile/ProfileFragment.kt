package com.juniar.ancodev.android_boilerplate.feature.home.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.juniar.ancodev.android_boilerplate.R
import dagger.android.support.DaggerFragment

class ProfileFragment : DaggerFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        inflater.inflate(R.layout.fragment_profile, container, false)

}