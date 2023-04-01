package com.example.cuttodesign.ui.screens.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.cuttodesign.MainActivityViewModel
import com.example.cuttodesign.ui.screens.authorization.StartAuthorizationScreen
import com.example.cuttodesign.ui.screens.catalog_brends.StartCatalogBrandsScreen
import com.example.cuttodesign.ui.screens.coins.StartCoinsScreen
import com.example.cuttodesign.ui.screens.exit.StartExitScreen
import com.example.cuttodesign.ui.screens.home.HomeViewModel
import com.example.cuttodesign.ui.screens.home.StartHomeScreen
import com.example.cuttodesign.ui.screens.settings.StartSettingsScreen
import com.example.cuttodesign.ui.screens.support.StartSupportScreen

@Composable
fun StartMainNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    mainActivityViewModel: MainActivityViewModel,
    homeViewModel: HomeViewModel

) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = { BottomNavigationBar(navController = navController, isVisible = true) }
    ) {
        NavHost(
            modifier = Modifier.padding(it),
            navController = navController,
            startDestination = NavItem.Home.route
        ) {
            composable(NavItem.Home.route) {
                StartHomeScreen(navController = navController, homeViewModel = homeViewModel)
            }
            composable(NavItem.CatalogBrands.route) {
                StartCatalogBrandsScreen(navController = navController, homeViewModel = homeViewModel)
            }
            composable(NavItem.Coins.route) {
                StartCoinsScreen(navController = navController)
            }
            composable(NavItem.Support.route) {
                StartSupportScreen(navController = navController)
            }
            composable(NavItem.Settings.route) {
                StartSettingsScreen(navController = navController)
            }
            composable(NavItem.Exit.route) {
                StartExitScreen(
                    navController = navController,
                    mainActivityViewModel = mainActivityViewModel
                )
            }
        }
    }
}