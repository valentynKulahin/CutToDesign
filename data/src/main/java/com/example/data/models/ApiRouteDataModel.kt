package com.example.data.models

import com.google.gson.annotations.SerializedName

data class ApiRouteDataModel(
    @SerializedName("route") val route: String
)