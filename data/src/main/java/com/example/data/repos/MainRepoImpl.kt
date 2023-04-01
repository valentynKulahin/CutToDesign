package com.example.data.repos

import com.example.data.api.MainRetrofitRepo
import com.example.data.mapToDomain
import com.example.domain.models.BrandsDomainModel
import com.example.domain.models.ItemsDomainModel
import com.example.domain.models.UserDomainModel
import com.example.domain.repos.MainRepo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRepoImpl @Inject constructor(
    private val mainRetrofitRepo: MainRetrofitRepo
) : MainRepo {
    override suspend fun getUserInfoAsync(token: String): UserDomainModel {
        return mainRetrofitRepo.getUserInfoAsync(token = token).mapToDomain()
    }

    override suspend fun getMenuItemsAsync(token: String): ItemsDomainModel {
        return mainRetrofitRepo.getMenuItemsAsync(token = token).mapToDomain()
    }

    override suspend fun getBrandsAsync(token: String): BrandsDomainModel {
        return mainRetrofitRepo.getBrandsAsync(token = token).mapToDomain()
    }

    override suspend fun deleteUserAsync(token: String) {
        TODO("Not yet implemented")
    }


}