package com.example.weatherapp.ui.main.weather

import android.content.Intent.getIntent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapp.R
import com.example.weatherapp.ViewModelProviderFactory
import com.example.weatherapp.databinding.WeatherFragmentBinding
import com.example.weatherapp.ui.adapter.WeatherForecastAdapter
import dagger.android.support.DaggerFragment
import javax.inject.Inject


class WeatherFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory

    private var adapter: WeatherForecastAdapter? = null
    lateinit var viewBinding: WeatherFragmentBinding

    val weatherViewModel by lazy { ViewModelProvider(this, viewModelProviderFactory).get(
        WeatherViewModel::class.java) }

    var cityId: Int = 0


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewBinding = DataBindingUtil.inflate(inflater, R.layout.weather_fragment, container, false)
        viewBinding.lifecycleOwner = viewLifecycleOwner
        viewBinding.itemVM = weatherViewModel
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cityId = arguments?.getInt("id") ?: 0
        val cityName = arguments?.getString("cityName")


        weatherViewModel.getForecast(cityId)
        if (cityName != null) {
            weatherViewModel.getWeatherCity(cityName)
        }

        adapter = WeatherForecastAdapter(listOf())
        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        viewBinding.weatherForecastRecyclerView.layoutManager = layoutManager

        weatherViewModel.forecastCityList.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                adapter!!.setForecastList(it)
                viewBinding.weatherForecastRecyclerView.adapter = adapter
                adapter!!.notifyDataSetChanged()
            }
        })

        weatherViewModel.weatherCity.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                viewBinding.txtCity.text = it.name
                viewBinding.txtCityTemp.text = "now " + it.main!!.temp.toString() + "°C"
            }
        })
    }
}