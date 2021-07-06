package com.example.weatherapp.data.api

import android.app.Application
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

object Retrofitfactory{

    fun createNetworkClient(baseUrl: String, debug: Boolean = false): Retrofit.Builder =
        retrofitClient(baseUrl, httpClient(debug))


    private fun httpClient(debug: Boolean): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT)
        val clientBuilder = OkHttpClient.Builder().addInterceptor(QueryInterceptor())
        if (debug) {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            clientBuilder.addInterceptor(httpLoggingInterceptor)
        }

        return clientBuilder.build()
    }

    private fun retrofitClient(baseUrl: String, httpClient: OkHttpClient): Retrofit.Builder =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(httpClient)
            //.addConverterFactory(MoshiConverterFactory.create(moshiClient()))
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())

    private fun moshiClient() : Moshi =
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()


}

