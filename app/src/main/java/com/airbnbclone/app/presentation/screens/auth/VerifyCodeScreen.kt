package com.airbnbclone.app.presentation.screens.auth

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.airbnbclone.app.presentation.components.CustomButton
import com.airbnbclone.app.presentation.theme.AppColors
import kotlinx.coroutines.delay

@Composable
fun VerifyCodeScreen(
    navController: NavController,
    phoneNumber: String? = null,
    onVerifySuccess: () -> Unit = {}
) {
    val codeFields = remember { List(6) { mutableStateOf("") } }
    var canResend by remember { mutableStateOf(false) }
    var resendCountdown by remember { mutableStateOf(30) }
    var isLoading by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        while (resendCountdown > 0) {
            delay(1000)
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
        
        // Code input fields
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            codeFields.forEachIndexed { index, state ->
                OutlinedTextField(
                    value = state.value,
                    onValueChange = { value ->
                        if (value.length <= 1 && value.all { it.isDigit() }) {
                            state.value = value
                            // Auto-focus next field
                        }
                    },
                    modifier = Modifier.width(48.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    textStyle = MaterialTheme.typography.headlineMedium,
                    singleLine = true,
                    maxLines = 1
                )
            }
        }
        
        Spacer(modifier = Modifier.height(32.dp))
        
        CustomButton(
            text = "Подтвердить",
            onClick = {
                val code = codeFields.joinToString("") { it.value }
                if (code.length == 6) {
                    isLoading = true
                    // TODO: Implement verify logic
                    onVerifySuccess()
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
                // TODO: Resend code
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

