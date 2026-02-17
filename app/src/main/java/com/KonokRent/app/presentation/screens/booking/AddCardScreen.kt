package com.airbnbclone.app.presentation.screens.booking

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.airbnbclone.app.presentation.components.CustomButton
import com.KonokRent.app.presentation.components.CustomTextField
import com.airbnbclone.app.presentation.theme.AppColors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddCardScreen(
    navController: NavController,
    viewModel: AddCardViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Добавить карту") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Назад")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            // Card preview
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(AppColors.Primary, AppColors.DarkGrey)
                        ),
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(24.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Surface(
                            modifier = Modifier.size(width = 50.dp, height = 30.dp),
                            shape = RoundedCornerShape(4.dp),
                            color = Color.White.copy(alpha = 0.3f)
                        ) {}
                        Icon(
                            Icons.Default.CreditCard,
                            contentDescription = null,
                            modifier = Modifier.size(40.dp),
                            tint = Color.White.copy(alpha = 0.8f)
                        )
                    }
                    
                    Column {
                        Text(
                            text = if (uiState.cardNumber.isEmpty()) "**** **** **** ****"
                            else uiState.cardNumber.padEnd(19, '*').take(19),
                            style = MaterialTheme.typography.headlineMedium,
                            color = Color.White,
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column {
                                Text(
                                    text = "CARDHOLDER",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = Color.White.copy(alpha = 0.7f)
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = if (uiState.cardholder.isEmpty()) "FULL NAME"
                                    else uiState.cardholder.uppercase(),
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = Color.White
                                )
                            }
                            Column(horizontalAlignment = Alignment.End) {
                                Text(
                                    text = "EXPIRES",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = Color.White.copy(alpha = 0.7f)
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = if (uiState.expiry.isEmpty()) "MM/YY" else uiState.expiry,
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = Color.White
                                )
                            }
                        }
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(24.dp))
            
            uiState.error?.let { error ->
                Text(
                    text = error,
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }
            
            // Card number
            CustomTextField(
                value = uiState.cardNumber,
                onValueChange = viewModel::updateCardNumber,
                label = "Номер карты",
                placeholder = "1234 5678 9012 3456",
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Cardholder
            CustomTextField(
                value = uiState.cardholder,
                onValueChange = viewModel::updateCardholder,
                label = "Имя держателя карты",
                placeholder = "IVAN IVANOV",
                modifier = Modifier.fillMaxWidth()
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Expiry and CVV
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                CustomTextField(
                    value = uiState.expiry,
                    onValueChange = viewModel::updateExpiry,
                    label = "Срок действия",
                    placeholder = "MM/YY",
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.weight(1f)
                )
                CustomTextField(
                    value = uiState.cvv,
                    onValueChange = viewModel::updateCvv,
                    label = "CVV",
                    placeholder = "123",
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    visualTransformation = if (uiState.cvvVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        IconButton(onClick = viewModel::toggleCvvVisibility) {
                            Icon(
                                if (uiState.cvvVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                                contentDescription = null
                            )
                        }
                    },
                    modifier = Modifier.weight(1f)
                )
            }
            
            Spacer(modifier = Modifier.height(32.dp))
            
            // Save button
            CustomButton(
                text = "Сохранить карту",
                onClick = { viewModel.saveCard { navController.popBackStack() } },
                isLoading = uiState.isLoading,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview(showBackground = true, name = "AddCardScreen - Filled")
@Composable
fun AddCardScreenFilledPreview() {
    MaterialTheme {
        AddCardContent(
            uiState = AddCardUiState(
                cardNumber = "4111 1111 1111 1111",
                cardholder = "MARLEN ASKARBEKOV",
                expiry = "12/28",
                cvv = "123",
                cvvVisible = false,
                isLoading = false,
                error = null
            ),

            onSave = {},
            navController = rememberNavController()
        )
    }
}

@Preview(showBackground = true, name = "AddCardScreen - Empty")
@Composable
fun AddCardScreenEmptyPreview() {
    MaterialTheme {
        AddCardContent(
            uiState = AddCardUiState(),
            // пустые лямбды
            navController = rememberNavController(),
            onSave= {}
        )
    }
}

// Вынеси Column в AddCardContent(...)
@Composable
private fun AddCardContent(
    uiState: AddCardUiState,
    // ... все onChange и toggle
    onSave: () -> Unit,
    navController: NavController
) {
    Scaffold(
        topBar = { /* ... */ }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding()
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            // Card preview
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(AppColors.Primary, AppColors.DarkGrey)
                        ),
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(24.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Surface(
                            modifier = Modifier.size(width = 50.dp, height = 30.dp),
                            shape = RoundedCornerShape(4.dp),
                            color = Color.White.copy(alpha = 0.3f)
                        ) {}
                        Icon(
                            Icons.Default.CreditCard,
                            contentDescription = null,
                            modifier = Modifier.size(40.dp),
                            tint = Color.White.copy(alpha = 0.8f)
                        )
                    }

                    Column {
                        Text(
                            text = if (uiState.cardNumber.isEmpty()) "**** **** **** ****"
                            else uiState.cardNumber.padEnd(19, '*').take(19),
                            style = MaterialTheme.typography.headlineMedium,
                            color = Color.White,
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column {
                                Text(
                                    text = "CARDHOLDER",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = Color.White.copy(alpha = 0.7f)
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = if (uiState.cardholder.isEmpty()) "FULL NAME"
                                    else uiState.cardholder.uppercase(),
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = Color.White
                                )
                            }
                            Column(horizontalAlignment = Alignment.End) {
                                Text(
                                    text = "EXPIRES",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = Color.White.copy(alpha = 0.7f)
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = if (uiState.expiry.isEmpty()) "MM/YY" else uiState.expiry,
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = Color.White
                                )
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            uiState.error?.let { error ->
                Text(
                    text = error,
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }

            // Card number
            CustomTextField(
                value = uiState.cardNumber,
                onValueChange = {},
                label = "Номер карты",
                placeholder = "1234 5678 9012 3456",
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Cardholder
            CustomTextField(
                value = uiState.cardholder,
                onValueChange = {},
                label = "Имя держателя карты",
                placeholder = "IVAN IVANOV",
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Expiry and CVV
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                CustomTextField(
                    value = uiState.expiry,
                    onValueChange = {  },
                    label = "Срок действия",
                    placeholder = "MM/YY",
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.weight(1f)
                )
                CustomTextField(
                    value = uiState.cvv,
                    onValueChange = {},
                    label = "CVV",
                    placeholder = "123",
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    visualTransformation = if (uiState.cvvVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        IconButton({}) {
                            Icon(
                                if (uiState.cvvVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                                contentDescription = null
                            )
                        }
                    },
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Save button
            CustomButton(
                text = "Сохранить карту",
                onClick = {   },
                isLoading = uiState.isLoading,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}


