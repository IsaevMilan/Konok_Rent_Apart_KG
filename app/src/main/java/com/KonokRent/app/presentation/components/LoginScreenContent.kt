package com.airbnbclone.app.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.KonokRent.app.presentation.components.CustomTextField
import com.KonokRent.app.presentation.components.LoadingScreen
import com.airbnbclone.app.presentation.screens.auth.LoginUiState
import com.airbnbclone.app.presentation.theme.AppColors
import kotlinx.coroutines.delay

@Composable
fun LoginScreenContent(
    uiState: LoginUiState,
    onEmailChange: (String) -> Unit = {},
    onPasswordChange: (String) -> Unit = {},
    onTogglePassword: () -> Unit = {},
    onRememberMe: () -> Unit = {},
    onLoginClick: () -> Unit = {},
    onRegisterClick: () -> Unit = {}
) {

    var showLoading by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        delay(2000)
        showLoading = false
    }

    if (showLoading) {
        LoadingScreen()
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            AuthLogo()

            Spacer(modifier = Modifier.height(48.dp))

            val robotoSemiBold = FontFamily.Default

            Text(
                text = "Добро пожаловать!",
                fontFamily = robotoSemiBold,
                fontWeight = FontWeight.SemiBold,
                fontStyle = FontStyle.Normal,
                fontSize = 24.sp,
                lineHeight = 20.sp,
                letterSpacing = 0.sp,
                color = AppColors.TextPrimary,
                textAlign = TextAlign.Start
            )

            Spacer(modifier = Modifier.height(32.dp))

            uiState.error?.let {
                Text(
                    text = it,
                    color = MaterialTheme.colorScheme.error,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }

            CustomTextField(
                value = uiState.emailOrPhone,
                onValueChange = onEmailChange,
                label = "Email или телефон",
                placeholder = "Введите email или телефон"
            )

            Spacer(modifier = Modifier.height(16.dp))

            CustomTextField(
                value = uiState.password,
                onValueChange = onPasswordChange,
                label = "Пароль",
                placeholder = "Введите пароль",
                visualTransformation =
                    if (uiState.passwordVisible) VisualTransformation.None
                    else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = onTogglePassword) {
                        Icon(
                            imageVector = if (uiState.passwordVisible)
                                Icons.Default.Visibility
                            else Icons.Default.VisibilityOff,
                            contentDescription = null
                        )
                    }
                }
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 0.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Левая часть: чекбокс + текст
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = uiState.rememberMe,
                        onCheckedChange = { onRememberMe() }
                    )

                    Spacer(modifier = Modifier.width(8.dp)) // небольшой отступ между чекбоксом и текстом

                    Text(
                        text = "Запомнить меня",
                        style = MaterialTheme.typography.bodyMedium,
                        color = AppColors.TextPrimary
                    )
                }

                Text(
                    text = "Забыли пароль?",
                    style = MaterialTheme.typography.bodyMedium,
                    color = AppColors.Primary,
                    modifier = Modifier.clickable {
                        //onForgotPasswordClick()
                    }
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            CustomButton(
                text = "Войти",
                onClick = onLoginClick,
                isLoading = uiState.isLoading,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = "Нет аккаунта?",
                )

                TextButton(onClick = onRegisterClick) {
                    Text("Зарегистрироваться")
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreenContent(
        uiState = LoginUiState(
            emailOrPhone = "",
            password = "123456",
            passwordVisible = false,
            rememberMe = true,
            isLoading = false,
            error = null
        )
    )
}



