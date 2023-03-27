package com.example.data.repos

import androidx.datastore.core.DataStore
import androidx.datastore.core.IOException
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import com.example.data.datastore.PreferencesKeys
import com.example.domain.repos.DataStoreRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataStoreRepositoryImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>
) : DataStoreRepo {

    override suspend fun updateToken(token: String) {
        dataStore.edit { it[PreferencesKeys.token] = token }
    }

    override suspend fun getToken(): Flow<String> {
        return dataStore.data
            .catch { exception ->
                // dataStore.data throws an IOException when an error is encountered when reading data
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }.map { it[PreferencesKeys.token].toString() }
    }

    override suspend fun updateAppName(appName: String) {
        dataStore.edit { it[PreferencesKeys.appName] = appName }
    }

    override suspend fun getAppName(): Flow<String> {
        return dataStore.data
            .catch { exception ->
                // dataStore.data throws an IOException when an error is encountered when reading data
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }.map { preferences ->
                preferences[PreferencesKeys.appName]?: ""
            }
    }

    override suspend fun updateRouteApi(routeApi: String) {
        dataStore.edit { it[PreferencesKeys.routeApi] = routeApi }
    }

    override suspend fun getRouteApi(): Flow<String> {
        return dataStore.data
            .catch { exception ->
                // dataStore.data throws an IOException when an error is encountered when reading data
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }.map { preferences ->
                preferences[PreferencesKeys.routeApi]?: ""
            }
    }

    override suspend fun updateAppVersion(appVersion: String) {
        dataStore.edit { it[PreferencesKeys.app_version] = appVersion }
    }

    override suspend fun getAppVersion(): Flow<String> {
        return dataStore.data
            .catch { exception ->
                // dataStore.data throws an IOException when an error is encountered when reading data
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }.map { preferences ->
                preferences[PreferencesKeys.app_version]?: ""
            }
    }

    override suspend fun updateFirstRouteApi(firstRouteApi: String) {
        dataStore.edit { it[PreferencesKeys.firstRoutApi] = firstRouteApi }
    }

    override suspend fun getFirstRouteApi(): Flow<String> {
        return dataStore.data
            .catch { exception ->
                // dataStore.data throws an IOException when an error is encountered when reading data
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }.map { preferences ->
                preferences[PreferencesKeys.firstRoutApi]?: ""
            }
    }

}