package com.example.weatherapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import com.example.weatherapp.data.model.forecast.ForecastResponse

class WeatherForecastAdapter (private var forecastList: List<ForecastResponse>) :
    RecyclerView.Adapter<WeatherForecastAdapter.ViewHolder>() {

    fun setWeatherList(list: List<ForecastResponse>) {
        forecastList = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.forecast_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(forecastList[position])
    }

    override fun getItemCount(): Int {
        return forecastList.size
    }

    inner class ViewHolder(v : View) : RecyclerView.ViewHolder(v) {

        val txtForecastDay : TextView
        val tempTextView: TextView


        init {
            txtForecastDay = v.findViewById(R.id.city_name)
            tempTextView = v.findViewById(R.id.temp)

        }

        fun bind(response : ForecastResponse) {
            //txtForecastDay.text = response.city.toString()
            //tempTextView.text = response.list?.main?.temp.toString()
            //view.app_image.setImageDrawable(weatherList[position].icon)

        }
    }

}


