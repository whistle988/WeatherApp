package com.example.weatherapp.di.module

import androidx.viewbinding.BuildConfig
import com.example.weatherapp.data.api.ApiService
import com.example.weatherapp.data.api.Retrofitfactory.createNetworkClient
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class NetworkModule {

    @Provides
    internal fun providesRetrofit(): Retrofit =
        createNetworkClient("https://api.openweathermap.org/data/2.5/", BuildConfig.DEBUG)
            .build()

    @Provides
    internal fun provideWeatherService(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)

    /*@Provides
    internal fun provideWeatherForecastService(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)*/
}