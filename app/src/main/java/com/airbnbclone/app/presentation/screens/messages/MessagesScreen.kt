package com.airbnbclone.app.presentation.screens.messages

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.airbnbclone.app.presentation.theme.AppColors

data class ConversationItem(
    val id: String,
    val name: String,
    val avatar: String? = null,
    val lastMessage: String,
    val time: String,
    val unreadCount: Int,
    val isOnline: Boolean
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MessagesScreen(navController: NavController) {
    val conversations = remember {
        listOf(
            ConversationItem(
                id = "1",
                name = "Анна Иванова",
                lastMessage = "Спасибо за бронирование!",
                time = "10:30",
                unreadCount = 2,
                isOnline = true
            ),
            ConversationItem(
                id = "2",
                name = "Дмитрий Петров",
                lastMessage = "Когда можно заехать?",
                time = "Вчера",
                unreadCount = 0,
                isOnline = false
            ),
            ConversationItem(
                id = "3",
                name = "Мария Сидорова",
                lastMessage = "Отлично, жду вас!",
                time = "15:45",
                unreadCount = 1,
                isOnline = true
            )
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Сообщения") },
                navigationIcon = {
                    IconButton(onClick = { navController.pop() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Назад")
                    }
                },
                actions = {
                    IconButton(onClick = { navController.navigate("messages/edit") }) {
                        Icon(Icons.Default.Edit, contentDescription = "Редактировать")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            )
        }
    ) { paddingValues ->
        if (conversations.isEmpty) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        Icons.Default.Message,
                        contentDescription = null,
                        modifier = Modifier.size(80.dp),
                        tint = AppColors.Grey
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Нет сообщений",
                        style = MaterialTheme.typography.titleMedium,
                        color = AppColors.TextSecondary
                    )
                }
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                items(conversations) { conversation ->
                    ConversationItem(
                        conversation = conversation,
                        onClick = {
                            navController.navigate("messages/chat/${conversation.id}")
                        }
                    )
                    Divider()
                }
            }
        }
    }
}

@Composable
fun ConversationItem(
    conversation: ConversationItem,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Avatar
        Box {
            Surface(
                modifier = Modifier.size(56.dp),
                shape = CircleShape,
                color = AppColors.LightGrey
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Text(
                        text = conversation.name.first().uppercase(),
                        style = MaterialTheme.typography.titleLarge,
                        color = AppColors.TextPrimary
                    )
                }
            }
            if (conversation.isOnline) {
                Surface(
                    modifier = Modifier
                        .size(14.dp)
                        .align(Alignment.BottomEnd)
                        .offset(x = (-2).dp, y = (-2).dp),
                    shape = CircleShape,
                    color = Color(0xFF4CAF50),
                    border = androidx.compose.foundation.BorderStroke(
                        2.dp,
                        MaterialTheme.colorScheme.background
                    )
                ) {}
            }
        }
        
        Spacer(modifier = Modifier.width(12.dp))
        
        // Content
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = conversation.name,
                    style = MaterialTheme.typography.titleMedium,
                    color = AppColors.TextPrimary,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = conversation.time,
                    style = MaterialTheme.typography.bodySmall,
                    color = AppColors.TextSecondary
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = conversation.lastMessage,
                    style = MaterialTheme.typography.bodyMedium,
                    color = AppColors.TextSecondary,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f)
                )
                if (conversation.unreadCount > 0) {
                    Surface(
                        shape = MaterialTheme.shapes.small,
                        color = AppColors.Primary
                    ) {
                        Text(
                            text = conversation.unreadCount.toString(),
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp),
                            style = MaterialTheme.typography.labelSmall,
                            color = AppColors.White
                        )
                    }
                }
            }
        }
    }
}

