package com.example.weatherapp.ui.adapter

import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filterable
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import com.example.weatherapp.data.model.forecast.CityWeather
import java.text.SimpleDateFormat
import java.util.*

class WeatherForecastAdapter (private var forecastList: List<CityWeather>) :
    RecyclerView.Adapter<WeatherForecastAdapter.ViewHolder>() {

    private val limit = 18

    fun setForecastList(list: List<CityWeather>) {
        forecastList = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.forecast_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(forecastList[position])
    }

    override fun getItemCount(): Int {
        /*if(forecastList.size > limit){
            return limit
        }
        else
        {
            return forecastList.size
        }*/
        return forecastList.size
    }

    inner class ViewHolder(v : View) : RecyclerView.ViewHolder(v) {

        val txtForecastDay : TextView
        val tempTextView: TextView


        init {
            txtForecastDay = v.findViewById(R.id.txtForecastDay)
            tempTextView = v.findViewById(R.id.tempTextView)

        }

        fun bind(response: CityWeather) {

            val format =  SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            val date = format.parse(response.dt_txt)
            val dayOfTheWeek = DateFormat.format("MMMM.dd hh:mm aaa", date) as String // Thursday


            //txtForecastDay.text = response.city.toString()
            txtForecastDay.text = dayOfTheWeek
            //tempTextView.text = response.list.main.temp.toString()
            tempTextView.text = response.main!!.temp.toString()+"°C"
            //view.app_image.setImageDrawable(weatherList[position].icon)


        }
    }

    /*fun Long.getDayOfTheWeek(): String {
        return SimpleDateFormat("EEE", Locale.US).format(Date(this * 1000))
    }*/

}


