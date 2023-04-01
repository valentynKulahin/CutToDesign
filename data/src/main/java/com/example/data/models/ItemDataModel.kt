package com.example.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ItemDataModel(
    @SerializedName("itemId") @Expose val itemId: Int = 0,
    @SerializedName("itemName") @Expose val itemName: String = "",
    @SerializedName("itemImage") @Expose val itemImage: String = ""
)
