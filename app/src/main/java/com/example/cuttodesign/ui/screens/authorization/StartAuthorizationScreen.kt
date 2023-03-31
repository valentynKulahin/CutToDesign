package com.example.cuttodesign.ui.screens.authorization

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.cuttodesign.MainActivityViewModel
import com.example.cuttodesign.R
import com.example.data.datastore.PreferencesKeys.token

@RequiresApi(Build.VERSION_CODES.M)
@Composable
fun StartAuthorizationScreen(
    navController: NavHostController,
    mainActivityViewModel: MainActivityViewModel,
    authorizationViewModel: AuthorizationViewModel
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
                AuthorizationScreen(
                    navController = navController,
                    mainActivityViewModel = mainActivityViewModel,
                    authorizationViewModel = authorizationViewModel
                )
            }
        }
    )

}

@RequiresApi(Build.VERSION_CODES.M)
@Composable
fun AuthorizationScreen(
    navController: NavHostController,
    mainActivityViewModel: MainActivityViewModel,
    authorizationViewModel: AuthorizationViewModel
) {

    val authorizationVM by authorizationViewModel.uiState.collectAsState()
    val stateVersion = remember { mutableStateOf(authorizationVM.version) }
    val token = remember { mutableStateOf(authorizationVM.token) }
    val login = remember { mutableStateOf(authorizationVM.login) }
    val password = remember { mutableStateOf(authorizationVM.password) }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Column(
            modifier = Modifier
        ) {
            AuthorizationScreenTextEntered()
            Spacer(modifier = Modifier.height(40.dp))
            AuthorizationScreenTextFieldLogin(loginString = login.value) {
                login.value = it
            }
            AuthorizationScreenTextFieldPassword(passwordString = password.value) {
                password.value = it
            }
            AuthorizationScreenOptionalFeatures()
            AuthorizationScreenButtonSignIn(
                setToken = {
                    mainActivityViewModel.setToken()
                },
                getToken = {
                    authorizationViewModel.getToken(
                        login = login.value,
                        password = password.value
                    )
                }
            )
            AuthorizationScreenTextVersion(stateVersion = stateVersion.value)
            AuthorizationScreenUpdateNow()
            AuthorizationScreenBottomElements()
        }
    }

}

