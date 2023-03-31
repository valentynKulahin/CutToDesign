package com.example.domain.repos

import kotlinx.coroutines.flow.Flow

interface DataStoreRepo {

    suspend fun updateToken(token: String)
    suspend fun getToken(): Flow<String>

    suspend fun updateAppName(appName: String)
    suspend fun getAppName(): Flow<String>

    suspend fun updateRouteApi(routeApi: String)
    fun getRouteApi(): Flow<String>

    suspend fun updateAppVersion(appVersion: String)
    suspend fun getAppVersion(): Flow<String>

    suspend fun updateFirstRouteApi(firstRouteApi: String)
    suspend fun getFirstRouteApi(): Flow<String>

}