package com.example.cuttodesign.ui.screens.home

import androidx.lifecycle.ViewModel
import com.example.cuttodesign.MainActivityContract
import com.example.domain.repos.DataStoreRepo
import com.example.domain.repos.MainRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val dataStoreRepo: DataStoreRepo,
    private val mainRepo: MainRepo
) : ViewModel() {

    private val scope = CoroutineScope(Dispatchers.IO)
    private val _uiState = MutableStateFlow(HomeScreenContract())
    val uiState = _uiState.asStateFlow()

    init {
        scope.launch {
            val token = dataStoreRepo.getToken().first()
            _uiState.emit(
                _uiState.value.copy(
                    token = token,
                    userDomainModel = mainRepo.getUserInfoAsync(token = token),
                    itemsDomainModel = mainRepo.getMenuItemsAsync(token = token),
                    brandsDomainModel = mainRepo.getBrandsAsync(token = token)
                )
            )
        }
    }

}