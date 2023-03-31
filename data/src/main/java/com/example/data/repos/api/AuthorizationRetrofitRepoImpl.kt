package com.example.data.repos.api

import com.example.data.api.AuthorizationRetrofitRepo
import com.example.data.api.retrofit.RetrofitHelper
import com.example.data.models.ActualVersionDataModel
import com.example.data.models.ApiRouteDataModel
import com.example.domain.repos.DataStoreRepo
import kotlinx.coroutines.flow.first
import retrofit2.Call
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthorizationRetrofitRepoImpl @Inject constructor(
    private val dataStoreRepo: DataStoreRepo
): AuthorizationRetrofitRepo {

    lateinit var retrofit: AuthorizationRetrofitRepo

    override suspend fun getApiAddress(
        appName: String,
        versionApp: String
    ): ApiRouteDataModel {
        val retrofitHelper =
            RetrofitHelper.getInstanceFirst(dataStoreRepo.getFirstRouteApi().first().toString())

        val apiRoute: ApiRouteDataModel = try {
            retrofitHelper.getApiAddress(appName = appName, versionApp = versionApp)
        } catch (e: Exception) {
            ApiRouteDataModel("")
        }

        return apiRoute
    }

    override suspend fun getLastVersionAsync(v: String): ActualVersionDataModel {
        retrofit = RetrofitHelper.getInstanceAuth(dataStoreRepo.getRouteApi().first().toString())

        val lastVersion: ActualVersionDataModel = try {
            retrofit.getLastVersionAsync(v = v)
        } catch (e: Exception) {
            ActualVersionDataModel(0)
        }

        return lastVersion
    }

    override suspend fun postMyAuthorizationInfoAsync(
        login: String,
        password: String,
        devman: String,
        devmod: String,
        devavs: String,
        devaid: String
    ): Call<String> {
        TODO("Not yet implemented")
    }

}