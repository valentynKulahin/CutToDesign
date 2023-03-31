package com.example.cuttodesign.ui.screens.authorization

data class AuthorizationScreenContract(
    val version: Int = 0,
    val token: String = "",
    val login: String = "",
    val password: String = "",
    val devman: String = "",
    val devmod: String = "",
    val devavs: String = "",
    val devaid: String = ""

//    val userAuthDomainModel: UserAuthDomainModel = UserAuthDomainModel("", "", ""),
//    val deviceDomainModel: DeviceDomainModel = DeviceDomainModel("", "", "", "")
)