package com.example.cuttodesign

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.data.datastore.PreferencesKeys.appName
import com.example.data.datastore.PreferencesKeys.routeApi
import com.example.domain.repos.AuthorizationRepo
import com.example.domain.repos.DataStoreRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val dataStoreRepo: DataStoreRepo
): ViewModel() {

    private val scope = CoroutineScope(Dispatchers.IO)
    private val _uiState = MutableStateFlow(MainActivityContract())
    val uiState = _uiState.asStateFlow()

    init {
        scope.launch {
            dataStoreRepo.updateToken(token = "")
            _uiState.emit(_uiState.value.copy(token = dataStoreRepo.getToken().first()))

            dataStoreRepo.updateAppName(appName = "cuton")
            dataStoreRepo.updateAppVersion(appVersion = "36")
            dataStoreRepo.updateFirstRouteApi(firstRouteApi = "https://cr-test-ribu2uaqea-ey.a.run.app/routes")
            dataStoreRepo.updateRouteApi(routeApi = "https://cr-test-ribu2uaqea-ey.a.run.app/routes")
        }
    }

    fun setToken() {
        scope.launch {
            dataStoreRepo.updateToken(token = "1")
            _uiState.emit(_uiState.value.copy(token = dataStoreRepo.getToken().first()))
        }
        Log.d("MainActivity", "set token: ${_uiState.value.token}")
    }

    fun clearToken() {
        scope.launch {
            dataStoreRepo.updateToken(token = "")
            _uiState.emit(_uiState.value.copy(token = dataStoreRepo.getToken().last()))
        }
    }

}