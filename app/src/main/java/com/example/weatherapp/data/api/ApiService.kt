package com.example.weatherapp.data.api

import com.example.weatherapp.data.model.ListWeatherResponse
import com.example.weatherapp.data.model.WeatherResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("group")
    suspend fun getWeatherListByIds(@Query("id") id: String
    ): Response<List<WeatherResponse>>

    @GET("weather")
    suspend fun getWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double
    ): Response<WeatherResponse>



}