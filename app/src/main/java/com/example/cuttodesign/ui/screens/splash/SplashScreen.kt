package com.example.cuttodesign.ui.screens.splash

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavHostController
import com.example.cuttodesign.R
import com.example.cuttodesign.ui.screens.authorization.navigation.AuthorizationNavItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun StartSplashScreen(navController: NavHostController) {

    LaunchedEffect(key1 = true) {
        CoroutineScope(Dispatchers.Main).launch {
            delay(2000)
            navController.navigate(AuthorizationNavItem.Authorization.route)
        }
    }

    Scaffold(content = { contentPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding),
            color = MaterialTheme.colorScheme.background
        ) {
            SplashScreen(navController = navController)
        }
    })

}

@Composable
fun SplashScreen(navController: NavHostController) {

    Box(modifier = Modifier, contentAlignment = Alignment.Center) {
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.splash_icon),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.clickable { navController.navigate(AuthorizationNavItem.Authorization.route) }
        )
    }

}