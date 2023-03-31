package com.example.data.models

import com.google.gson.annotations.SerializedName

data class ItemDataModel(
    @SerializedName("itemId") val itemId: Int = 0,
    @SerializedName("itemName") val itemName: String = "",
    @SerializedName("itemImage") val itemImage: String = ""
)
