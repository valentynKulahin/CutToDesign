package com.example.cuttodesign.ui.screens.catalog_brends

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.example.cuttodesign.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StartCatalogBrandsScreen(
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
                        text = stringResource(id = R.string.cb_catalog_brands),
                        color = MaterialTheme.colorScheme.secondary
                    )
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
                CatalogBrandsScreen(navController = navController)
            }
        }
    )
}

@Composable
fun CatalogBrandsScreen(navController: NavHostController) {

    val list = listOf("Samsung", "Apple", "Huawei", "Xiaomi")

    LazyColumn(modifier = Modifier.fillMaxSize(), userScrollEnabled = true) {

    }

}