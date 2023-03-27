package com.example.cuttodesign.ui.screens.authorization

import androidx.lifecycle.ViewModel
import com.example.domain.repos.AuthorizationRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthorizationViewModel @Inject constructor(
    private val authorizationRepo: AuthorizationRepo
) : ViewModel() {

}