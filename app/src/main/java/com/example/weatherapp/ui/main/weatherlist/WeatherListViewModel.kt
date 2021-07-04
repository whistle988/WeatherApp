package com.example.weatherapp.ui.main.weatherlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.api.ApiService
import com.example.weatherapp.data.model.ListWeatherResponse
import com.example.weatherapp.data.model.WeatherResponse
import kotlinx.coroutines.launch
import javax.inject.Inject

class WeatherListViewModel @Inject constructor(private val apiService : ApiService) : ViewModel() {

    var weatherList = MutableLiveData<List<WeatherResponse>>()
    lateinit var list : ListWeatherResponse

    fun getWeatherListByIds(ids: List<Int>) {
        viewModelScope.launch {
            val r = apiService.getWeatherListByIds(ids.joinToString(separator = ","))
            if (r.isSuccessful) {
                weatherList.value = r.body()
                //list.map { item -> item.toDomainModel() }
            }
        }
    }
/*
    fun getWeather(lat: Double, lon: Double) {
        viewModelScope.launch {
            val r = apiService.getWeather(lat, lon)
            if (r.isSuccessful) {
                weatherList.value = r.body()
            }
        }
    }*/


}