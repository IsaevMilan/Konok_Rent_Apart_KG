package com.KonokRent.app.presentation.screens.auth



import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.airbnbclone.app.presentation.components.AuthOrnament
import com.airbnbclone.app.presentation.components.LoginScreenContent
import com.airbnbclone.app.presentation.screens.auth.LoginViewModel

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel(),
    onLoginSuccess: () -> Unit = {}
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    Box(modifier = Modifier.fillMaxSize()) {

        LoginScreenContent(
            uiState = uiState,
            onEmailChange = viewModel::updateEmailOrPhone,
            onPasswordChange = viewModel::updatePassword,
            onTogglePassword = viewModel::togglePasswordVisibility,
            onRememberMe = viewModel::toggleRememberMe,
            onLoginClick = { viewModel.login(onLoginSuccess) },
            onRegisterClick = { navController.navigate("auth/register") }
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .windowInsetsPadding(WindowInsets.statusBars)
                .height(48.dp),
            contentAlignment = Alignment.Center
        ) {

            AuthOrnament()
        }
    }
}


