package com.example.cuttodesign.ui.screens.authorization

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cuttodesign.MainActivityViewModel
import com.example.cuttodesign.ui.screens.home.HomeViewModel
import com.example.cuttodesign.ui.screens.navigation.StartMainNavigation
import com.example.cuttodesign.ui.screens.splash.StartSplashScreen

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