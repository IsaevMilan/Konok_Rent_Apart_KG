package com.airbnbclone.app.data.repository.mock

import com.airbnbclone.app.domain.entities.Conversation
import com.airbnbclone.app.domain.entities.Message
import com.airbnbclone.app.domain.entities.MessageType
import com.airbnbclone.app.domain.entities.User
import com.airbnbclone.app.domain.repository.MessageRepository
import com.airbnbclone.app.domain.repository.MessageResult
import com.airbnbclone.app.domain.repository.MessageSearchResult
import kotlinx.coroutines.delay

class MockMessageRepository : MessageRepository {

    private val mockUsers = listOf(
        User("user2", "Анна Иванова", "anna@example.com"),
        User("user3", "Дмитрий Петров", "dmitry@example.com"),
        User("user4", "Мария Сидорова", "maria@example.com")
    )

    private val mockConversations = mutableListOf(
        Conversation(
            id = "conv1",
            otherUser = mockUsers[0],
            lastMessage = Message(
                id = "msg1_1",
                conversationId = "conv1",
                senderId = "user2",
                text = "Спасибо за бронирование!",
                type = MessageType.TEXT,
                createdAt = System.currentTimeMillis() - 3600000,
                isRead = false
            ),
            unreadCount = 2,
            updatedAt = System.currentTimeMillis() - 3600000,
            isOnline = true
        ),
        Conversation(
            id = "conv2",
            otherUser = mockUsers[1],
            lastMessage = Message(
                id = "msg2_1",
                conversationId = "conv2",
                senderId = "user3",
                text = "Когда можно заехать?",
                type = MessageType.TEXT,
                createdAt = System.currentTimeMillis() - 86400000,
                isRead = true
            ),
            unreadCount = 0,
            updatedAt = System.currentTimeMillis() - 86400000,
            isOnline = false
        )
    )

    private val mockMessages = mutableMapOf<String, MutableList<Message>>(
        "conv1" to mutableListOf(
            Message(
                id = "msg1_1",
                conversationId = "conv1",
                senderId = "user2",
                text = "Спасибо за бронирование!",
                type = MessageType.TEXT,
                createdAt = System.currentTimeMillis() - 3600000,
                isRead = false
            )
        ),
        "conv2" to mutableListOf(
            Message(
                id = "msg2_1",
                conversationId = "conv2",
                senderId = "user3",
                text = "Когда можно заехать?",
                type = MessageType.TEXT,
                createdAt = System.currentTimeMillis() - 86400000,
                isRead = true
            )
        )
    )

    override suspend fun getConversations(userId: String): List<Conversation> {
        delay(300)
        return mockConversations
    }

    override suspend fun getMessages(
        conversationId: String,
        page: Int,
        limit: Int
    ): MessageResult {
        delay(300)
        val messages = mockMessages[conversationId] ?: emptyList()
        return MessageResult(
            messages = messages.take(limit),
            total = messages.size
        )
    }

    override suspend fun sendMessage(
        conversationId: String,
        text: String?,
        type: String,
        audioUrl: String?,
        imageUrl: String?
    ): Message {
        delay(200)

        val message = Message(
            id = "msg_${System.currentTimeMillis()}",
            conversationId = conversationId,
            senderId = "user1", // Можно заменить на динамический источник
            text = text,
            type = parseMessageType(type),
            audioUrl = audioUrl,
            imageUrl = imageUrl,
            createdAt = System.currentTimeMillis(),
            isRead = false
        )

        // Добавляем в хранилище
        mockMessages.getOrPut(conversationId) { mutableListOf() }.add(message)

        // Обновляем беседу
        updateConversationAfterMessage(conversationId, message)


        return message
    }

    override suspend fun createConversation(
        otherUserId: String,
        listingId: String?
    ): Conversation {
        delay(300)
        val otherUser = mockUsers.firstOrNull { it.id == otherUserId } ?: mockUsers[0]
        val newId = "conv_${System.currentTimeMillis()}"


        val conversation = Conversation(
            id = newId,
            otherUser = otherUser,
            lastMessage = null,
            unreadCount = 0,
            updatedAt = System.currentTimeMillis(),
            isOnline = false
        )

        mockConversations.add(conversation)
        mockMessages[newId] = mutableListOf()

        return conversation
    }

    override suspend fun searchMessages(
        userId: String,
        query: String
    ): List<MessageSearchResult> {
        delay(300)
        return mockMessages.values.flatten()
            .filter { it.text?.contains(query, ignoreCase = true) == true }
            .map { message ->
                MessageSearchResult(
                    conversationId = message.conversationId,
                    messageId = message.id,
                    text = message.text ?: "",
                    senderName = message.senderId,
                    createdAt = message.createdAt
                )
            }
    }

    override suspend fun deleteMessages(
        conversationId: String,
        messageIds: List<String>
    ) {
        delay(200)
        mockMessages[conversationId]?.removeAll { it.id in messageIds }
    }

    override suspend fun markAsRead(conversationId: String) {
        delay(200)
        val conversation = mockConversations.firstOrNull { it.id == conversationId } ?: return
        conversation.unreadCount = 0
        conversation.lastMessage?.isRead = true
    }

    override suspend fun uploadAudio(audioData: ByteArray): String {
        delay(500)
        return "https://example.com/audio/${System.currentTimeMillis()}.mp3"
    }

    override suspend fun uploadImage(imageData: ByteArray): String {
        delay(500)
        return "https://example.com/image/${System.currentTimeMillis()}.jpg"
    }

    // Вспомогательные методы
    private fun parseMessageType(type: String): MessageType = when (type) {
        "AUDIO" -> MessageType.AUDIO
        "IMAGE" -> MessageType.IMAGE
        else -> MessageType.TEXT
    }

    private fun updateConversationAfterMessage(
        conversationId: String,
        message: Message
    ) {
        val conversation = mockConversations.firstOrNull { it.id == conversationId } ?: return
        conversation.lastMessage = message
        conversation.unreadCount++
        conversation.updatedAt = message.createdAt
    }
}


