package com.example.weatherapp.di.module

import androidx.lifecycle.ViewModelProvider
import com.example.weatherapp.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
internal abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelFactory(modelProviderFactory: ViewModelProviderFactory): ViewModelProvider.Factory
}