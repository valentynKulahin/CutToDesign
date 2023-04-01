package com.example.domain.repos

import android.telecom.Call
import com.example.domain.models.BrandsDomainModel
import com.example.domain.models.ItemsDomainModel
import com.example.domain.models.UserDeviceDomainModel
import com.example.domain.models.UserDomainModel

interface MainRepo {

    suspend fun getUserInfoAsync(token: String): UserDomainModel

    suspend fun getMenuItemsAsync(token: String): ItemsDomainModel

    suspend fun getBrandsAsync(token: String): BrandsDomainModel

    suspend fun deleteUserAsync(token: String)

}