package com.example.domain.repos

import com.example.domain.models.UserDeviceDomainModel

interface AuthorizationRepo {

    suspend fun getApiAddressAsync(appName: String, versionApp: String): String

    suspend fun getLastVersionAsync(v: Int): Int

    suspend fun postMyAuthorizationInfoAsync(
        userDeviceDomainModel: UserDeviceDomainModel
    ): String

}