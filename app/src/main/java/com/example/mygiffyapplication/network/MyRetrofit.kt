package com.example.mygiffyapplication.network

import com.example.mygiffyapplication.BuildConfig
import com.example.mygiffyapplication.data.Data
import com.example.mygiffyapplication.data.GiphyResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

class MyRetrofit {
    companion object {
        fun build() : Retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        fun getService() : GiphyAPIService = build().create(GiphyAPIService::class.java)
    }

}




















