package com.example.weatherapp.di.module

import com.example.weatherapp.ui.main.weather.WeatherFragment
import com.example.weatherapp.ui.main.weatherlist.WeatherListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentContainerModule {

    @ContributesAndroidInjector
    abstract fun provideWeatherListFragment(): WeatherListFragment

    @ContributesAndroidInjector
    abstract fun provideWeatherFragment(): WeatherFragment

}