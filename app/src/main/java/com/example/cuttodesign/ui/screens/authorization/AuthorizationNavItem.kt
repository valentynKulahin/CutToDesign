package com.example.cuttodesign.ui.screens.authorization

import com.example.cuttodesign.R
import com.example.cuttodesign.ui.screens.navigation.NavItem

sealed class AuthorizationNavItem(
    val route: String
) {
    object Authorization : AuthorizationNavItem(
        route = R.string.as_sign_in.toString()
    )

    object SplashScreen : AuthorizationNavItem(
        route = R.string.splash_screen.toString()
    )

    object HomeScreen : AuthorizationNavItem(
        route = R.string.bb_home.toString()
    )
}