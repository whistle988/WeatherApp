package com.example.weatherapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.data.model.WeatherResponse
import com.example.weatherapp.databinding.ListItemBinding


class WeatherListAdapter(private var weatherList: List<WeatherResponse>) : RecyclerView.Adapter<WeatherListAdapter.WeatherViewHolder>() {

    fun setWeatherList(list: List<WeatherResponse>) {
        weatherList = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val itemBinding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WeatherViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        holder.bind(weatherList[position])
    }

    override fun getItemCount(): Int {
        return weatherList.size
    }

    inner class WeatherViewHolder(private val itemBinding: ListItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(response : WeatherResponse) {
            itemBinding.cityName.text = response.name
            itemBinding.temp.text = response.main.temp.toString()
            //view.app_image.setImageDrawable(weatherList[position].icon)
        }
    }

}
