package com.example.mygiffyapplication.data


import com.google.gson.annotations.SerializedName

data class Onload(
    @SerializedName("url")
    var url: String? = ""
)