package com.example.data.api

import com.example.data.models.*
import com.example.domain.models.UserDeviceDomainModel
import retrofit2.Call
import retrofit2.http.*

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

    @FormUrlEncoded
    @POST("/users/login/")
    suspend fun postMyAuthorizationInfoAsync(
        @Field("login") login: String,
        @Field("password") password: String,
        @Field("devman") devman: String,
        @Field("devmod") devmod: String,
        @Field("devavs") devavs: String,
        @Field("devaid") devaid: String
    ): TokenDataModel

}