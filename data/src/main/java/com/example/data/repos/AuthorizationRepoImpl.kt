package com.example.data.repos

import com.example.data.api.AuthorizationRetrofitRepo
import com.example.data.models.UserDataModel
import com.example.data.models.UserDeviceDataModel
import com.example.domain.models.UserDeviceDomainModel
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
        return authorizationRetrofitRepo.getApiAddressAsync(
            appName = appName,
            versionApp = versionApp
        ).route
    }

    override suspend fun getLastVersionAsync(v: Int): Int {
        return authorizationRetrofitRepo.getLastVersionAsync(v = v.toString()).actual_version
    }

    override suspend fun postMyAuthorizationInfoAsync(
        userDeviceDomainModel: UserDeviceDomainModel
    ): String {
        return authorizationRetrofitRepo.postMyAuthorizationInfoAsync(
            login = userDeviceDomainModel.userAuthDomainModel.login,
            password = userDeviceDomainModel.userAuthDomainModel.password,
            devman = userDeviceDomainModel.deviceDomainModel.devman,
            devmod = userDeviceDomainModel.deviceDomainModel.devmod,
            devavs = userDeviceDomainModel.deviceDomainModel.devavs,
            devaid = userDeviceDomainModel.deviceDomainModel.devaid
        ).token
    }


}