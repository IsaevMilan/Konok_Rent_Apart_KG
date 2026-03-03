package com.airbnbclone.app.presentation.screens.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.KonokRent.app.domain.models.Hotel
import com.KonokRent.app.domain.models.SearchCategory
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class SearchUiState(
    val isLoading: Boolean = false,
    val city1: String = "",
    val listOfBest1: MutableList<Hotel> = mutableListOf<Hotel>(),
    val city2: String = "",
    val listOfBest2: MutableList<Hotel> = mutableListOf<Hotel>(),
    val listOfSearch: MutableList<Hotel> = mutableListOf<Hotel>(),
)


@HiltViewModel
class SearchViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(SearchUiState())
    val uiState: StateFlow<SearchUiState> = _uiState.asStateFlow()

    fun searchHotel(input: String, category: SearchCategory) {
        viewModelScope.launch {

        }
    }
}
