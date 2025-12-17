package com.airbnbclone.app.presentation.screens.listing

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.airbnbclone.app.presentation.components.CustomButton
import com.airbnbclone.app.presentation.theme.AppColors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListingScreen(
    navController: NavController,
    listingId: String
) {
    val scrollState = rememberScrollState()

    Scaffold(
        body = {
            Column(modifier = Modifier.fillMaxSize()) {
                // Image header
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                        .background(AppColors.LightGrey)
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            Icons.Default.Home,
                            contentDescription = null,
                            modifier = Modifier.size(100.dp),
                            tint = AppColors.Grey
                        )
                    }
                    
                    // Top bar
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        IconButton(
                            onClick = { navController.pop() },
                            modifier = Modifier.background(
                                MaterialTheme.colorScheme.surface.copy(alpha = 0.8f),
                                CircleShape
                            )
                        ) {
                            Icon(Icons.Default.ArrowBack, contentDescription = "Назад", tint = AppColors.White)
                        }
                        Row {
                            IconButton(
                                onClick = { /* TODO */ },
                                modifier = Modifier.background(
                                    MaterialTheme.colorScheme.surface.copy(alpha = 0.8f),
                                    CircleShape
                                )
                            ) {
                                Icon(Icons.Default.Share, contentDescription = "Поделиться", tint = AppColors.White)
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            IconButton(
                                onClick = { /* TODO */ },
                                modifier = Modifier.background(
                                    MaterialTheme.colorScheme.surface.copy(alpha = 0.8f),
                                    CircleShape
                                )
                            ) {
                                Icon(Icons.Default.FavoriteBorder, contentDescription = "В избранное", tint = AppColors.White)
                            }
                        }
                    }
                }

                // Content
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .verticalScroll(scrollState)
                        .padding(16.dp)
                ) {
                    // Title
                    Text(
                        text = "Уютная квартира в центре",
                        style = MaterialTheme.typography.headlineMedium,
                        color = AppColors.TextPrimary
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            Icons.Default.LocationOn,
                            contentDescription = null,
                            modifier = Modifier.size(16.dp),
                            tint = AppColors.TextSecondary
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "Москва, Россия",
                            style = MaterialTheme.typography.bodyMedium,
                            color = AppColors.TextSecondary
                        )
                    }
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    // Rating
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            Icons.Default.Star,
                            contentDescription = null,
                            tint = Color(0xFFFFC107),
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "4.8",
                            style = MaterialTheme.typography.titleMedium
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        TextButton(onClick = {
                            navController.navigate("listing/$listingId/reviews")
                        }) {
                            Text("(128 отзывов)", color = AppColors.TextSecondary)
                        }
                    }
                    
                    Divider(modifier = Modifier.padding(vertical = 16.dp))
                    
                    // Host info
                    Row {
                        Surface(
                            modifier = Modifier.size(64.dp),
                            shape = CircleShape,
                            color = AppColors.LightGrey
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Icon(
                                    Icons.Default.Person,
                                    contentDescription = null,
                                    modifier = Modifier.size(32.dp),
                                    tint = AppColors.Grey
                                )
                            }
                        }
                        Spacer(modifier = Modifier.width(16.dp))
                        Column {
                            Text(
                                text = "Хозяин: Иван Иванов",
                                style = MaterialTheme.typography.titleMedium
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "На Airbnb с 2020 года",
                                style = MaterialTheme.typography.bodyMedium,
                                color = AppColors.TextSecondary
                            )
                        }
                    }
                    
                    Divider(modifier = Modifier.padding(vertical = 16.dp))
                    
                    // Features
                    FeatureRow(Icons.Default.Bed, "2 спальни")
                    Spacer(modifier = Modifier.height(12.dp))
                    FeatureRow(Icons.Default.Bathtub, "1 ванная")
                    Spacer(modifier = Modifier.height(12.dp))
                    FeatureRow(Icons.Default.People, "До 4 гостей")
                    Spacer(modifier = Modifier.height(12.dp))
                    FeatureRow(Icons.Default.Wifi, "Wi-Fi")
                    
                    Divider(modifier = Modifier.padding(vertical = 16.dp))
                    
                    // Description
                    Text(
                        text = "Описание",
                        style = MaterialTheme.typography.titleLarge,
                        color = AppColors.TextPrimary
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = "Уютная квартира в самом центре города. Идеально подходит для отдыха и работы. Рядом находятся все основные достопримечательности.",
                        style = MaterialTheme.typography.bodyLarge,
                        color = AppColors.TextSecondary
                    )
                    
                    Spacer(modifier = Modifier.height(32.dp))
                    
                    // Book button
                    CustomButton(
                        text = "Забронировать",
                        onClick = { navController.navigate("booking") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    )
}

@Composable
fun FeatureRow(icon: androidx.compose.ui.graphics.vector.ImageVector, text: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            icon,
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            tint = AppColors.TextPrimary
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge,
            color = AppColors.TextPrimary
        )
    }
}

