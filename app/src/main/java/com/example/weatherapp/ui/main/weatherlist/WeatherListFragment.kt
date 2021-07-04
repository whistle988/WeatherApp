package com.example.weatherapp.ui.main.weatherlist

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.example.weatherapp.R
import com.example.weatherapp.ViewModelProviderFactory
import com.example.weatherapp.data.api.DataHolder
import com.example.weatherapp.databinding.WeatherListFragmentBinding
import com.example.weatherapp.ui.adapter.WeatherListAdapter
import com.example.weatherapp.ui.base.BaseFragment
import javax.inject.Inject

class WeatherListFragment : BaseFragment(R.layout.weather_list_fragment) {

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory

    private lateinit var weatherListviewModel: WeatherListViewModel

    private var adapter: WeatherListAdapter? = null
    private var viewBinding: WeatherListFragmentBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = WeatherListFragmentBinding.bind(view)

        setupViewModel()
        setupUI()
        setupObservers()


    }

    private fun setupViewModel() {
        //viewModel = ViewModelProvider(this).get(WeatherListViewModel::class.java)
        weatherListviewModel = ViewModelProvider(this, viewModelProviderFactory).get(WeatherListViewModel::class.java)
    }

    private fun setupUI() {
        //viewModel.getWeather()

        weatherListviewModel.getWeatherListByIds(DataHolder.citiesId)

        weatherListviewModel.weatherList.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                adapter!!.setWeatherList(it)
                adapter!!.notifyDataSetChanged()
                viewBinding!!.rvWeatherList.adapter = adapter
            }
        })

    }

    private fun setupObservers() {


    }

    override fun onDestroyView() {
        viewBinding = null
        super.onDestroyView()
    }

}