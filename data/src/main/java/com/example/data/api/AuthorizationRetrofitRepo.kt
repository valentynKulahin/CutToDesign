package com.example.data.api

import com.example.data.models.*
import com.example.domain.models.UserDeviceDomainModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface AuthorizationRetrofitRepo {

    @GET("routes/")
    suspend fun getApiAddressAsync(
        @Query("appName") appName: String,
        @Query("v") versionApp: String
    ): ApiRouteDataModel

    @GET("/app/version/latest")
    suspend fun getLastVersionAsync(
        @Query("v") v: String
    ): ActualVersionDataModel

    @POST("/users/login")
    suspend fun postMyAuthorizationInfoAsync(
        @Body userDeviceDataModel: UserDeviceDataModel
    ): TokenDataModel

}