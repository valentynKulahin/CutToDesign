package com.example.domain.repos

import android.telecom.Call

interface MainRepo {

    suspend fun getUserInfoAsync(token: String)

    suspend fun getMenuItemsAsync(token: String)

    suspend fun getBrandsAsync(token: String)

    suspend fun deleteUserAsync(token: String)

}