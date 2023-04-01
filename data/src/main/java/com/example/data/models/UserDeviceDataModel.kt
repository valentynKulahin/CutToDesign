package com.example.data.models

import com.google.gson.annotations.SerializedName

data class UserDeviceDataModel(
    @SerializedName("login") val login: String = "",
    @SerializedName("password") val password: String = "",
    @SerializedName("devman") val devman: String = "",
    @SerializedName("devmod") val devmod: String = "",
    @SerializedName("devavs") val devavs: String = "",
    @SerializedName("devaid") val devaid: String = ""
)
