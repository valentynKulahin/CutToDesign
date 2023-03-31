package com.example.data.models

import com.google.gson.annotations.SerializedName

data class BrandDataModel (
    @SerializedName ("brandId") val brandId: Int = 0,
    @SerializedName ("brandName") val brandName: String = "",
    @SerializedName ("brandImage") val brandImage: String = ""
)
