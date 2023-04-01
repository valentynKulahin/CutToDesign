package com.example.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ItemsDataModel(
    @SerializedName("items") @Expose val items: ItemDataModel = ItemDataModel()
)