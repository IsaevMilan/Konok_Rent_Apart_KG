package com.airbnbclone.app.presentation.screens.auth



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

/*@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel(),
    onLoginSuccess: () -> Unit = {}
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Logo
        AuthLogo()
        
        Spacer(modifier = Modifier.height(48.dp))
        
        // Title
        Text(
            text = "Вход",
            style = MaterialTheme.typography.headlineLarge,
            color = AppColors.TextPrimary
        )
        
        Spacer(modifier = Modifier.height(32.dp))
        
        // Error message
        uiState.error?.let { error ->
            Text(
                text = error,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }
        
        // Email/Phone field
        CustomTextField(
            value = uiState.emailOrPhone,
            onValueChange = viewModel::updateEmailOrPhone,
            label = "Email или телефон",
            placeholder = "Введите email или телефон",
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Password field
        CustomTextField(
            value = uiState.password,
            onValueChange = viewModel::updatePassword,
            label = "Пароль",
            placeholder = "Введите пароль",
            visualTransformation = if (uiState.passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = viewModel::togglePasswordVisibility) {
                    Icon(
                        imageVector = if (uiState.passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                        contentDescription = if (uiState.passwordVisible) "Скрыть пароль" else "Показать пароль"
                    )
                }
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
        
        Spacer(modifier = Modifier.height(8.dp))
        
        // Remember me
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = uiState.rememberMe,
                onCheckedChange = { viewModel.toggleRememberMe() }
            )
            Text(
                text = "Запомнить меня",
                style = MaterialTheme.typography.bodyMedium,
                color = AppColors.TextSecondary
            )
        }
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Login button
        CustomButton(
            text = "Войти",
            onClick = { viewModel.login(onLoginSuccess) },
            isLoading = uiState.isLoading,
            modifier = Modifier.fillMaxWidth()
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Forgot password
        TextButton(onClick = { *//* TODO *//* }) {
            Text("Забыли пароль?")
        }
        
        Spacer(modifier = Modifier.height(32.dp))
        
        // Divider
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            HorizontalDivider(modifier = Modifier.weight(1f))
            Text(
                text = "или",
                modifier = Modifier.padding(horizontal = 16.dp),
                style = MaterialTheme.typography.bodyMedium,
                color = AppColors.TextSecondary
            )
            HorizontalDivider(modifier = Modifier.weight(1f))
        }
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Social login buttons
        SocialLoginButton(
            text = "Войти через Google",
            onClick = { *//* TODO *//* },
            backgroundColor = AppColors.GoogleBlue
        )
        
        Spacer(modifier = Modifier.height(12.dp))
        
        SocialLoginButton(
            text = "Войти через Facebook",
            onClick = { *//* TODO *//* },
            backgroundColor = AppColors.FacebookBlue
        )
        
        Spacer(modifier = Modifier.height(12.dp))
        
        SocialLoginButton(
            text = "Войти через Apple",
            onClick = { *//* TODO *//* },
            backgroundColor = AppColors.AppleBlack
        )
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Register link
        Row {
            Text(
                text = "Нет аккаунта? ",
                style = MaterialTheme.typography.bodyMedium,
                color = AppColors.TextSecondary
            )
            TextButton(onClick = { navController.navigate("auth/register") }) {
                Text("Зарегистрироваться")
            }
        }
    }
}*/

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


