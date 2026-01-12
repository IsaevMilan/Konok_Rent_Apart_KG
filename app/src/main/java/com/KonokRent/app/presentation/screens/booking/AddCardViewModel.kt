package com.airbnbclone.app.presentation.screens.booking

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class AddCardUiState(
    val cardNumber: String = "",
    val cardholder: String = "",
    val expiry: String = "",
    val cvv: String = "",
    val cvvVisible: Boolean = false,
    val isLoading: Boolean = false,
    val error: String? = null,
    val isSuccess: Boolean = false
)

@HiltViewModel
class AddCardViewModel @Inject constructor() : ViewModel() {
    
    private val _uiState = MutableStateFlow(AddCardUiState())
    val uiState: StateFlow<AddCardUiState> = _uiState.asStateFlow()
    
    fun updateCardNumber(value: String) {
        val cleaned = value.replace(" ", "")
        if (cleaned.length <= 16 && cleaned.all { it.isDigit() }) {
            val formatted = cleaned.chunked(4).joinToString(" ")
            _uiState.value = _uiState.value.copy(cardNumber = formatted, error = null)
        }
    }
    
    fun updateCardholder(value: String) {
        _uiState.value = _uiState.value.copy(cardholder = value.uppercase(), error = null)
    }
    
    fun updateExpiry(value: String) {
        val cleaned = value.replace("/", "")
        if (cleaned.length <= 4 && cleaned.all { it.isDigit() }) {
            val formatted = if (cleaned.length >= 2) {
                "${cleaned.take(2)}/${cleaned.drop(2)}"
            } else {
                cleaned
            }
            _uiState.value = _uiState.value.copy(expiry = formatted, error = null)
        }
    }
    
    fun updateCvv(value: String) {
        if (value.length <= 3 && value.all { it.isDigit() }) {
            _uiState.value = _uiState.value.copy(cvv = value, error = null)
        }
    }
    
    fun toggleCvvVisibility() {
        _uiState.value = _uiState.value.copy(cvvVisible = !_uiState.value.cvvVisible)
    }
    
    fun saveCard(onSuccess: () -> Unit) {
        val state = _uiState.value
        val cardNumberCleaned = state.cardNumber.replace(" ", "")
        
        if (cardNumberCleaned.length != 16) {
            _uiState.value = state.copy(error = "Номер карты должен содержать 16 цифр")
            return
        }
        
        if (state.cardholder.isBlank()) {
            _uiState.value = state.copy(error = "Введите имя держателя карты")
            return
        }
        
        if (state.expiry.length != 5) {
            _uiState.value = state.copy(error = "Введите срок действия (MM/YY)")
            return
        }
        
        if (state.cvv.length != 3) {
            _uiState.value = state.copy(error = "CVV должен содержать 3 цифры")
            return
        }
        
        viewModelScope.launch {
            _uiState.value = state.copy(isLoading = true, error = null)
            try {
                kotlinx.coroutines.delay(1000) // Имитация сохранения
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    isSuccess = true,
                    error = null
                )
                onSuccess()
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    error = e.message ?: "Ошибка сохранения карты"
                )
            }
        }
    }
    
    fun clearError() {
        _uiState.value = _uiState.value.copy(error = null)
    }
}
