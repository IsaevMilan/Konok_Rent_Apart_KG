package com.airbnbclone.app.presentation.screens.auth

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.airbnbclone.app.domain.repository.AuthRepository
import com.airbnbclone.app.presentation.components.CustomButton
import com.airbnbclone.app.presentation.theme.AppColors
import kotlinx.coroutines.launch

@Composable
fun VerifyCodeScreen(
    navController: NavController,
    phoneNumber: String? = null,
    onVerifySuccess: () -> Unit = {}
) {
    // Для VerifyCodeViewModel нужен phoneNumber, создаем его вручную
     // Это не сработает
    
    // Используем локальное состояние для VerifyCodeScreen, так как нужен phoneNumber из навигации
    var code by remember { mutableStateOf("") }
    var canResend by remember { mutableStateOf(false) }
    var resendCountdown by remember { mutableStateOf(30) }
    var isLoading by remember { mutableStateOf(false) }
    var error by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(Unit) {
        while (resendCountdown > 0) {
            kotlinx.coroutines.delay(1000)
            resendCountdown--
        }
        canResend = true
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Подтверждение кода",
            style = MaterialTheme.typography.headlineLarge,
            color = AppColors.TextPrimary
        )
        
        Spacer(modifier = Modifier.height(8.dp))
        
        Text(
            text = "Введите код, отправленный на\n$phoneNumber",
            style = MaterialTheme.typography.bodyMedium,
            color = AppColors.TextSecondary,
            textAlign = androidx.compose.ui.text.style.TextAlign.Center
        )
        
        Spacer(modifier = Modifier.height(48.dp))
        
        error?.let { errorText ->
            Text(
                text = errorText,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }
        
        // Code input field
        OutlinedTextField(
            value = code,
            onValueChange = { if (it.length <= 6 && it.all { char -> char.isDigit() }) code = it },
            modifier = Modifier.width(200.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            textStyle = MaterialTheme.typography.headlineMedium,
            singleLine = true,
            maxLines = 1,
            placeholder = { Text("000000") }
        )
        
        Spacer(modifier = Modifier.height(32.dp))
        
        CustomButton(
            text = "Подтвердить",
            onClick = {
                if (code.length == 6) {
                    isLoading = true
                    error = null
                    // Мок: любой код проходит
                    kotlinx.coroutines.CoroutineScope(kotlinx.coroutines.Dispatchers.Main).launch {
                        kotlinx.coroutines.delay(1000)
                        isLoading = false
                        onVerifySuccess()
                    }
                } else {
                    error = "Введите 6-значный код"
                }
            },
            isLoading = isLoading,
            modifier = Modifier.fillMaxWidth()
        )
        
        Spacer(modifier = Modifier.height(24.dp))
        
        if (canResend) {
            TextButton(onClick = {
                canResend = false
                resendCountdown = 30
            }) {
                Text("Отправить код повторно")
            }
        } else {
            Text(
                text = "Отправить код повторно через $resendCountdown сек",
                style = MaterialTheme.typography.bodySmall,
                color = AppColors.TextSecondary
            )
        }
    }
}

