package com.juniar.ancodev.android_boilerplate.data

import com.juniar.ancodev.android_boilerplate.Model.CountryModel
import com.juniar.ancodev.android_boilerplate.NetworkService
import io.reactivex.Observable
import javax.inject.Inject

class NetworkRepository @Inject constructor(val networkService: NetworkService) : Repository {
    override fun getAllCountries(): Observable<MutableList<CountryModel>> {
        return networkService
            .getAllCountries()
    }

}