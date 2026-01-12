package com.airbnbclone.app.presentation.screens.search

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

data class FilterUiState(
    val priceRange: ClosedFloatingPointRange<Float> = 1000f..10000f,
    val guests: Int = 1,
    val selectedAmenities: Set<String> = emptySet(),
    val selectedPropertyTypes: Set<String> = emptySet()
)

@HiltViewModel
class FilterViewModel @Inject constructor() : ViewModel() {
    
    private val _uiState = MutableStateFlow(FilterUiState())
    val uiState: StateFlow<FilterUiState> = _uiState.asStateFlow()
    
    fun updatePriceRange(range: ClosedFloatingPointRange<Float>) {
        _uiState.value = _uiState.value.copy(priceRange = range)
    }
    
    fun updateGuests(count: Int) {
        if (count >= 1) {
            _uiState.value = _uiState.value.copy(guests = count)
        }
    }
    
    fun incrementGuests() {
        _uiState.value = _uiState.value.copy(guests = _uiState.value.guests + 1)
    }
    
    fun decrementGuests() {
        if (_uiState.value.guests > 1) {
            _uiState.value = _uiState.value.copy(guests = _uiState.value.guests - 1)
        }
    }
    
    fun toggleAmenity(amenity: String) {
        val current = _uiState.value.selectedAmenities
        _uiState.value = _uiState.value.copy(
            selectedAmenities = if (current.contains(amenity)) {
                current - amenity
            } else {
                current + amenity
            }
        )
    }
    
    fun togglePropertyType(type: String) {
        val current = _uiState.value.selectedPropertyTypes
        _uiState.value = _uiState.value.copy(
            selectedPropertyTypes = if (current.contains(type)) {
                current - type
            } else {
                current + type
            }
        )
    }
    
    fun resetFilters() {
        _uiState.value = FilterUiState()
    }
}
