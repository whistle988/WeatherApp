package com.example.weatherapp.ui.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import dagger.android.support.DaggerFragment

abstract class BaseFragment : DaggerFragment(){



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //initViews(view)
        //initViewModel()
    }

    open fun initViews(view: View) {
    }

    open fun initViewModel() {
    }

}