package com.airbnbclone.app.presentation.screens.messages

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.airbnbclone.app.domain.entities.Conversation
import com.airbnbclone.app.domain.repository.MessageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class EditMessagesUiState(
    val conversations: List<Conversation> = emptyList(),
    val selectedIds: Set<String> = emptySet(),
    val isLoading: Boolean = false,
    val error: String? = null
)

@HiltViewModel
class EditMessagesViewModel @Inject constructor(
    private val messageRepository: MessageRepository
) : ViewModel() {
    
    private val _uiState = MutableStateFlow(EditMessagesUiState())
    val uiState: StateFlow<EditMessagesUiState> = _uiState.asStateFlow()
    
    private val currentUserId: String = "user1"
    
    init {
        loadConversations()
    }
    
    private fun loadConversations() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            try {
                val conversations = messageRepository.getConversations(currentUserId)
                _uiState.value = _uiState.value.copy(
                    conversations = conversations,
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
    
    fun toggleSelection(conversationId: String) {
        val current = _uiState.value.selectedIds
        _uiState.value = _uiState.value.copy(
            selectedIds = if (current.contains(conversationId)) {
                current - conversationId
            } else {
                current + conversationId
            }
        )
    }
    
    fun deleteSelected() {
        val selectedIds = _uiState.value.selectedIds
        if (selectedIds.isEmpty()) return
        
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            try {
                selectedIds.forEach { conversationId ->
                    val result = messageRepository.getMessages(conversationId)
                    val messageIds = result.messages.map { it.id }
                    messageRepository.deleteMessages(conversationId, messageIds)
                }
                loadConversations()
                _uiState.value = _uiState.value.copy(
                    selectedIds = emptySet(),
                    isLoading = false,
                    error = null
                )
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    error = e.message ?: "Ошибка удаления сообщений"
                )
            }
        }
    }
    
    fun clearSelection() {
        _uiState.value = _uiState.value.copy(selectedIds = emptySet())
    }
}
