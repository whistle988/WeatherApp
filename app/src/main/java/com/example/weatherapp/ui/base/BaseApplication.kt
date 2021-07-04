package com.example.weatherapp.ui.base

import android.annotation.SuppressLint
import com.example.weatherapp.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

@SuppressLint("Registered")
open class BaseApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }
}