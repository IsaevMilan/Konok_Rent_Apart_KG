package com.airbnbclone.app.presentation.screens.auth

import androidx.compose.foundation.BasicTooltipState
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.airbnbclone.app.presentation.components.CustomButton
import com.KonokRent.app.presentation.components.CustomTextField
import com.airbnbclone.app.R
import com.airbnbclone.app.presentation.components.SocialLoginButton
import com.airbnbclone.app.presentation.components.AuthLogo
import com.airbnbclone.app.presentation.theme.AppColors

@Composable
fun RegisterScreen(
    navController: NavController,
    viewModel: RegisterViewModel = hiltViewModel(),
    onRegisterSuccess: (String) -> Unit = {}
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

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
        
        uiState.error?.let { error ->
            Text(
                text = error,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }
        
        CustomTextField(
            value = uiState.name,
            onValueChange = viewModel::updateName,
            label = "Имя",
            placeholder = "Введите ваше имя"
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        CustomTextField(
            value = uiState.email,
            onValueChange = viewModel::updateEmail,
            label = "Email",
            placeholder = "Введите email",
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        CustomTextField(
            value = uiState.phone,
            onValueChange = viewModel::updatePhone,
            label = "Телефон",
            placeholder = "+7 (999) 999-99-99",
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
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
                        contentDescription = null
                    )
                }
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        CustomTextField(
            value = uiState.confirmPassword,
            onValueChange = viewModel::updateConfirmPassword,
            label = "Подтвердите пароль",
            placeholder = "Повторите пароль",
            visualTransformation = if (uiState.confirmPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = viewModel::toggleConfirmPasswordVisibility) {
                    Icon(
                        imageVector = if (uiState.confirmPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                        contentDescription = null
                    )
                }
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
        
        Spacer(modifier = Modifier.height(24.dp))
        
        CustomButton(
            text = "Зарегистрироваться",
            onClick = { viewModel.register(onRegisterSuccess) },
            isLoading = uiState.isLoading,
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

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            Arrangement.Center
        ){
            SocialLoginButton(
                icon = painterResource(id = R.drawable.flat_color_icons_google),
                onClick = { /* TODO */ },

                )

            Spacer(modifier = Modifier.width(18.dp))

            SocialLoginButton(
                icon = painterResource(id = R.drawable.icon_round_apple),
                onClick = { /* TODO */ },
            )

            Spacer(modifier = Modifier.width(18.dp))

            SocialLoginButton(
                icon = painterResource(id = R.drawable.logos_facebook),
                onClick = { /* TODO */ },
            )

        }

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Есть аккаунт? ",
                style = MaterialTheme.typography.bodyMedium,
                color = AppColors.TextSecondary
            )
            TextButton(onClick = { navController.navigate("auth/login") }) {
                Text("Войти")
            }
        }
    }
}


//Создал превью и клонов ниже без вьюмодель
// что бы удобно можно было отредактировать

@Preview(showBackground = true, name = "RegisterScreen - Default", device = Devices.PIXEL_6)
@Composable
fun RegisterScreenPreview() {
    MaterialTheme {
        RegisterContent(
            uiState = RegisterUiState(
                name = "Марлен",
                email = "marlen@example.com",
                phone = "+996701392423",
                password = "password123",
                confirmPassword = "password123",
                passwordVisible = false,
                confirmPasswordVisible = false,
                isLoading = false,
                error = null
            ),
            onNameChange = {},

            navController = rememberNavController()
        )
    }
}

@Preview(showBackground = true, name = "RegisterScreen - Error")
@Composable
fun RegisterScreenErrorPreview() {
    MaterialTheme {
        RegisterContent(
            uiState = RegisterUiState(
                name = "",
                email = "",
                phone = "",
                password = "",
                confirmPassword = "",
                isLoading = false,
                error = "Email уже используется"
            ),
            // ... лямбды пустые
            onNameChange = {}, /* и т.д. */
            navController = rememberNavController()
        )
    }
}


@Composable
private fun RegisterContent(
    uiState: RegisterUiState,
    onNameChange: (String) -> Unit,
    // ... все остальные коллбэки
    navController: NavController
) {
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

        uiState.error?.let { error ->
            Text(
                text = error,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }

        CustomTextField(
            value = uiState.name,
            onValueChange = {  },
            label = "Имя",
            placeholder = "Введите ваше имя"
        )

        Spacer(modifier = Modifier.height(16.dp))

        CustomTextField(
            value = uiState.email,
            onValueChange = {  },
            label = "Email",
            placeholder = "Введите email",
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        Spacer(modifier = Modifier.height(16.dp))

        CustomTextField(
            value = uiState.phone,
            onValueChange = {},
            label = "Телефон",
            placeholder = "+7 (999) 999-99-99",
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
        )

        Spacer(modifier = Modifier.height(16.dp))

        CustomTextField(
            value = uiState.password,
            onValueChange = {},
            label = "Пароль",
            placeholder = "Введите пароль",
            visualTransformation = if (uiState.passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = if (uiState.passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                        contentDescription = null
                    )
                }
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        Spacer(modifier = Modifier.height(16.dp))

        CustomTextField(
            value = uiState.confirmPassword,
            onValueChange = {},
            label = "Подтвердите пароль",
            placeholder = "Повторите пароль",
            visualTransformation = if (uiState.confirmPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = if (uiState.confirmPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                        contentDescription = null
                    )
                }
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        Spacer(modifier = Modifier.height(24.dp))

        CustomButton(
            text = "Зарегистрироваться",
            onClick = {  },
            isLoading = uiState.isLoading,
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

        Row(
            modifier = Modifier
                .fillMaxWidth(),
Arrangement.Center
            ){
            SocialLoginButton(
                icon = painterResource(id = R.drawable.flat_color_icons_google),
                onClick = { /* TODO */ },

                )

            Spacer(modifier = Modifier.width(18.dp))

            SocialLoginButton(
                icon = painterResource(id = R.drawable.icon_round_apple),
                onClick = { /* TODO */ },
            )

            Spacer(modifier = Modifier.width(18.dp))

            SocialLoginButton(
                icon = painterResource(id = R.drawable.logos_facebook),
                onClick = { /* TODO */ },
            )

        }

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Есть аккаунт? ",
                style = MaterialTheme.typography.bodyMedium,
                color = AppColors.TextSecondary
            )
            TextButton(onClick = { navController.navigate("auth/login") }) {
                Text("Войти")
            }
        }
    }
}

