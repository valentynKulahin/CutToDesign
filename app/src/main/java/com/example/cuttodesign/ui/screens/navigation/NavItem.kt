package com.example.cuttodesign.ui.screens.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.cuttodesign.R

sealed class NavItem(
    val route: String,
    @StringRes val label: Int,
    @DrawableRes val icon: Int
) {
    object Home : NavItem(
        route = R.string.bb_home.toString(),
        label = R.string.bb_home,
        icon = R.drawable.home_bottom_icon
    )

    object CatalogBrands : NavItem(
        route = R.string.bb_catalog_brands.toString(),
        label = R.string.bb_catalog_brands,
        icon = R.drawable.catalog_bottom_icon
    )

    object Coins : NavItem(
        route = R.string.bb_coins.toString(),
        label = R.string.bb_coins,
        icon = R.drawable.coins_bottom_icon
    )

    object Support : NavItem(
        route = R.string.bb_support.toString(),
        label = R.string.bb_support,
        icon = R.drawable.customer_bottom_icon
    )

    object Settings : NavItem(
        route = R.string.bb_settings.toString(),
        label = R.string.bb_settings,
        icon = R.drawable.settings_bottom_icon
    )

    object Exit : NavItem(
        route = R.string.es_exit_screen.toString(),
        label = R.string.es_exit_screen,
        icon = R.drawable.settings_bottom_icon
    )
}