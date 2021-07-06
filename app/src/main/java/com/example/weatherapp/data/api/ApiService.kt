package com.example.weatherapp.data.api

import com.example.weatherapp.data.model.ListWeatherResponse
import com.example.weatherapp.data.model.WeatherResponse
import com.example.weatherapp.data.model.forecast.ForecastList
import com.example.weatherapp.data.model.forecast.ForecastResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("group")
    suspend fun getWeatherListByIds(
        @Query("id") id: String,
        @Query("units") units: String
    ): Response<ListWeatherResponse>

    @GET("weather")
    suspend fun getWeatherCity(
        @Query("q") q: String,
        @Query("units") units: String
    ): Response<WeatherResponse>

    @GET("forecast")
    suspend fun getForecastCity(
        @Query("id") id: Int
    ): Response<ForecastList>



}