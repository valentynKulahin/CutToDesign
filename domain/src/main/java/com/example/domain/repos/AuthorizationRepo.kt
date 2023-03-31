package com.example.domain.repos

import android.telecom.Call

interface AuthorizationRepo {

    suspend fun getApiAddressAsync(appName: String, versionApp: String): String

    suspend fun getLastVersionAsync(v: Int): Int

    suspend fun postMyAuthorizationInfoAsync(
        login: String,
        password: String,
        devman: String,
        devmod: String,
        devavs: String,
        devaid: String
    )

}