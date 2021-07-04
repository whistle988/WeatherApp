package com.example.weatherapp.data.api

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class QueryInterceptor : Interceptor {

    private val API_KEY = "18195cd7c6079eb176dc6e1485510648"

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        var request: Request = chain.request()
        val url: HttpUrl = request.url.newBuilder()
            .addQueryParameter("appid", API_KEY)
            .addQueryParameter("units", DataHolder.unit)
            .build()
        request = request.newBuilder().url(url).build()
        return chain.proceed(request)
    }
}