package com.example.data.api

import com.example.data.models.BrandsDataModel
import com.example.data.models.ItemsDataModel
import com.example.data.models.UserDataModel
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Query

interface MainRetrofitRepo {

    @GET("/users")
    suspend fun getUserInfoAsync(
        @Query("token") token: String
    ): UserDataModel

    @GET("/home/menu/items")
    suspend fun getMenuItemsAsync(
        @Query("token") token: String
    ): ItemsDataModel

    @GET("/catalog/brands")
    suspend fun getBrandsAsync(
        @Query("token") token: String
    ): BrandsDataModel

    @DELETE("/users")
    suspend fun deleteUserAsync(
        @Query("token") token: String
    ): String

}