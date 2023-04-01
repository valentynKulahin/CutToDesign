package com.example.cuttodesign.ui.screens.authorization

import android.os.Build
import android.provider.Settings
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.test.orchestrator.junit.BundleJUnitUtils.getResult
import com.example.data.api.AuthorizationRetrofitRepo
import com.example.domain.models.AuthDomainModel
import com.example.domain.models.DeviceDomainModel
import com.example.domain.models.UserDeviceDomainModel
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

@RequiresApi(Build.VERSION_CODES.M)
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
            //route API
            val site = retrofitRepo.getApiAddressAsync(
                dataStoreRepo.getAppName().first(),
                dataStoreRepo.getAppVersion().first()
            )
            dataStoreRepo.updateRouteApi(routeApi = site)

            //last version
            val result = retrofitRepo.getLastVersionAsync(
                dataStoreRepo.getAppVersion().first().toInt()
            )
            dataStoreRepo.updateAppVersion(appVersion = result.toString())
            _uiState.emit(_uiState.value.copy(version = result))

            //device info
            _uiState.emit(
                _uiState.value.copy(
                    devman = Build.BRAND.toString(),
                    devmod = Build.MODEL,
                    devavs = Build.VERSION.SDK_INT.toString(),
                    devaid = Settings.Secure.ANDROID_ID

                )
            )

            setAuthInfo(login = "380501234567", password = "123456")
        }
    }

    fun setAuthInfo(login: String, password: String) {
        scope.launch {
            _uiState.emit(_uiState.value.copy(login = login))
            _uiState.emit(_uiState.value.copy(password = password))
        }
    }

    fun getToken(login: String, password: String) {
        scope.launch {
            val token = retrofitRepo.postMyAuthorizationInfoAsync(
                userDeviceDomainModel = UserDeviceDomainModel(
                    AuthDomainModel(
                        login = login,
                        password = password
                    ),
                    deviceDomainModel = DeviceDomainModel(
                        devman = _uiState.value.devman,
                        devmod = _uiState.value.devmod,
                        devavs = _uiState.value.devavs,
                        devaid = _uiState.value.devaid
                    )
                )
            )

            _uiState.emit(
                _uiState.value.copy(
                    token = token
                )
            )

            dataStoreRepo.updateToken(token = token)
        }
    }

}