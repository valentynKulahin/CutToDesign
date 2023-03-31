package com.example.data.models

import com.google.gson.annotations.SerializedName

data class ItemsDataModel(
    @SerializedName("items") val items: List<ItemDataModel> = emptyList()
)