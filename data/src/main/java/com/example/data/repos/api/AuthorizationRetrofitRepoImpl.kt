package com.example.data.repos.api

import android.media.session.MediaSession.Token
import android.util.Log
import com.example.data.api.AuthorizationRetrofitRepo
import com.example.data.api.retrofit.RetrofitHelper
import com.example.data.datastore.PreferencesKeys.token
import com.example.data.models.*
import com.example.domain.models.UserDeviceDomainModel
import com.example.domain.repos.DataStoreRepo
import kotlinx.coroutines.flow.first
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthorizationRetrofitRepoImpl @Inject constructor(
    private val dataStoreRepo: DataStoreRepo
) : AuthorizationRetrofitRepo {

    private lateinit var retrofit: AuthorizationRetrofitRepo

    override suspend fun getApiAddressAsync(
        appName: String,
        versionApp: String
    ): ApiRouteDataModel {
        val retrofitHelper =
            RetrofitHelper.getInstanceFirst(dataStoreRepo.getFirstRouteApi().first().toString())

        val apiRoute: ApiRouteDataModel = try {
            retrofitHelper.getApiAddressAsync(appName = appName, versionApp = versionApp)
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
    ): TokenDataModel {

        val token: TokenDataModel = try {
            retrofit.postMyAuthorizationInfoAsync(
                login = login,
                password = password,
                devman = devman,
                devmod = devmod,
                devavs = devavs,
                devaid = devaid
            )
        } catch (e: Exception) {
            TokenDataModel("")
        }

        return token
    }

}