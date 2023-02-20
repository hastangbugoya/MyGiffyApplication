package com.example.mygiffyapplication.data


import com.google.gson.annotations.SerializedName

data class FixedHeight(
    @SerializedName("height")
    var height: String? = "",
    @SerializedName("mp4")
    var mp4: String? = "",
    @SerializedName("mp4_size")
    var mp4Size: String? = "",
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