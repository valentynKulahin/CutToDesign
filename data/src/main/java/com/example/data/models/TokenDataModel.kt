package com.example.data.models

import com.google.gson.annotations.SerializedName

data class TokenDataModel(
    @SerializedName("token") val token: String = ""
)