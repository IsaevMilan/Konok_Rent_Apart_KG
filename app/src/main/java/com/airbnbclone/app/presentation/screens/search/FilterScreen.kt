package com.airbnbclone.app.presentation.screens.search

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.airbnbclone.app.presentation.components.CustomButton
import com.airbnbclone.app.presentation.theme.AppColors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterScreen(navController: NavController) {
    var priceRange by remember { mutableStateOf(1000f..10000f) }
    var guests by remember { mutableStateOf(1) }
    var selectedAmenities by remember { mutableStateOf(setOf<String>()) }
    var selectedPropertyTypes by remember { mutableStateOf(setOf<String>()) }

    val amenities = listOf("Wi-Fi", "Кондиционер", "Кухня", "Парковка", "Бассейн", "Тренажерный зал")
    val propertyTypes = listOf("Квартира", "Дом", "Студия", "Вилла")

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Фильтры") },
                navigationIcon = {
                    IconButton(onClick = { navController.pop() }) {
                        Icon(Icons.Default.Close, contentDescription = "Закрыть")
                    }
                },
                actions = {
                    TextButton(onClick = {
                        priceRange = 1000f..10000f
                        guests = 1
                        selectedAmenities = emptySet()
                        selectedPropertyTypes = emptySet()
                    }) {
                        Text("Сбросить", color = AppColors.Primary)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            )
        },
        bottomBar = {
            Surface(
                modifier = Modifier.fillMaxWidth(),
                shadowElevation = 8.dp
            ) {
                CustomButton(
                    text = "Применить фильтры",
                    onClick = { navController.pop() },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            // Price range
            Text(
                text = "Цена за ночь",
                style = MaterialTheme.typography.titleLarge,
                color = AppColors.TextPrimary
            )
            Spacer(modifier = Modifier.height(12.dp))
            RangeSlider(
                value = priceRange,
                onValueChange = { priceRange = it },
                valueRange = 0f..50000f,
                steps = 49
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("${priceRange.start.toInt()} ₽", color = AppColors.TextSecondary)
                Text("${priceRange.endInclusive.toInt()} ₽", color = AppColors.TextSecondary)
            }
            
            Spacer(modifier = Modifier.height(32.dp))
            
            // Guests
            Text(
                text = "Количество гостей",
                style = MaterialTheme.typography.titleLarge,
                color = AppColors.TextPrimary
            )
            Spacer(modifier = Modifier.height(12.dp))
            Surface(
                shape = MaterialTheme.shapes.medium,
                border = androidx.compose.foundation.BorderStroke(1.dp, AppColors.LightGrey)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Гостей", style = MaterialTheme.typography.bodyLarge)
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        IconButton(
                            onClick = { if (guests > 1) guests-- },
                            enabled = guests > 1
                        ) {
                            Icon(Icons.Default.RemoveCircleOutline, contentDescription = "Уменьшить")
                        }
                        Text(
                            text = guests.toString(),
                            style = MaterialTheme.typography.titleMedium
                        )
                        IconButton(onClick = { guests++ }) {
                            Icon(Icons.Default.AddCircleOutline, contentDescription = "Увеличить")
                        }
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(32.dp))
            
            // Property types
            Text(
                text = "Тип жилья",
                style = MaterialTheme.typography.titleLarge,
                color = AppColors.TextPrimary
            )
            Spacer(modifier = Modifier.height(12.dp))
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                propertyTypes.forEach { type ->
                    FilterChip(
                        selected = selectedPropertyTypes.contains(type),
                        onClick = {
                            selectedPropertyTypes = if (selectedPropertyTypes.contains(type)) {
                                selectedPropertyTypes - type
                            } else {
                                selectedPropertyTypes + type
                            }
                        },
                        label = { Text(type) }
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(32.dp))
            
            // Amenities
            Text(
                text = "Удобства",
                style = MaterialTheme.typography.titleLarge,
                color = AppColors.TextPrimary
            )
            Spacer(modifier = Modifier.height(12.dp))
            amenities.forEach { amenity ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .toggleable(
                            value = selectedAmenities.contains(amenity),
                            onValueChange = {
                                selectedAmenities = if (selectedAmenities.contains(amenity)) {
                                    selectedAmenities - amenity
                                } else {
                                    selectedAmenities + amenity
                                }
                            },
                            role = Role.Checkbox
                        )
                        .padding(vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = selectedAmenities.contains(amenity),
                        onCheckedChange = null
                    )
                    Text(
                        text = amenity,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(100.dp)) // Space for bottom bar
        }
    }
}

