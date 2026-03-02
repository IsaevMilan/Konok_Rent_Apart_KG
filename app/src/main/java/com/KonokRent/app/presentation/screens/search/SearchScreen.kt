package com.KonokRent.app.presentation.screens.search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.KonokRent.app.domain.models.Hotel
import com.KonokRent.app.presentation.components.card.BigHotelCard
import com.KonokRent.app.presentation.components.card.CompactHotelCard
import com.KonokRent.app.presentation.components.search.SearchSection
import com.airbnbclone.app.presentation.screens.search.SearchViewModel

@Composable
fun SearchScreen(
    navController: NavController,
    viewModel: SearchViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val text by remember { mutableStateOf("") }
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        SearchSection(baseText = text) { input, selectedCategory ->
            viewModel.searchHotel(
                input,
                selectedCategory
            )
        }
        if (text.isEmpty()) {
            HotelsBlock(uiState.city1, uiState.listOfBest1) {}
            Spacer(Modifier.padding(8.dp))
            HotelsBlock(uiState.city2, uiState.listOfBest2) {}
        } else {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(
                        rememberScrollState(),
                    ),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                for (hotel in uiState.listOfSearch) {
                    BigHotelCard(hotel) { }
                }
            }
        }
    }
}

@Composable
private fun HotelsBlock(city: String, hotelList: List<Hotel>, onFavoriteClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {},
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text("$city: популярное жилье")
        Text(">")
    }
    Row(modifier = Modifier.horizontalScroll( rememberScrollState(1))) {
        for (hotel in hotelList) {
            CompactHotelCard(hotel) {}
        }
    }
}