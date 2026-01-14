package com.KonokRent.app.presentation.components


import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnbclone.app.presentation.components.AuthOrnament
import com.airbnbclone.app.presentation.components.LoginScreenContent
import com.airbnbclone.app.presentation.screens.auth.LoginUiState

// 1. Создаем превью для всего экрана с системным UI

@Preview(
    name = "Login Screen with Status Bar Logo",
    showBackground = true,
    showSystemUi = true, // ОБЯЗАТЕЛЬНО: показывает часы и батарею
    device = Devices.PIXEL_7 // Можно выбрать конкретное устройство
)
@Composable
fun LoginScreenFullPreview() {
    // Используйте вашу тему (обычно называется по названию проекта)
    // В вашем коде это AirbnbCloneTheme
    MaterialTheme {
        // Имитируем структуру LoginScreen
        Box(modifier = Modifier.fillMaxSize()) {

            // Основной контент (форма входа)
            LoginScreenContent(
                uiState = LoginUiState(
                    emailOrPhone = "test@mail.ru",
                    password = "password",
                    passwordVisible = false,
                    rememberMe = true,
                    isLoading = false
                ),
                onEmailChange = {},
                onPasswordChange = {},
                onTogglePassword = {},
                onRememberMe = {},
                onLoginClick = {},
                onRegisterClick = {}
            )

            // Тот самый орнамент, который мы "вставляем" в статус-бар
            // В превью он будет виден в самой верхней части
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp), // Небольшой отступ сверху для точности
                contentAlignment = Alignment.TopCenter
            ) {
                AuthOrnament()
            }
        }
    }
}