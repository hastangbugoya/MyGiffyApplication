package com.example.mygiffyapplication.network

import com.example.mygiffyapplication.BuildConfig
import com.example.mygiffyapplication.data.GiphyResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GiphyAPIService {
    @GET("v1/gifs/trending")
    suspend fun getTrends(@Query("api_key") apiKey: String = BuildConfig.API_KEY,
                          @Query("limit") limit: Int = 25,
                          @Query("rating") rating: String = "G") : Response<GiphyResponse>
}