package com.example.cuttodesign.ui.screens.navigation

import androidx.annotation.DrawableRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    isVisible: Boolean = true
) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    val selected = remember { mutableStateOf(NavItem.Home.route) }

    if (isVisible) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 26.dp)
                .height(50.dp),
            color = MaterialTheme.colorScheme.background,
            contentColor = MaterialTheme.colorScheme.primary,
            shape = MaterialTheme.shapes.medium,
            border = BorderStroke(1.dp, color = MaterialTheme.colorScheme.primary),
        ) {
            Row(
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                MainNavigationItem(
                    icon = NavItem.Home.icon,
                    isSelected = backStackEntry.value?.destination?.route == NavItem.Home.route
                ) {
                    selected.value = NavItem.Home.route
                    navController.popBackStack(NavItem.Home.route, false)
                    navController.navigate(selected.value)
                }
                MainNavigationItem(
                    icon = NavItem.CatalogBrands.icon,
                    isSelected = backStackEntry.value?.destination?.route == NavItem.CatalogBrands.route
                ) {
                    selected.value = NavItem.CatalogBrands.route
                    navController.popBackStack(NavItem.CatalogBrands.route, false)
                    navController.navigate(selected.value)
                }
                MainNavigationItem(
                    icon = NavItem.Coins.icon,
                    isSelected = backStackEntry.value?.destination?.route == NavItem.Coins.route
                ) {
                    selected.value = NavItem.Coins.route
                    navController.popBackStack(NavItem.Coins.route, false)
                    navController.navigate(selected.value)
                }
                MainNavigationItem(
                    icon = NavItem.Support.icon,
                    isSelected = backStackEntry.value?.destination?.route == NavItem.Support.route
                ) {
                    selected.value = NavItem.Support.route
                    navController.popBackStack(NavItem.Support.route, false)
                    navController.navigate(selected.value)
                }
                MainNavigationItem(
                    icon = NavItem.Settings.icon,
                    isSelected = backStackEntry.value?.destination?.route == NavItem.Settings.route
                ) {
                    selected.value = NavItem.Settings.route
                    navController.popBackStack(NavItem.Settings.route, false)
                    navController.navigate(selected.value)
                }
            }
        }
    }
}

@Composable
private fun MainNavigationItem(
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int,
    isSelected: Boolean = false,
    onSelect: () -> Unit
) {
    val indicationColor by animateColorAsState(
        targetValue = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onBackground,
        animationSpec = tween(
            durationMillis = 300,
            delayMillis = 40,
            easing = LinearOutSlowInEasing
        )
    )

    val iconAlpha by animateFloatAsState(
        targetValue = if (isSelected) 1f else 0.5f,
        animationSpec = tween(
            durationMillis = 300,
            delayMillis = 40,
            easing = LinearOutSlowInEasing
        )
    )

    Column(
        modifier = Modifier.clickable(
            indication = null,
            interactionSource = MutableInteractionSource(),
            onClick = onSelect::invoke
        ),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            tint = if (isSelected) MaterialTheme.colorScheme.primary else Color.Gray,
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .size(25.dp)
                .alpha(iconAlpha)
                .padding(bottom = 4.dp)
        )
        Surface(
            modifier = Modifier.size(5.dp),
            color = indicationColor,
            shape = CircleShape
        ) {}
    }
}