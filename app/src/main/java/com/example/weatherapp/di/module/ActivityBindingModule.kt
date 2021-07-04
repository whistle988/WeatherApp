package com.example.weatherapp.di.module

import com.example.weatherapp.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = [FragmentContainerModule::class, ViewModelModule::class])
    internal abstract fun contributeMainActivity(): MainActivity
}