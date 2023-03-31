package com.example.domain.models

data class UserDomainModel(
    val userId: String,
    val firstname: String,
    val lastname: String,
    val pmFirstname: String,
    val pmLastname: String,
    val pmTelephone: String,
    val tsFirstname: String,
    val tsLastname: String,
    val tsTelephone: String,
    val balance: Int,
    val bonusToday: Int,
    val bonusTotal: Int,
    val bonusTitle: String
)