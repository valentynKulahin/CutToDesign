package com.example.data.models

import com.google.gson.annotations.SerializedName

data class UserDataModel(
    @SerializedName("userId") val userId: String,
    @SerializedName("firstname") val firstname: String,
    @SerializedName("lastname") val lastname: String,
    @SerializedName("pmFirstname") val pmFirstname: String,
    @SerializedName("pmLastname") val pmLastname: String,
    @SerializedName("pmTelephone") val pmTelephone: String,
    @SerializedName("tsFirstname") val tsFirstname: String,
    @SerializedName("tsLastname") val tsLastname: String,
    @SerializedName("tsTelephone") val tsTelephone: String,
    @SerializedName("balance") val balance: Int,
    @SerializedName("bonusToday") val bonusToday: Int,
    @SerializedName("bonusTotal") val bonusTotal: Int,
    @SerializedName("bonusTitle") val bonusTitle: String
)