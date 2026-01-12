package com.airbnbclone.app.presentation.screens.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.airbnbclone.app.domain.repository.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class VerifyCodeUiState(
    val code: String = "",
    val isLoading: Boolean = false,
    val error: String? = null,
    val isSuccess: Boolean = false,
    val canResend: Boolean = true,
    val resendCountdown: Int = 0
)

class VerifyCodeViewModel(
    private val authRepository: AuthRepository,
    private val phoneNumber: String?
) : ViewModel() {
    
    private val _uiState = MutableStateFlow(VerifyCodeUiState())
    val uiState: StateFlow<VerifyCodeUiState> = _uiState.asStateFlow()
    
    fun updateCode(value: String) {
        if (value.length <= 6) {
            _uiState.value = _uiState.value.copy(code = value, error = null)
        }
    }
    
    fun verifyCode(onSuccess: () -> Unit) {
        val currentState = _uiState.value
        if (currentState.code.length != 6) {
            _uiState.value = currentState.copy(error = "Введите 6-значный код")
            return
        }
        
        viewModelScope.launch {
            _uiState.value = currentState.copy(isLoading = true, error = null)
            try {
                phoneNumber?.let {
                    authRepository.verifyCode(it, currentState.code)
                }
                kotlinx.coroutines.delay(1000)
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    isSuccess = true,
                    error = null
                )
                onSuccess()
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    error = e.message ?: "Неверный код"
                )
            }
        }
    }
    
    fun resendCode() {
        viewModelScope.launch {
            try {
                phoneNumber?.let { authRepository.sendVerificationCode(it) }
                _uiState.value = _uiState.value.copy(
                    canResend = false,
                    resendCountdown = 60
                )
                startResendCountdown()
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(error = "Не удалось отправить код")
            }
        }
    }
    
    private fun startResendCountdown() {
        viewModelScope.launch {
            var countdown = 60
            while (countdown > 0) {
                kotlinx.coroutines.delay(1000)
                countdown--
                _uiState.value = _uiState.value.copy(resendCountdown = countdown)
            }
            _uiState.value = _uiState.value.copy(canResend = true, resendCountdown = 0)
        }
    }
    
    fun clearError() {
        _uiState.value = _uiState.value.copy(error = null)
    }
}
