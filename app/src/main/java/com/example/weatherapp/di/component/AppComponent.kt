package com.example.weatherapp.di.component

import android.app.Application
import com.example.weatherapp.di.module.*
import com.example.weatherapp.di.module.ViewModelFactoryModule
import com.example.weatherapp.ui.base.BaseApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBindingModule::class,
        AppModule::class,
        ViewModelFactoryModule::class,
        NetworkModule::class
        //ViewModelModule::class,

    ]
)

interface AppComponent : AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }
}