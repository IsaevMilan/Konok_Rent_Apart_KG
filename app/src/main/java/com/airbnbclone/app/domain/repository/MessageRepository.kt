package com.airbnbclone.app.domain.repository

import com.airbnbclone.app.domain.entities.Conversation
import com.airbnbclone.app.domain.entities.Message

interface MessageRepository {
    suspend fun getConversations(userId: String): List<Conversation>
    suspend fun getMessages(conversationId: String, page: Int = 1, limit: Int = 50): MessageResult
    suspend fun sendMessage(
        conversationId: String,
        text: String? = null,
        type: String,
        audioUrl: String? = null,
        imageUrl: String? = null
    ): Message
    
    suspend fun createConversation(otherUserId: String, listingId: String? = null): Conversation
    suspend fun searchMessages(userId: String, query: String): List<MessageSearchResult>
    suspend fun deleteMessages(conversationId: String, messageIds: List<String>)
    suspend fun markAsRead(conversationId: String)
    suspend fun uploadAudio(audioData: ByteArray): String
    suspend fun uploadImage(imageData: ByteArray): String
}

data class MessageResult(
    val messages: List<Message>,
    val total: Int
)

data class MessageSearchResult(
    val conversationId: String,
    val messageId: String,
    val text: String,
    val senderName: String,
    val createdAt: Long
)

