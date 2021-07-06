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


    fun getWeatherListByIds(ids: String) {
        viewModelScope.launch {
            val r = apiService.getWeatherListByIds(ids, "metric")
            if (r.isSuccessful) {
                weatherList.value = r.body()!!.list
            }
        }
    }



}