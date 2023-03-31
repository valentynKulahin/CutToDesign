package com.example.cuttodesign.ui.screens.authorization

import android.util.Log
import androidx.lifecycle.ViewModel
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
class AuthorizationViewModel @Inject constructor(
    private val retrofitRepo: AuthorizationRepo,
    private val dataStoreRepo: DataStoreRepo
) : ViewModel() {

    private val scope = CoroutineScope(Dispatchers.IO)
    private val _uiState = MutableStateFlow(AuthorizationScreenContract())
    val uiState = _uiState.asStateFlow()

    init {
        scope.launch {
            val site = retrofitRepo.getApiAddressAsync(
                dataStoreRepo.getAppName().last(),
                dataStoreRepo.getAppVersion().last()
            )

            dataStoreRepo.updateRouteApi(routeApi = site)


            val result = retrofitRepo.getLastVersionAsync(
                dataStoreRepo.getAppVersion().last().toInt()
            )

            _uiState.emit(
                _uiState.value.copy(v = !(result == 1 || result == 2))
            )
        }
    }

    fun getToken() {
        scope.launch {
            dataStoreRepo.updateToken(token = "1")
            _uiState.emit(_uiState.value.copy(token = dataStoreRepo.getToken().first()))
        }
        Log.d("MainActivity", "set token: ${_uiState.value.token}")
    }

}