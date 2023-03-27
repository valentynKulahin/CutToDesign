package com.example.cuttodesign

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.cuttodesign.ui.screens.authorization.AuthorizationNavHost
import com.example.cuttodesign.ui.screens.authorization.AuthorizationViewModel
import com.example.cuttodesign.ui.screens.authorization.StartAuthorizationScreen
import com.example.cuttodesign.ui.screens.home.HomeViewModel
import com.example.cuttodesign.ui.screens.navigation.StartMainNavigation
import com.example.cuttodesign.ui.screens.splash.StartSplashScreen
import com.example.cuttodesign.ui.theme.CutToDesignTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val mainActivityViewModel : MainActivityViewModel by viewModels()
    private val authorizationViewModel : AuthorizationViewModel by viewModels()
    private val homeViewModel : HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val mainVM by mainActivityViewModel.uiState.collectAsState()
            val navController = rememberNavController()
            CutToDesignTheme {
                if (mainVM.token.isEmpty()) {
                    AuthorizationNavHost(navController = navController, mainActivityViewModel = mainActivityViewModel, authorizationViewModel = authorizationViewModel)
                } else {
                    StartMainNavigation(navController = navController, mainActivityViewModel = mainActivityViewModel, homeViewModel = homeViewModel)
                }
            }
        }
    }
}