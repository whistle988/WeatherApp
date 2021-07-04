package com.example.weatherapp.di.module

import com.example.weatherapp.ui.main.weather.WeatherFragment
import com.example.weatherapp.ui.main.weatherlist.WeatherListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/*
@Module(
    includes = [
        FragmentContainerModule.WeatherLisAbstractModule::class,
        FragmentContainerModule.WeatherAbstractModule::class
    ]
)

class FragmentContainerModule {

    @Module
    interface WeatherLisAbstractModule {
        @FragmentScoped
        @ContributesAndroidInjector
        fun weatherListFragment(): WeatherListFragment
    }

    @Module
    interface WeatherAbstractModule {
        @FragmentScoped
        @ContributesAndroidInjector
        fun weatherFragment(): WeatherFragment
    }

}*/
@Module
abstract class FragmentContainerModule {

    @ContributesAndroidInjector
    abstract fun provideWeatherListFragment(): WeatherListFragment

    /*@ContributesAndroidInjector
    abstract fun provideWeatherFragment(): WeatherFragment*/

}