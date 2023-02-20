package com.example.mygiffyapplication.data


import com.google.gson.annotations.SerializedName

data class GiphyResponse(
    @SerializedName("data")
    var `data`: List<Data>? = listOf(),
//    @SerializedName("meta")
//    var meta: Meta? = Meta(),
//    @SerializedName("pagination")
//    var pagination: Pagination? = Pagination()
)