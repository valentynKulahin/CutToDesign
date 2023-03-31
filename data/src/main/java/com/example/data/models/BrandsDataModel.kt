package com.example.data.models

import com.google.gson.annotations.SerializedName

data class BrandsDataModel(
    @SerializedName("brandsList") val brandsList: List<BrandDataModel> = emptyList()
)