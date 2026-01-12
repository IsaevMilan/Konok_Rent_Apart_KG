package com.airbnbclone.app.domain.entities

data class Message(
    val id: String,
    val conversationId: String,
    val senderId: String,
    val text: String? = null,
    val type: MessageType,
    val audioUrl: String? = null,
    val imageUrl: String? = null,
    val createdAt: Long,
    var isRead: Boolean
)

enum class MessageType {
    TEXT,
    AUDIO,
    IMAGE
}

data class Conversation(
    val id: String,
    val otherUser: User,
    var lastMessage: Message? = null,
    var unreadCount: Int,
    var updatedAt: Long,
    val isOnline: Boolean = false
)

