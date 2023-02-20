package com.example.mygiffyapplication.data


import com.google.gson.annotations.SerializedName

data class Onclick(
    @SerializedName("url")
    var url: String? = ""
)