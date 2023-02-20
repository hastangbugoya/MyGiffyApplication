package com.example.mygiffyapplication.data


import com.google.gson.annotations.SerializedName

data class PreviewGif(
    @SerializedName("height")
    var height: String? = "",
    @SerializedName("size")
    var size: String? = "",
    @SerializedName("url")
    var url: String? = "",
    @SerializedName("width")
    var width: String? = ""
)