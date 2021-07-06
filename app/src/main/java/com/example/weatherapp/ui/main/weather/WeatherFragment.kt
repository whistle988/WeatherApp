package com.example.weatherapp.ui.main.weather

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.weatherapp.R
import com.example.weatherapp.ViewModelProviderFactory
import com.example.weatherapp.databinding.WeatherFragmentBinding
import com.example.weatherapp.extension.debug
import com.example.weatherapp.ui.adapter.WeatherForecastAdapter
import com.example.weatherapp.ui.adapter.WeatherListAdapter
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class WeatherFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory

    private var adapter: WeatherForecastAdapter? = null
    lateinit var viewBinding: WeatherFragmentBinding

    val weatherViewModel by lazy { ViewModelProvider(this, viewModelProviderFactory).get(
        WeatherViewModel::class.java) }

    //var cityId: DoubleArray = doubleArrayOf()
    var cityId: Int = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewBinding = DataBindingUtil.inflate(inflater, R.layout.weather_fragment, container, false)
        viewBinding.lifecycleOwner = viewLifecycleOwner
        viewBinding.itemVM = weatherViewModel
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //cityId = (arguments?.getDoubleArray("id") ?: 0.0) as DoubleArray
        cityId = arguments?.getInt("id") ?: 0

        weatherViewModel.getForecast(cityId)
        weatherViewModel.getWeatherCity("Yakutsk")

        adapter = WeatherForecastAdapter(listOf())

        weatherViewModel.forecastList.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                adapter!!.setWeatherList(it)
                viewBinding.weatherForecastRecyclerView.adapter = adapter
                adapter!!.notifyDataSetChanged()
            }
        })

        weatherViewModel.weatherCity.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                debug(it.name)
                viewBinding.txtCity.text = it.name
                viewBinding.txtCityTemp.text = it.main.temp.toString()
                //viewBinding.txtCondition.text = it.weather.main
                //debug("temp = " + it.foreList.list!!.main!!.temp.toString())

                //weatherViewModel.cityTemp.value = it.list!!.main!!.temp.toString()

                //weatherViewModel.condition.value = it.list.weather!!.main
                //weatherViewModel.dayAndLocation.value = it.cardTypeName
            }
        })
    }
}