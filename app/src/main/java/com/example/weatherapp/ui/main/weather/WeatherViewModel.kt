package com.example.weatherapp.ui.main.weather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.api.ApiService
import com.example.weatherapp.data.model.WeatherResponse
import com.example.weatherapp.data.model.forecast.CityWeather
import kotlinx.coroutines.launch
import javax.inject.Inject

class WeatherViewModel @Inject constructor(private val apiService : ApiService): ViewModel() {

    var forecastCityList = MutableLiveData<List<CityWeather>>()
    var weatherCity = MutableLiveData<WeatherResponse>()


    fun getForecast(id: Int) {
        viewModelScope.launch {
            val r = apiService.getForecastCity(id, "metric")
            if (r.isSuccessful) {
                forecastCityList.value = r.body()!!.list!!
            }
        }
    }

    fun getWeatherCity(city: String) {
        viewModelScope.launch {
            val r = apiService.getWeatherCity(city, "metric")
            if (r.isSuccessful) {
                weatherCity.value = r.body()
            }
        }
    }
}