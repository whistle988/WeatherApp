package com.example.weatherapp.di.module

import androidx.lifecycle.ViewModel
import com.example.weatherapp.di.ViewModelKey
import com.example.weatherapp.ui.main.weather.WeatherViewModel
import com.example.weatherapp.ui.main.weatherlist.WeatherListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    /*@Binds
    @AppScoped
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory*/

    @Binds
    @IntoMap
    @ViewModelKey(WeatherListViewModel::class)
    abstract fun bindWeatherListViewModel(viewModel: WeatherListViewModel): ViewModel

    /*@Binds
    @IntoMap
    @ViewModelKey(WeatherViewModel::class)
    abstract fun bindWeatherViewModel(viewModel: WeatherViewModel): ViewModel*/
}