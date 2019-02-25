package com.juniar.ancodev.android_boilerplate

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.juniar.ancodev.android_boilerplate.Model.CountryModel
import com.juniar.ancodev.android_boilerplate.base.BaseActivity
import com.juniar.ancodev.android_boilerplate.common.GeneralRecyclerViewAdapter
import com.juniar.ancodev.android_boilerplate.utils.loadImage
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.viewholder_country.view.*
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var mainViewModel: MainViewModel

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    private var listCountries = mutableListOf<CountryModel>()

    private val listAdapter by lazy {
        GeneralRecyclerViewAdapter(R.layout.viewholder_country, listCountries, { _, _, _ -> }, { country, view ->
            view.tv_country_name.text = country.name
            view.tv_country_region.text = country.region
            view.iv_country_flag.loadImage(country.flag)
        })
    }

    override fun setupLayout() {
        setContentView(R.layout.activity_main)
        rv_countries.apply {
            adapter = listAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    override fun onViewReady() {
        mainViewModel = ViewModelProviders.of(this@MainActivity, mainViewModelFactory)[MainViewModel::class.java]
        mainViewModel.getAllCountries()
        mainViewModel.fetchList().observe(this, observeListCountries())
    }

    private fun observeListCountries(): Observer<MutableList<CountryModel>> {
        return Observer {
            listCountries.addAll(it)
            listAdapter.notifyDataSetChanged()
        }
    }
}
