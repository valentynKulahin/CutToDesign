package com.example.data.repos.api

import com.example.data.api.MainRetrofitRepo
import com.example.data.api.retrofit.RetrofitHelper
import com.example.data.models.*
import com.example.domain.repos.DataStoreRepo
import kotlinx.coroutines.flow.first
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRetrofitRepoImpl @Inject constructor(
    private val dataStoreRepo: DataStoreRepo
) : MainRetrofitRepo {

    lateinit var retrofit: MainRetrofitRepo

    override suspend fun getUserInfoAsync(token: String): UserDataModel {
        retrofit = RetrofitHelper.getInstanceMain(dataStoreRepo.getRouteApi().first().toString())

        val userDataModel: UserDataModel = try {
            retrofit.getUserInfoAsync(token = dataStoreRepo.getToken().first())
        } catch (e: Exception) {
            UserDataModel()
        }
        return userDataModel
    }

    override suspend fun getMenuItemsAsync(token: String): ItemsDataModel {
        val itemsDataModel: ItemsDataModel = try {
            retrofit.getMenuItemsAsync(token = dataStoreRepo.getToken().first())
        } catch (e: Exception) {
            ItemsDataModel()
        }
        return itemsDataModel
    }

    override suspend fun getBrandsAsync(token: String): BrandsDataModel {
        val brandsDataModel: BrandsDataModel = try {
            retrofit.getBrandsAsync(token = dataStoreRepo.getToken().first())
        } catch (e: Exception) {
            BrandsDataModel()
        }
        return brandsDataModel
    }

    override suspend fun deleteUserAsync(token: String): String {
        TODO("Not yet implemented")
    }

}