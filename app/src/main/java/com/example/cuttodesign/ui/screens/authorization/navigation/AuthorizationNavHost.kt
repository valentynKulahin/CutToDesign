package com.example.cuttodesign.ui.screens.authorization

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.cuttodesign.MainActivityViewModel
import com.example.cuttodesign.ui.screens.authorization.navigation.AuthorizationNavItem
import com.example.cuttodesign.ui.screens.splash.SplashViewModel
import com.example.cuttodesign.ui.screens.splash.StartSplashScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun AuthorizationNavHost(
    navController: NavHostController,
    mainActivityViewModel: MainActivityViewModel,
    authorizationViewModel: AuthorizationViewModel
) {

    NavHost(
        navController = navController,
        startDestination = AuthorizationNavItem.SplashScreen.route
    ) {
        composable(route = AuthorizationNavItem.SplashScreen.route) {
            StartSplashScreen(navController = navController)
        }
        composable(route = AuthorizationNavItem.Authorization.route) {
            StartAuthorizationScreen(
                navController = navController,
                mainActivityViewModel = mainActivityViewModel,
                authorizationViewModel = authorizationViewModel
            )
        }
    }

}