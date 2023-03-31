package com.example.data.api

import com.example.data.models.ActualVersionDataModel
import com.example.data.models.ApiRouteDataModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface AuthorizationRetrofitRepo {

    @GET("routes/")
    suspend fun getApiAddress(
        @Query("appName") appName:String,
        @Query("v") versionApp: String
    ): ApiRouteDataModel

    @GET("/app/version/latest")
    suspend fun getLastVersionAsync(
        @Query("v") v: String
    ): ActualVersionDataModel

    @POST("/users/login")
    suspend fun postMyAuthorizationInfoAsync(
        @Query("login") login: String,
        @Query("password") password: String,
        @Query("devman") devman: String,
        @Query("devmod") devmod: String,
        @Query("devavs") devavs: String,
        @Query("devaid") devaid: String
    ): Call<String>

}