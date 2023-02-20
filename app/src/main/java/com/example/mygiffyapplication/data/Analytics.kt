package com.example.mygiffyapplication.data


import com.google.gson.annotations.SerializedName

data class Analytics(
    @SerializedName("onclick")
    var onclick: Onclick? = Onclick(),
    @SerializedName("onload")
    var onload: Onload? = Onload(),
    @SerializedName("onsent")
    var onsent: Onsent? = Onsent()
)