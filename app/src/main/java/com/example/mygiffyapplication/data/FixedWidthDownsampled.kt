package com.example.mygiffyapplication.data


import com.google.gson.annotations.SerializedName

data class FixedWidthDownsampled(
    @SerializedName("height")
    var height: String? = "",
    @SerializedName("size")
    var size: String? = "",
    @SerializedName("url")
    var url: String? = "",
    @SerializedName("webp")
    var webp: String? = "",
    @SerializedName("webp_size")
    var webpSize: String? = "",
    @SerializedName("width")
    var width: String? = ""
)