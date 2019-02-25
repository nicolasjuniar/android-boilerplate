package com.juniar.ancodev.android_boilerplate.data

import com.juniar.ancodev.android_boilerplate.Model.CountryModel
import io.reactivex.Observable

interface Repository {
    fun getAllCountries(): Observable<MutableList<CountryModel>>
}