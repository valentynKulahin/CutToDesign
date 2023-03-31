package com.example.data.repos.api

import com.example.data.api.MainRetrofitRepo
import com.example.data.models.BrandsDataModel
import com.example.data.models.ItemsDataModel
import com.example.data.models.UserDataModel
import com.example.domain.repos.DataStoreRepo
import retrofit2.Call
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRetrofitRepoImpl @Inject constructor(
    private val dataStoreRepo: DataStoreRepo
) : MainRetrofitRepo {

    lateinit var retrofitRepo: MainRetrofitRepo

    override suspend fun getUserInfoAsync(token: String): Call<UserDataModel> {
        TODO("Not yet implemented")
    }

    override suspend fun getMenuItemsAsync(token: String): Call<ItemsDataModel> {
        TODO("Not yet implemented")
    }

    override suspend fun getBrandsAsync(token: String): Call<BrandsDataModel> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteUserAsync(token: String): Call<String> {
        TODO("Not yet implemented")
    }

}