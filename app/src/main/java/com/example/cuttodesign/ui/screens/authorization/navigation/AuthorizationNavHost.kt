package com.example.cuttodesign.ui.screens.authorization.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.cuttodesign.MainActivityViewModel
import com.example.cuttodesign.ui.screens.authorization.AuthorizationViewModel
import com.example.cuttodesign.ui.screens.authorization.StartAuthorizationScreen
import com.example.cuttodesign.ui.screens.splash.StartSplashScreen

@RequiresApi(Build.VERSION_CODES.M)
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