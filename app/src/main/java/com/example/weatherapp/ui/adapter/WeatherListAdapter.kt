package com.example.weatherapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import com.example.weatherapp.data.model.WeatherResponse
import org.w3c.dom.Text


class WeatherListAdapter(private var weatherList: List<WeatherResponse>) : RecyclerView.Adapter<WeatherListAdapter.ViewHolder>() {

    fun setWeatherList(list: List<WeatherResponse>) {
        weatherList = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(weatherList[position])
    }

    override fun getItemCount(): Int {
        return weatherList.size
    }

    inner class ViewHolder(var v : View) : RecyclerView.ViewHolder(v) {

        val cityName : TextView
        val temp: TextView

        init {
            cityName = v.findViewById(R.id.city_name)
            temp = v.findViewById(R.id.temp)
        }

        fun bind(response : WeatherResponse) {
            cityName.text = response.name
            temp.text = response.main.temp.toString()
            //view.app_image.setImageDrawable(weatherList[position].icon)
        }
    }

}


