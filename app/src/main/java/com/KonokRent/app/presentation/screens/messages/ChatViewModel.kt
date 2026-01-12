package com.airbnbclone.app.presentation.screens.messages

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.airbnbclone.app.domain.entities.Message
import com.airbnbclone.app.domain.repository.MessageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class ChatUiState(
    val messages: List<Message> = emptyList(),
    val messageText: String = "",
    val isLoading: Boolean = false,
    val isSending: Boolean = false,
    val error: String? = null
)

@HiltViewModel
class ChatViewModel @Inject constructor(
    private val messageRepository: MessageRepository
) : ViewModel() {
    
    private val _uiState = MutableStateFlow(ChatUiState())
    val uiState: StateFlow<ChatUiState> = _uiState.asStateFlow()
    
    private var conversationId: String = ""
    private val currentUserId: String = "user1"
    
    fun init(conversationId: String) {
        this.conversationId = conversationId
        loadMessages()
    }
    
    private fun loadMessages() {
        if (conversationId.isEmpty()) return
        
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            try {
                val result = messageRepository.getMessages(conversationId)
                _uiState.value = _uiState.value.copy(
                    messages = result.messages,
                    isLoading = false,
                    error = null
                )
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    error = e.message ?: "Ошибка загрузки сообщений"
                )
            }
        }
    }
    
    fun updateMessageText(text: String) {
        _uiState.value = _uiState.value.copy(messageText = text)
    }
    
    fun sendMessage() {
        val text = _uiState.value.messageText.trim()
        if (text.isEmpty() || conversationId.isEmpty()) return
        
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isSending = true)
            try {
                val message = messageRepository.sendMessage(
                    conversationId = conversationId,
                    text = text,
                    type = "TEXT"
                )
                _uiState.value = _uiState.value.copy(
                    messages = _uiState.value.messages + message,
                    messageText = "",
                    isSending = false,
                    error = null
                )
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    isSending = false,
                    error = e.message ?: "Ошибка отправки сообщения"
                )
            }
        }
    }
    
    fun refresh() {
        loadMessages()
    }
}
