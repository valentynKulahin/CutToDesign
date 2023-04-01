package com.example.cuttodesign.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
import coil.compose.AsyncImage
import com.example.cuttodesign.R
import com.example.cuttodesign.ui.screens.navigation.NavItem
import com.example.domain.models.ItemsDomainModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StartHomeScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    homeViewModel: HomeViewModel
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
                HomeScreenMenu(navController = navController, homeViewModel = homeViewModel)
            }
        }
    )
}

@Composable
fun HomeScreenMenu(navController: NavHostController, homeViewModel: HomeViewModel) {
    val homeVM by homeViewModel.uiState.collectAsState()
    val items = remember { mutableStateOf(homeVM.itemsDomainModel) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalArrangement = Arrangement.Center
    ) {
        HomeScreenTextMenu()
        Spacer(modifier = Modifier.height(10.dp))
        HomeScreenOpenCatalogBrands(navController = navController, items = items.value)
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
fun HomeScreenOpenCatalogBrands(navController: NavHostController, items: ItemsDomainModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable { navController.navigate(NavItem.CatalogBrands.route) },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        HomeScreenMenuIconAndName(items = items)
        HomeScreenMenuOpenIcon()
    }
}

@Composable
fun HomeScreenMenuIconAndName(items: ItemsDomainModel) {
    val list = listOf(items)

    Row(
        modifier = Modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        LazyColumn(modifier = Modifier, userScrollEnabled = true) {
            list.forEach { menu ->
                item {
                    HomeScreenMenuIcon(icon = menu.itemList.itemName)
                    Spacer(modifier = Modifier.width(8.dp))
                    HomeScreenMenuName(name = menu.itemList.itemImage)
                }
            }
        }
    }
}

@Composable
fun HomeScreenMenuIcon(icon: String) {
    AsyncImage(model = icon, contentDescription = null, modifier = Modifier.size(40.dp))
//    Icon(
//        imageVector = ImageVector.vectorResource(id = R.drawable.catalog_bottom_icon),
//        contentDescription = null,
//        modifier = Modifier.size(40.dp),
//        tint = MaterialTheme.colorScheme.primary
//    )
}

@Composable
fun HomeScreenMenuName(name: String) {
    Text(
        text = name,
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
