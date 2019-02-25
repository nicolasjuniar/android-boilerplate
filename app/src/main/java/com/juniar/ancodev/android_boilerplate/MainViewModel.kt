package com.juniar.ancodev.android_boilerplate

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.juniar.ancodev.android_boilerplate.Model.CountryModel
import com.juniar.ancodev.android_boilerplate.base.BaseViewModel
import com.juniar.ancodev.android_boilerplate.data.NetworkRepository
import com.juniar.ancodev.android_boilerplate.utils.uiSubscribe
import javax.inject.Inject

@ActivityScoped
class MainViewModel @Inject constructor(private val networkRepository: NetworkRepository) : BaseViewModel() {

    private var countryResponse = MutableLiveData<MutableList<CountryModel>>()

    fun getAllCountries() {
        compositeDisposable.addAll(
            networkRepository.getAllCountries()
                .uiSubscribe({
                    countryResponse.value = it
                }, {
                })
        )
    }

    fun fetchList() = countryResponse
}

@ActivityScoped
class MainViewModelFactory @Inject constructor(private val networkRepository: NetworkRepository) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(networkRepository) as T
    }
}