package com.airbnbclone.app.presentation.screens.listing

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Bathtub
import androidx.compose.material.icons.filled.Bed
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Wifi
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.airbnbclone.app.presentation.components.CustomButton
import com.airbnbclone.app.presentation.theme.AppColors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListingScreen(
    navController: NavController,
    listingId: String,
    viewModel: ListingViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val scrollState = rememberScrollState()

    LaunchedEffect(listingId) {
        viewModel.init(listingId)
    }

    Scaffold(
        content = { paddingValues ->
            if (uiState.isLoading) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            } else {
                uiState.listing?.let { listing ->
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
                                    onClick = { navController.popBackStack() },
                                    modifier = Modifier.background(
                                        MaterialTheme.colorScheme.surface.copy(alpha = 0.8f),
                                        CircleShape
                                    )
                                ) {
                                    Icon(
                                        Icons.Default.ArrowBack,
                                        contentDescription = "Назад",
                                        tint = AppColors.White
                                    )
                                }
                                Row {
                                    IconButton(
                                        onClick = { /* TODO */ },
                                        modifier = Modifier.background(
                                            MaterialTheme.colorScheme.surface.copy(alpha = 0.8f),
                                            CircleShape
                                        )
                                    ) {
                                        Icon(
                                            Icons.Default.Share,
                                            contentDescription = "Поделиться",
                                            tint = AppColors.White
                                        )
                                    }
                                    Spacer(modifier = Modifier.width(8.dp))
                                    IconButton(
                                        onClick = { /* TODO */ },
                                        modifier = Modifier.background(
                                            MaterialTheme.colorScheme.surface.copy(alpha = 0.8f),
                                            CircleShape
                                        )
                                    ) {
                                        Icon(
                                            Icons.Default.FavoriteBorder,
                                            contentDescription = "В избранное",
                                            tint = AppColors.White
                                        )
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
                                text = listing.title,
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
                                    text = listing.location,
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
                                    text = listing.rating.toString(),
                                    style = MaterialTheme.typography.titleMedium
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                TextButton(onClick = {
                                    navController.navigate("listing/$listingId/reviews")
                                }) {
                                    Text(
                                        "(${listing.reviewsCount} отзывов)",
                                        color = AppColors.TextSecondary
                                    )
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
                                        text = "Хозяин: ${listing.host.name}",
                                        style = MaterialTheme.typography.titleMedium
                                    )
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(
                                        text = "На Airbnb с ${
                                            listing.host.joinedDate?.let {
                                                java.text.SimpleDateFormat(
                                                    "yyyy",
                                                    java.util.Locale.getDefault()
                                                ).format(java.util.Date(it))
                                            } ?: "недавно"
                                        }",
                                        style = MaterialTheme.typography.bodyMedium,
                                        color = AppColors.TextSecondary
                                    )
                                }
                            }

                            Divider(modifier = Modifier.padding(vertical = 16.dp))

                            // Features
                            FeatureRow(Icons.Default.Bed, "${listing.bedrooms} спальни")
                            Spacer(modifier = Modifier.height(12.dp))
                            FeatureRow(Icons.Default.Bathtub, "${listing.bathrooms} ванная")
                            Spacer(modifier = Modifier.height(12.dp))
                            FeatureRow(Icons.Default.People, "До ${listing.maxGuests} гостей")
                            Spacer(modifier = Modifier.height(12.dp))
                            if (listing.amenities.contains("Wi-Fi")) {
                                FeatureRow(Icons.Default.Wifi, "Wi-Fi")
                            }

                            Divider(modifier = Modifier.padding(vertical = 16.dp))

                            // Description
                            Text(
                                text = "Описание",
                                style = MaterialTheme.typography.titleLarge,
                                color = AppColors.TextPrimary
                            )
                            Spacer(modifier = Modifier.height(12.dp))
                            Text(
                                text = listing.description,
                                style = MaterialTheme.typography.bodyLarge,
                                color = AppColors.TextSecondary
                            )

                            Spacer(modifier = Modifier.height(32.dp))

                            // Book button
                            CustomButton(
                                text = "Забронировать за ${listing.price.toInt()} ₽/ночь",
                                onClick = { navController.navigate("booking?listingId=$listingId") },
                                modifier = Modifier.fillMaxWidth()
                            )

                            Spacer(modifier = Modifier.height(16.dp))
                        }
                    } ?: run {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(paddingValues),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("Жилье не найдено", color = AppColors.TextSecondary)
                        }
                    }
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

