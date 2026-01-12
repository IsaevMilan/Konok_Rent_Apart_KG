package com.airbnbclone.app.presentation.screens.listing

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.airbnbclone.app.domain.entities.Listing
import com.airbnbclone.app.domain.repository.ListingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class ListingUiState(
    val listing: Listing? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)

@HiltViewModel
class ListingViewModel @Inject constructor(
    private val listingRepository: ListingRepository
) : ViewModel() {
    
    private val _uiState = MutableStateFlow(ListingUiState())
    val uiState: StateFlow<ListingUiState> = _uiState.asStateFlow()
    
    private var listingId: String = ""
    
    fun init(listingId: String) {
        this.listingId = listingId
        loadListing()
    }
    
    private fun loadListing() {
        if (listingId.isEmpty()) return
        
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            try {
                val listing = listingRepository.getListingById(listingId)
                _uiState.value = _uiState.value.copy(
                    listing = listing,
                    isLoading = false,
                    error = null
                )
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    error = e.message ?: "Ошибка загрузки жилья"
                )
            }
        }
    }
    
    fun refresh() {
        loadListing()
    }
}
