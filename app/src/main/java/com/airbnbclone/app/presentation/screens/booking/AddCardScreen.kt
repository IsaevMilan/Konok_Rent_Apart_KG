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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.airbnbclone.app.presentation.components.CustomButton
import com.airbnbclone.app.presentation.components.CustomTextField
import com.airbnbclone.app.presentation.theme.AppColors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddCardScreen(navController: NavController) {
    var cardNumber by remember { mutableStateOf("") }
    var cardholder by remember { mutableStateOf("") }
    var expiry by remember { mutableStateOf("") }
    var cvv by remember { mutableStateOf("") }
    var cvvVisible by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Добавить карту") },
                navigationIcon = {
                    IconButton(onClick = { navController.pop() }) {
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
                            text = if (cardNumber.isEmpty()) "**** **** **** ****"
                            else formatCardNumber(cardNumber),
                            style = MaterialTheme.typography.headlineMedium,
                            color = Color.White,
                            letterSpacing = 2.dp
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
                                    text = if (cardholder.isEmpty()) "FULL NAME"
                                    else cardholder.uppercase(),
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
                                    text = if (expiry.isEmpty()) "MM/YY" else expiry,
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = Color.White
                                )
                            }
                        }
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // Card number
            CustomTextField(
                value = cardNumber,
                onValueChange = { 
                    if (it.length <= 19 && it.all { char -> char.isDigit() || char == ' ' }) {
                        cardNumber = it
                    }
                },
                label = "Номер карты",
                placeholder = "1234 5678 9012 3456",
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Cardholder
            CustomTextField(
                value = cardholder,
                onValueChange = { cardholder = it },
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
                    value = expiry,
                    onValueChange = { 
                        if (it.length <= 5 && (it.all { char -> char.isDigit() || char == '/' })) {
                            expiry = it
                        }
                    },
                    label = "Срок действия",
                    placeholder = "MM/YY",
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.weight(1f)
                )
                CustomTextField(
                    value = cvv,
                    onValueChange = { 
                        if (it.length <= 3 && it.all { char -> char.isDigit() }) {
                            cvv = it
                        }
                    },
                    label = "CVV",
                    placeholder = "123",
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    visualTransformation = if (cvvVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        IconButton(onClick = { cvvVisible = !cvvVisible }) {
                            Icon(
                                if (cvvVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
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
                onClick = {
                    if (cardNumber.isNotBlank() && cardholder.isNotBlank() && 
                        expiry.isNotBlank() && cvv.length == 3) {
                        // TODO: Save card
                        navController.pop()
                    }
                },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

private fun formatCardNumber(number: String): String {
    val cleaned = number.replace(" ", "")
    return cleaned.chunked(4).joinToString(" ")
}

