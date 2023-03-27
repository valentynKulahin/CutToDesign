package com.example.data.api

import retrofit2.Call
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface InterfaceApi {

    @GET
    suspend fun getApiAddress() : Call<String>

    @GET
    suspend fun getLastVersion() {

    }

    @GET
    suspend fun getInfoAboutMyVersion() {

    }

    @POST
    suspend fun postMyAuthorizationInfo() {

    }

    @GET
    suspend fun getUserInfo() {

    }

    @GET
    suspend fun getMenuItems() {

    }

    @GET
    suspend fun getBrands() {

    }

    @DELETE
    suspend fun deleteUser() {

    }

}