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
import com.airbnbclone.app.presentation.components.AuthLogo
import com.airbnbclone.app.presentation.theme.AppColors

@Composable
fun RegisterScreen(
    navController: NavController,
    onRegisterSuccess: (String) -> Unit = {}
) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var acceptTerms by remember { mutableStateOf(false) }
    var isLoading by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AuthLogo()
        
        Spacer(modifier = Modifier.height(48.dp))
        
        Text(
            text = "Регистрация",
            style = MaterialTheme.typography.headlineLarge,
            color = AppColors.TextPrimary
        )
        
        Spacer(modifier = Modifier.height(32.dp))
        
        CustomTextField(
            value = name,
            onValueChange = { name = it },
            label = "Имя",
            placeholder = "Введите ваше имя"
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        CustomTextField(
            value = email,
            onValueChange = { email = it },
            label = "Email",
            placeholder = "Введите email",
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        CustomTextField(
            value = phone,
            onValueChange = { phone = it },
            label = "Телефон",
            placeholder = "+7 (999) 999-99-99",
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
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
                        contentDescription = null
                    )
                }
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = acceptTerms,
                onCheckedChange = { acceptTerms = it }
            )
            Text(
                text = "Я принимаю условия использования",
                style = MaterialTheme.typography.bodyMedium,
                color = AppColors.TextSecondary
            )
        }
        
        Spacer(modifier = Modifier.height(24.dp))
        
        CustomButton(
            text = "Зарегистрироваться",
            onClick = {
                if (acceptTerms) {
                    isLoading = true
                    // TODO: Implement register logic
                    onRegisterSuccess(phone)
                }
            },
            isLoading = isLoading,
            modifier = Modifier.fillMaxWidth()
        )
        
        Spacer(modifier = Modifier.height(32.dp))
        
        Row {
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
        
        Spacer(modifier = Modifier.height(24.dp))
        
        Row {
            Text(
                text = "Уже есть аккаунт? ",
                style = MaterialTheme.typography.bodyMedium,
                color = AppColors.TextSecondary
            )
            TextButton(onClick = { navController.navigate("login") }) {
                Text("Войти")
            }
        }
    }
}

