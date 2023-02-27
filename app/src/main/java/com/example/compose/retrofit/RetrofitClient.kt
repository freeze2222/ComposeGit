package com.example.compose.retrofit

import android.util.Log
import okhttp3.internal.platform.android.AndroidLogHandler.flush
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.*
import java.net.Socket

object RetrofitClient {
    fun getClient(baseUrl: String): RetrofitServices {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitServices::class.java)
    }

    }
