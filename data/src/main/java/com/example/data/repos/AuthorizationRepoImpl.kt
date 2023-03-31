package com.example.data.repos

import com.example.data.api.AuthorizationRetrofitRepo
import com.example.domain.repos.AuthorizationRepo
import com.example.domain.repos.DataStoreRepo
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.math.log

@Singleton
class AuthorizationRepoImpl @Inject constructor(
    private val authorizationRetrofitRepo: AuthorizationRetrofitRepo
) : AuthorizationRepo {

    override suspend fun getApiAddressAsync(appName: String, versionApp: String): String {
        return authorizationRetrofitRepo.getApiAddress(appName = appName, versionApp = versionApp).route
    }

    override suspend fun getLastVersionAsync(v: Int): Int {
        return authorizationRetrofitRepo.getLastVersionAsync(v = v.toString()).actual_version
    }

    override suspend fun postMyAuthorizationInfoAsync(
        login: String,
        password: String,
        devman: String,
        devmod: String,
        devavs: String,
        devaid: String
    ) {
        authorizationRetrofitRepo.postMyAuthorizationInfoAsync(
            login = login,
            password = password,
            devman = devman,
            devmod = devmod,
            devavs = devavs,
            devaid = devaid
        )
    }


}