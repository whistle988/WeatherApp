package com.example.weatherapp

import com.example.weatherapp.di.component.DaggerAppComponent
import com.example.weatherapp.ui.base.BaseApplication
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class WeatherApp : BaseApplication() {

    override fun onCreate() {
        super.onCreate()
        //setDefaultUiMode()
    }

    /*override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }*/
}