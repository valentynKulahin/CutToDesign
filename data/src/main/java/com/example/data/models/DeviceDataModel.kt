package com.example.data.models

import com.google.gson.annotations.SerializedName

data class DeviceDataModel(
    @SerializedName("devman") val devman: String = "",
    @SerializedName("devmod") val devmod: String = "",
    @SerializedName("devavs") val devavs: String = "",
    @SerializedName("devaid") val devaid: String = ""
)
