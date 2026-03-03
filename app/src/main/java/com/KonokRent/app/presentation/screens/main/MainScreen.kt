package com.KonokRent.app.presentation.screens.main

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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction.Companion.Search
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.R
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.KonokRent.app.domain.models.Hotel
import com.KonokRent.app.presentation.components.AirbnbBottomBar
import com.KonokRent.app.presentation.components.card.BigHotelCard
import com.airbnbclone.app.presentation.screens.listing.ListingScreen
import com.airbnbclone.app.presentation.screens.map.MapScreen
import com.airbnbclone.app.presentation.screens.messages.MessagesScreen
import com.airbnbclone.app.presentation.screens.profile.ProfileScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavHostController) {
    var selectedIndex by remember { mutableIntStateOf(2) } // По умолчанию вкладка «Поиск»

    Scaffold(
        bottomBar = {
            AirbnbBottomBar(
                selectedIndex = selectedIndex,
                onItemSelected = { index -> selectedIndex = index }
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            when (selectedIndex) {
                0 -> ListingScreen(navController = navController, listingId = "1")
                1 -> MessagesScreen(navController = navController)
                2 -> SearchTabScreen()
                3 -> MapScreen(navController = navController)
                4 -> ProfileScreen(navController = navController)

            }
        }
    }
}


// ---------- Вкладка «Поиск» ----------

@Composable
fun SearchTabScreen() {
    val bishkekHotels = remember {
        listOf(
            Hotel("1", "Бишкек, Inter Hotel", 20, 4.9, 2620, 200, 2, 2, 1),
            Hotel("2", "Бишкек, Asia Mountains", 12, 4.8, 2300, 350, 2, 1, 1)
        )
    }
    val narynHotels = remember {
        listOf(
            Hotel("3", "Нарын, Mountain View", 8, 4.7, 2100, 500, 2, 1, 1),
            Hotel("4", "Нарын, Guest House", 15, 4.6, 1800, 600, 1, 1, 1)
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        SearchBar()

        Spacer(modifier = Modifier.height(24.dp))

        CategoryRow()

        Spacer(modifier = Modifier.height(24.dp))

        SectionHeader(
            title = "Бишкек: популярное жильё",
            onMoreClick = { }
        )
        Spacer(modifier = Modifier.height(8.dp))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(bishkekHotels) { hotel ->
                Box(
                    modifier = Modifier.width(260.dp)
                ) {
                    BigHotelCard(
                        hotel = hotel,
                        onFavoriteClick = { }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        SectionHeader(
            title = "Нарын: доступные номера",
            onMoreClick = { }
        )
        Spacer(modifier = Modifier.height(8.dp))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(narynHotels) { hotel ->
                Box(
                    modifier = Modifier.width(260.dp)
                ) {
                    BigHotelCard(
                        hotel = hotel,
                        onFavoriteClick = { }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(32.dp))
    }
}

@Composable
private fun SearchBar() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        shape = RoundedCornerShape(24.dp),
        color = Color(0xFFF3F3F3)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                Icons.Default.Search,
                contentDescription = null,
                tint = Color(0xFFB0B0B0)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Начать поиск",
                style = MaterialTheme.typography.bodyMedium,
                color = Color(0xFFB0B0B0)
            )
        }
    }
}

@Composable
private fun CategoryRow() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        CategoryItem("Отели")
        CategoryItem("Частные хозяева")
        CategoryItem("Курортные зоны")
    }
}

@Composable
private fun CategoryItem(title: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
                .background(Color(0xFFF3F3F3)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = title.first().toString(),
                style = MaterialTheme.typography.titleMedium
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = title,
            style = MaterialTheme.typography.bodySmall,
            color = Color(0xFF444444),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
private fun SectionHeader(
    title: String,
    onMoreClick: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.SemiBold)
        )
        TextButton(onClick = onMoreClick) {
            Text(
                text = "›",
                fontSize = 20.sp,
                color = Color.Black
            )
        }
    }
}


// ---------- Превью ----------

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainScreenPreview() {
    MaterialTheme {
        MainScreen(
            navController = rememberNavController()
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SearchTabScreenPreview() {
    MaterialTheme {
        SearchTabScreen()
    }
}

