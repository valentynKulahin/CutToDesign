package com.example.data.datastore

import kotlinx.coroutines.flow.Flow

interface DataStorePref {
    suspend fun updateToken(token: String)
    suspend fun getToken(): Flow<String>

    suspend fun updateAppName(appName: String)
    suspend fun getAppName(): Flow<String>

    suspend fun updateRouteApi(routeApi: String)
    suspend fun getRouteApi(): Flow<String>

    suspend fun updateAppVersion(appVersion: String)
    suspend fun getAppVersion(): Flow<String>

    suspend fun updateFirstRouteApi(token: String)
    suspend fun getFirstRouteApi(): Flow<String>
}