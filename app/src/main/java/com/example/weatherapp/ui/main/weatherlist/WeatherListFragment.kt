package com.example.weatherapp.ui.main.weatherlist

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.weatherapp.R
import com.example.weatherapp.ViewModelProviderFactory
import com.example.weatherapp.data.api.DataHolder
import com.example.weatherapp.databinding.WeatherListFragmentBinding
import com.example.weatherapp.ui.adapter.WeatherListAdapter
import com.example.weatherapp.ui.base.BaseFragment
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class WeatherListFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory

    ///private lateinit var weatherListviewModel: WeatherListViewModel

    private var adapter: WeatherListAdapter? = null
    lateinit var viewBinding: WeatherListFragmentBinding


    val weatherListviewModel by lazy { ViewModelProvider(this, viewModelProviderFactory).get(WeatherListViewModel::class.java) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        viewBinding = DataBindingUtil.inflate(inflater, R.layout.weather_list_fragment, container, false)
        viewBinding.lifecycleOwner = viewLifecycleOwner
        viewBinding.vm = weatherListviewModel
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //viewModel.getWeather()

        weatherListviewModel.getWeatherListByIds("2013159,4399153,498817")

        adapter = WeatherListAdapter(listOf())

        weatherListviewModel.weatherList.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                adapter!!.setWeatherList(it)
                viewBinding.rvWeatherList.adapter = adapter
                adapter!!.notifyDataSetChanged()
            }
        })

    }

}