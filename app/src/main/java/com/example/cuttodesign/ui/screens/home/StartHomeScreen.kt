package com.example.cuttodesign.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.cuttodesign.R
import com.example.cuttodesign.ui.screens.navigation.NavItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StartHomeScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {

    Scaffold(
        modifier = Modifier,
        topBar = {
            TopAppBar(
                modifier = Modifier,
                title = {
                    Text(
                        text = stringResource(id = R.string.hm_cut_on),
                        color = Color.White
                    )
                },
                navigationIcon = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(onClick = { navController.navigate(NavItem.Exit.route) }) {
                            Icon(
                                imageVector = ImageVector.vectorResource(id = R.drawable.close_top_bar_icon),
                                contentDescription = null,
                                tint = Color.White
                            )
                        }
                        Text(
                            text = stringResource(id = R.string.hm_cut_on),
                            color = Color.White,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 18.sp
                        )
                        IconButton(onClick = { navController.navigate(NavItem.Settings.route) }) {
                            Icon(
                                imageVector = ImageVector.vectorResource(id = R.drawable.user_top_bar_icon),
                                contentDescription = null,
                                tint = Color.White
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background)
            )
        },
        content = { contentPadding ->
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(contentPadding),
                color = MaterialTheme.colorScheme.background
            ) {
                HomeScreenMenu(navController = navController)
            }
        }
    )
}

@Composable
fun HomeScreenMenu(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalArrangement = Arrangement.Center
    ) {
        HomeScreenTextMenu()
        Spacer(modifier = Modifier.height(10.dp))
        HomeScreenOpenCatalogBrands(navController = navController)
        HomeScreenGradientLine()
    }
}

@Composable
fun HomeScreenTextMenu() {
    Text(
        text = stringResource(id = R.string.hm_menu),
        color = MaterialTheme.colorScheme.secondary
    )
}

@Composable
fun HomeScreenOpenCatalogBrands(navController: NavHostController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable { navController.navigate(NavItem.CatalogBrands.route) },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        HomeScreenMenuIconAndName()
        HomeScreenMenuOpenIcon()
    }
}

@Composable
fun HomeScreenMenuIconAndName() {
    Row(modifier = Modifier, verticalAlignment = Alignment.CenterVertically) {
        HomeScreenMenuIcon()
        Spacer(modifier = Modifier.width(8.dp))
        HomeScreenMenuName()
    }
}

@Composable
fun HomeScreenMenuIcon() {
    Icon(
        imageVector = ImageVector.vectorResource(id = R.drawable.catalog_bottom_icon),
        contentDescription = null,
        modifier = Modifier.size(40.dp),
        tint = MaterialTheme.colorScheme.primary
    )
}

@Composable
fun HomeScreenMenuName() {
    Text(
        text = stringResource(id = R.string.hm_catalog_brands),
        color = MaterialTheme.colorScheme.secondary
    )
}

@Composable
fun HomeScreenMenuOpenIcon() {
    Icon(
        imageVector = ImageVector.vectorResource(id = R.drawable.arrow_right_icon),
        contentDescription = null,
        tint = MaterialTheme.colorScheme.primary,
        modifier = Modifier.size(25.dp)
    )
}

@Composable
fun HomeScreenGradientLine() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .height(2.dp)
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.primary,
                        MaterialTheme.colorScheme.background
                    ),
                    start = Offset.Zero,
                    end = Offset.Infinite
                )
            )
    )
}
