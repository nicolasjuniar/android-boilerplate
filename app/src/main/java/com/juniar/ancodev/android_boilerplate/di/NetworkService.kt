package com.juniar.ancodev.android_boilerplate

import com.juniar.ancodev.android_boilerplate.Model.CountryModel
import io.reactivex.Observable
import retrofit2.http.GET

interface NetworkService {
    @GET("v2/all")
    fun getAllCountries(): Observable<MutableList<CountryModel>>
}