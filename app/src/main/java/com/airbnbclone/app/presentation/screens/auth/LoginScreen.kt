package com.airbnbclone.app.presentation.screens.auth

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.airbnbclone.app.presentation.components.CustomButton
import com.airbnbclone.app.presentation.components.CustomTextField
import com.airbnbclone.app.presentation.components.SocialLoginButton
import com.airbnbclone.app.presentation.theme.AppColors

@Composable
fun LoginScreen(
    navController: NavController,
    onLoginSuccess: () -> Unit = {}
) {
    var emailOrPhone by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var rememberMe by remember { mutableStateOf(false) }
    var isLoading by remember { mutableStateOf(false) }

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
        
        // Email/Phone field
        CustomTextField(
            value = emailOrPhone,
            onValueChange = { emailOrPhone = it },
            label = "Email или телефон",
            placeholder = "Введите email или телефон",
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Password field
        CustomTextField(
            value = password,
            onValueChange = { password = it },
            label = "Пароль",
            placeholder = "Введите пароль",
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(
                        imageVector = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                        contentDescription = if (passwordVisible) "Скрыть пароль" else "Показать пароль"
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
                checked = rememberMe,
                onCheckedChange = { rememberMe = it }
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
            onClick = {
                isLoading = true
                // TODO: Implement login logic
                onLoginSuccess()
            },
            isLoading = isLoading,
            modifier = Modifier.fillMaxWidth()
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Forgot password
        TextButton(onClick = { /* TODO */ }) {
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
            onClick = { /* TODO */ },
            backgroundColor = AppColors.GoogleBlue
        )
        
        Spacer(modifier = Modifier.height(12.dp))
        
        SocialLoginButton(
            text = "Войти через Facebook",
            onClick = { /* TODO */ },
            backgroundColor = AppColors.FacebookBlue
        )
        
        Spacer(modifier = Modifier.height(12.dp))
        
        SocialLoginButton(
            text = "Войти через Apple",
            onClick = { /* TODO */ },
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
            TextButton(onClick = { navController.navigate("register") }) {
                Text("Зарегистрироваться")
            }
        }
    }
}