@Composable
fun AuthorizationScreenTextEntered() {
    Text(
        text = stringResource(id = R.string.as_sign_in),
        modifier = Modifier.padding(start = 30.dp),
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Bold,
        style = MaterialTheme.typography.headlineMedium,
        color = MaterialTheme.colorScheme.secondary
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthorizationScreenTextFieldLogin(loginString: String, onEdit: (String) -> Unit) {
    val loginState = remember { mutableStateOf(loginString) }

    TextField(
        value = loginState.value,
        onValueChange = {
            onEdit(it)
            loginState.value = it
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp, top = 10.dp, bottom = 10.dp),
        enabled = true,
        singleLine = true,
        label = {
            Text(
                text = stringResource(id = R.string.as_mobile_number),
                color = Color.Gray
            )
        },
        placeholder = {
            Text(
                text = stringResource(id = R.string.as_mobile_number),
                color = Color.Gray
            )
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Next
        ),
        colors = TextFieldDefaults.textFieldColors(
            focusedTextColor = MaterialTheme.colorScheme.secondary,
            unfocusedTextColor = MaterialTheme.colorScheme.secondary,
            containerColor = MaterialTheme.colorScheme.background,
            focusedPlaceholderColor = MaterialTheme.colorScheme.secondary,
            unfocusedPlaceholderColor = MaterialTheme.colorScheme.secondary,
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthorizationScreenTextFieldPassword(passwordString: String, onEdit: (String) -> Unit) {
    val statePassword = remember { mutableStateOf(passwordString) }
    val showPassword = remember { mutableStateOf(false) }

    TextField(
        value = statePassword.value,
        onValueChange = {
            onEdit(it)
            statePassword.value = it
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp, bottom = 10.dp),
        enabled = true,
        singleLine = true,
        label = { Text(text = stringResource(id = R.string.as_password), color = Color.Gray) },
        placeholder = {
            Text(
                text = stringResource(id = R.string.as_password),
                color = Color.Gray
            )
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
        visualTransformation = if (showPassword.value) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            val (icon, iconColor) = if (showPassword.value) {
                Pair(
                    Icons.Filled.Visibility,
                    Color.Gray
                )
            } else {
                Pair(
                    Icons.Filled.VisibilityOff,
                    Color.Gray
                )
            }

            IconButton(onClick = { showPassword.value = !showPassword.value }) {
                Icon(
                    icon,
                    contentDescription = "Visibility",
                    tint = iconColor
                )
            }
        },
        colors = TextFieldDefaults.textFieldColors(
            focusedTextColor = MaterialTheme.colorScheme.secondary,
            unfocusedTextColor = MaterialTheme.colorScheme.secondary,
            containerColor = MaterialTheme.colorScheme.background,
            focusedPlaceholderColor = MaterialTheme.colorScheme.secondary,
            unfocusedPlaceholderColor = MaterialTheme.colorScheme.secondary,
        )
    )
}

@Composable
fun AuthorizationScreenOptionalFeatures() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        AuthorizationScreenRememberMe()
        AuthorizationScreenForgotPassword()
    }
}

@Composable
fun AuthorizationScreenRememberMe() {
    val selected = remember { mutableStateOf(false) }

    Row(
        modifier = Modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = selected.value,
            onClick = { selected.value = !selected.value },
            modifier = Modifier.padding(start = 10.dp),
            enabled = true,
        )
        ClickableText(
            text = AnnotatedString(stringResource(id = R.string.as_remember_me)),
            onClick = { },
            modifier = Modifier,
            style = TextStyle.Default.copy(color = MaterialTheme.colorScheme.primary)
        )
    }
}

@Composable
fun AuthorizationScreenForgotPassword() {
    ClickableText(
        text = AnnotatedString(stringResource(id = R.string.as_forgot_password)),
        onClick = { },
        modifier = Modifier.padding(end = 15.dp),
        style = TextStyle.Default.copy(color = MaterialTheme.colorScheme.secondary)
    )
}

@Composable
fun AuthorizationScreenButtonSignIn(setToken: () -> Unit, getToken: () -> Unit) {

    ElevatedButton(
        onClick = {
            getToken()
            setToken()
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
        shape = MaterialTheme.shapes.small,
        colors = ButtonDefaults.elevatedButtonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.secondary
        )
    ) {
        Text(
            text = stringResource(id = R.string.as_sign_in),
            modifier = Modifier,
            fontWeight = FontWeight.SemiBold,
            fontStyle = FontStyle.Normal,
            fontFamily = FontFamily.Default
        )
    }
}

@Composable
fun AuthorizationScreenTextVersion(stateVersion: Int) {

    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = stringResource(id = R.string.as_text_version), color = Color.Gray)
        Text(
            text = if (stateVersion == 0) stringResource(id = R.string.as_text_version_correct) else stringResource(
                id = R.string.as_text_version_old
            ),
            color = Color.Gray
        )

        if (stateVersion == 1) {
            Toast.makeText(
                LocalContext.current,
                "You have old version",
                Toast.LENGTH_SHORT
            ).show()
        } else if (stateVersion == 2) {
            Toast.makeText(
                LocalContext.current,
                "You have very old version, you cant work",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}

@Composable
fun AuthorizationScreenUpdateNow() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ClickableText(
            text = AnnotatedString(stringResource(id = R.string.as_update_now)),
            onClick = {},
            modifier = Modifier,
            style = TextStyle.Default.copy(color = MaterialTheme.colorScheme.primary)
        )
    }
}

@Composable
fun AuthorizationScreenBottomElements() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp, bottom = 20.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.Bottom
    ) {
        AuthorizationScreenNotHaveAccount()
        AuthorizationScreenSignUp()
    }
}

@Composable
fun AuthorizationScreenNotHaveAccount() {
    ClickableText(
        text = AnnotatedString(stringResource(id = R.string.as_not_have_account)),
        onClick = {},
        modifier = Modifier,
        style = TextStyle.Default.copy(color = Color.Gray)
    )
}

@Composable
fun AuthorizationScreenSignUp() {
    ClickableText(
        text = AnnotatedString(stringResource(id = R.string.as_sign_up)),
        onClick = {},
        modifier = Modifier,
        style = TextStyle.Default.copy(color = MaterialTheme.colorScheme.secondary)
    )
}