package com.example.cuttodesign.ui.screens.exit

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.cuttodesign.MainActivityContract
import com.example.cuttodesign.MainActivityViewModel
import com.example.cuttodesign.R
import com.example.cuttodesign.ui.screens.navigation.NavItem

@Composable
fun StartExitScreen(
    navController: NavHostController,
    mainActivityViewModel: MainActivityViewModel
) {

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        content = { contentPadding ->
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(contentPadding),
                color = MaterialTheme.colorScheme.background
            ) {
                ExitScreen(
                    navController = navController,
                    mainActivityViewModel = mainActivityViewModel
                )
            }
        }
    )

}

@Composable
fun ExitScreen(navController: NavHostController, mainActivityViewModel: MainActivityViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.es_question_first),
            color = MaterialTheme.colorScheme.secondary,
            modifier = Modifier.padding(top = 90.dp),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = stringResource(id = R.string.es_question_second),
            color = MaterialTheme.colorScheme.secondary,
            modifier = Modifier.padding(top = 10.dp),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        ExitScreenButtons(navController = navController) {
            mainActivityViewModel.clearToken()
        }
    }
}

@Composable
fun ExitScreenButtons(navController: NavHostController, clearToken: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        ElevatedButton(
            modifier = Modifier.weight(0.5f),
            onClick = { navController.navigate(NavItem.Home.route) },
            colors = ButtonDefaults.buttonColors(
                contentColor = MaterialTheme.colorScheme.secondary,
                containerColor = Color.Gray
            ),
            shape = MaterialTheme.shapes.small
        ) {
            Text(text = stringResource(id = R.string.es_button_no), color = MaterialTheme.colorScheme.secondary)
        }
        Spacer(modifier = Modifier.width(10.dp))
        ElevatedButton(
            modifier = Modifier.weight(0.5f),
            onClick = { clearToken() },
            colors = ButtonDefaults.buttonColors(
                contentColor = MaterialTheme.colorScheme.secondary,
                containerColor = MaterialTheme.colorScheme.primary
            ),
            shape = MaterialTheme.shapes.small
        ) {
            Text(text = stringResource(id = R.string.es_button_yes), color = MaterialTheme.colorScheme.secondary)
        }
    }
}