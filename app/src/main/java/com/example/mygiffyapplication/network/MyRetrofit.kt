package com.example.mygiffyapplication.network

import com.example.mygiffyapplication.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
class MyRetrofit {
    companion object {
        fun build() : Retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        fun getService() : GiphyAPIService = build().create(GiphyAPIService::class.java)
    }
}




















