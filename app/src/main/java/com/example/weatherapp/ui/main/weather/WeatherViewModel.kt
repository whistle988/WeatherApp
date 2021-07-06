package com.example.weatherapp.ui.main.weather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.api.ApiService
import com.example.weatherapp.data.model.WeatherResponse
import com.example.weatherapp.data.model.forecast.ForecastList
import com.example.weatherapp.data.model.forecast.ForecastResponse
import com.example.weatherapp.extension.debug
import kotlinx.coroutines.launch
import javax.inject.Inject

class WeatherViewModel @Inject constructor(private val apiService : ApiService): ViewModel() {

    var weatherItem = MutableLiveData<List<ForecastResponse>>()
    var forecastList = MutableLiveData<List<ForecastResponse>>()
    var weatherCity = MutableLiveData<WeatherResponse>()

    var cityTemp = MutableLiveData<String?>()
    var condition = MutableLiveData<String?>()
    var dayAndLocation = MutableLiveData<String?>()
    var cityName = MutableLiveData<String?>()


    fun getForecast(id: Int) {
        viewModelScope.launch {
            debug("id in VM = " + id)
            val r = apiService.getForecastCity(id)
            if (r.isSuccessful) {
                weatherItem.value = r.body()!!.foreList
                //debug(r.body()!!.foreList)
                //weatherItem.
            }
        }
    }

    fun getWeatherCity(city: String) {
        viewModelScope.launch {
            debug("id in VM = " + city)
            val r = apiService.getWeatherCity(city, "metric")
            if (r.isSuccessful) {
                weatherCity.value = r.body()
                debug("vm3 = " + weatherCity)
                //cityName.value = weatherCity.value!!.name

                //debug(weatherCity.value!!.name)
                //weatherItem.
            }
        }
    }

    /*fun getWeatherForecastList(id: Int) {
        viewModelScope.launch {
            val r = apiService.getForecastCity(id)
            if (r.isSuccessful) {
                weatherItem.value = r.body()
            }
        }
    }*/

}