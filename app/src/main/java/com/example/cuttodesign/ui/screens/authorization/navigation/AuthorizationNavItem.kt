package com.example.cuttodesign.ui.screens.authorization.navigation

import com.example.cuttodesign.R

sealed class AuthorizationNavItem(
    val route: String
) {
    object Authorization : AuthorizationNavItem(
        route = R.string.as_sign_in.toString()
    )

    object SplashScreen : AuthorizationNavItem(
        route = R.string.splash_screen.toString()
    )
}