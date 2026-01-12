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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.airbnbclone.app.presentation.components.CustomButton
import com.airbnbclone.app.presentation.theme.AppColors

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun FilterScreen(
    navController: NavController,
    viewModel: FilterViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    val amenities = listOf("Wi-Fi", "Кондиционер", "Кухня", "Парковка", "Бассейн", "Тренажерный зал")
    val propertyTypes = listOf("Квартира", "Дом", "Студия", "Вилла")

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Фильтры") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.Close, contentDescription = "Закрыть")
                    }
                },
                actions = {
                    TextButton(onClick = viewModel::resetFilters) {
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
                    onClick = { navController.popBackStack() },
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
                value = uiState.priceRange,
                onValueChange = viewModel::updatePriceRange,
                valueRange = 0f..50000f,
                steps = 49
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("${uiState.priceRange.start.toInt()} ₽", color = AppColors.TextSecondary)
                Text("${uiState.priceRange.endInclusive.toInt()} ₽", color = AppColors.TextSecondary)
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
                            onClick = viewModel::decrementGuests,
                            enabled = uiState.guests > 1
                        ) {
                            Icon(Icons.Default.RemoveCircleOutline, contentDescription = "Уменьшить")
                        }
                        Text(
                            text = uiState.guests.toString(),
                            style = MaterialTheme.typography.titleMedium
                        )
                        IconButton(onClick = viewModel::incrementGuests) {
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
                        selected = uiState.selectedPropertyTypes.contains(type),
                        onClick = { viewModel.togglePropertyType(type) },
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
                            value = uiState.selectedAmenities.contains(amenity),
                            onValueChange = { viewModel.toggleAmenity(amenity) },
                            role = Role.Checkbox
                        )
                        .padding(vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = uiState.selectedAmenities.contains(amenity),
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

