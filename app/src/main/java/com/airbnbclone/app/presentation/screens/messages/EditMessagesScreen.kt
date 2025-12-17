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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.airbnbclone.app.presentation.theme.AppColors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditMessagesScreen(navController: NavController) {
    val conversations = remember {
        listOf(
            ConversationItem("1", "Анна Иванова", lastMessage = "Спасибо за бронирование!", time = "10:30", unreadCount = 2, isOnline = true),
            ConversationItem("2", "Дмитрий Петров", lastMessage = "Когда можно заехать?", time = "Вчера", unreadCount = 0, isOnline = false),
            ConversationItem("3", "Мария Сидорова", lastMessage = "Отлично, жду вас!", time = "15:45", unreadCount = 1, isOnline = true)
        )
    }
    var selectedIds by remember { mutableStateOf(setOf<String>()) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        if (selectedIds.isEmpty()) "Выбрать сообщения"
                        else "Выбрано: ${selectedIds.size}"
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.pop() }) {
                        Icon(Icons.Default.Close, contentDescription = "Закрыть")
                    }
                },
                actions = {
                    if (selectedIds.isNotEmpty()) {
                        IconButton(onClick = { /* TODO: Delete */ }) {
                            Icon(Icons.Default.Delete, contentDescription = "Удалить", tint = Color.Red)
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            items(conversations) { conversation ->
                val isSelected = selectedIds.contains(conversation.id)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            selectedIds = if (isSelected) {
                                selectedIds - conversation.id
                            } else {
                                selectedIds + conversation.id
                            }
                        }
                        .padding(horizontal = 16.dp, vertical = 12.dp)
                        .then(
                            if (isSelected) Modifier.background(AppColors.LightGrey.copy(alpha = 0.3f))
                            else Modifier
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Checkbox
                    Surface(
                        modifier = Modifier.size(24.dp),
                        shape = CircleShape,
                        color = if (isSelected) AppColors.Primary else Color.Transparent,
                        border = androidx.compose.foundation.BorderStroke(
                            2.dp,
                            if (isSelected) AppColors.Primary else AppColors.Grey
                        )
                    ) {
                        if (isSelected) {
                            Box(contentAlignment = Alignment.Center) {
                                Icon(
                                    Icons.Default.Check,
                                    contentDescription = null,
                                    modifier = Modifier.size(16.dp),
                                    tint = AppColors.White
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.width(12.dp))
                    
                    // Avatar
                    Surface(
                        modifier = Modifier.size(56.dp),
                        shape = CircleShape,
                        color = AppColors.LightGrey
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Text(
                                text = conversation.name.first().uppercase(),
                                style = MaterialTheme.typography.titleLarge
                            )
                        }
                    }
                    Spacer(modifier = Modifier.width(12.dp))
                    
                    // Content
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = conversation.name,
                            style = MaterialTheme.typography.titleMedium
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = conversation.lastMessage,
                            style = MaterialTheme.typography.bodyMedium,
                            color = AppColors.TextSecondary
                        )
                    }
                    Text(
                        text = conversation.time,
                        style = MaterialTheme.typography.bodySmall,
                        color = AppColors.TextSecondary
                    )
                }
                Divider()
            }
        }
    }
}

