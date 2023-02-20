package com.example.mygiffyapplication.data


import com.google.gson.annotations.SerializedName

data class Hd(
    @SerializedName("height")
    var height: String? = "",
    @SerializedName("mp4")
    var mp4: String? = "",
    @SerializedName("mp4_size")
    var mp4Size: String? = "",
    @SerializedName("width")
    var width: String? = ""
)