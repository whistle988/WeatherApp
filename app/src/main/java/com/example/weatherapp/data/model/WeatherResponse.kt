package com.example.weatherapp.data.model


data class ListWeatherResponse(
    val list: List<WeatherResponse>
)

data class WeatherResponse(
    val base: String,
    val clouds: Clouds,
    val cod: Int,
    val coord: Coord,
    val dt: Int,
    val id: Int,
    val main: Main,
    val name: String,
    val sys: Sys,
    val timezone: Int,
    val visibility: Int,
    val weather: List<Weather>,
    val wind: Wind
) {
    fun toDomainModel() =
        CityWeather(
            id,
            name,
            main.humidity,
            main.pressure,
            main.temp,
            main.temp_max,
            main.temp_min,
            wind.speed,
            weather.firstOrNull()?.main ?: "",
            weather.firstOrNull()?.icon ?: ""
        )
}

data class Clouds(
    val all: Int
)

data class Coord(
    val lat: Double,
    val lon: Double
)

data class Main(
    val feels_like: Double,
    val grnd_level: Int,
    val humidity: Int,
    val pressure: Int,
    val sea_level: Int,
    val temp: Double,
    val temp_max: Double,
    val temp_min: Double
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

data class CityWeather(
    val id: Int = 0,
    val name: String = "",
    val humidity: Int = 0,
    val pressure: Int = 0,
    val temp: Double = 0.0,
    val tempMax: Double = 0.0,
    val tempMin: Double = 0.0,
    val windSpeed: Double = 0.0,
    val condition: String = "",
    val icon: String = ""
)