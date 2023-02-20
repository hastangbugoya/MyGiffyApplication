package com.example.mygiffyapplication.data


import com.google.gson.annotations.SerializedName

data class Looping(
    @SerializedName("mp4")
    var mp4: String? = "",
    @SerializedName("mp4_size")
    var mp4Size: String? = ""
)