package com.example.weatherapp.data.model

import android.annotation.SuppressLint
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonClass
import com.squareup.moshi.Moshi

data class ListWeatherResponse(
    val cnt: Int,
    val list: List<WeatherResponse>?
)


data class WeatherResponse(

    val base: String,
    val clouds: Clouds?,
    val cod: Int,
    val coord: Coord?,
    val dt: Int,
    val id: Int,
    val main: Main?,
    val name: String,
    val sys: Sys?,
    val timezone: Int,
    val visibility: Int,
    val weather: List<Weather>?,
    val wind: Wind?
)

data class Clouds(
    val all: Int
)

data class Coord(
    val lat: Double,
    val lon: Double
)

data class Main(
    val temp: Double,
    val feels_like: Double,
    val temp_min: Double,
    val temp_max: Double,
    val pressure: Int,
    val sea_level: Int,
    val grnd_level: Int,
    val humidity: Int
)

data class Sys(
    val country: String,
    val sunrise: Int,
    val sunset: Int
)

data class Weather(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)

data class Wind(
    val deg: Int,
    val gust: Double,
    val speed: Double
)
