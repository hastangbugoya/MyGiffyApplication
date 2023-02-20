package com.example.mygiffyapplication.data


import com.google.gson.annotations.SerializedName

data class Pagination(
    @SerializedName("count")
    var count: Int? = 0,
    @SerializedName("offset")
    var offset: Int? = 0,
    @SerializedName("total_count")
    var totalCount: Int? = 0
)