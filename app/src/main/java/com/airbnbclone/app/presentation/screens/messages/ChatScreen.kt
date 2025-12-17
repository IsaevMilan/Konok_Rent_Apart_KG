package com.airbnbclone.app.presentation.screens.messages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.airbnbclone.app.presentation.theme.AppColors
import java.text.SimpleDateFormat
import java.util.*

data class MessageItem(
    val id: String,
    val text: String,
    val isMe: Boolean,
    val time: String,
    val type: String = "text"
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatScreen(
    navController: NavController,
    chatId: String,
    userName: String = "Пользователь"
) {
    var messageText by remember { mutableStateOf("") }
    var isRecording by remember { mutableStateOf(false) }
    val messages = remember {
        mutableStateListOf(
            MessageItem("1", "Здравствуйте! Интересует ваше жилье.", false, "10:15"),
            MessageItem("2", "Здравствуйте! Да, оно доступно для бронирования.", true, "10:20"),
            MessageItem("3", "Отлично! Когда можно заехать?", false, "10:25"),
            MessageItem("4", "В любое время после 14:00", true, "10:30")
        )
    }
    val listState = rememberLazyListState()

    LaunchedEffect(messages.size) {
        if (messages.isNotEmpty()) {
            listState.animateScrollToItem(messages.size - 1)
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Surface(
                            modifier = Modifier.size(40.dp),
                            shape = CircleShape,
                            color = AppColors.LightGrey
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Text(
                                    text = userName.first().uppercase(),
                                    style = MaterialTheme.typography.titleMedium
                                )
                            }
                        }
                        Spacer(modifier = Modifier.width(12.dp))
                        Column {
                            Text(
                                text = userName,
                                style = MaterialTheme.typography.titleMedium
                            )
                            Text(
                                text = "В сети",
                                style = MaterialTheme.typography.bodySmall,
                                color = AppColors.TextSecondary
                            )
                        }
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { navController.pop() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Назад")
                    }
                },
                actions = {
                    IconButton(onClick = { /* TODO */ }) {
                        Icon(Icons.Default.Phone, contentDescription = "Звонок")
                    }
                    IconButton(onClick = { /* TODO */ }) {
                        Icon(Icons.Default.Videocam, contentDescription = "Видеозвонок")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // Messages list
            LazyColumn(
                state = listState,
                modifier = Modifier.weight(1f),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(messages) { message ->
                    MessageBubble(message = message)
                }
            }

            // Input area
            Surface(
                modifier = Modifier.fillMaxWidth(),
                shadowElevation = 4.dp
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { /* TODO */ }) {
                        Icon(Icons.Default.AttachFile, contentDescription = "Прикрепить")
                    }
                    
                    if (isRecording) {
                        OutlinedTextField(
                            value = "Запись...",
                            onValueChange = {},
                            modifier = Modifier.weight(1f),
                            enabled = false,
                            colors = OutlinedTextFieldDefaults.colors(
                                disabledBorderColor = Color.Red,
                                disabledContainerColor = Color.Red.copy(alpha = 0.1f)
                            ),
                            trailingIcon = {
                                Surface(
                                    modifier = Modifier.size(8.dp),
                                    shape = CircleShape,
                                    color = Color.Red
                                ) {}
                            }
                        )
                        IconButton(onClick = { isRecording = false }) {
                            Icon(Icons.Default.Send, contentDescription = "Отправить", tint = Color.Red)
                        }
                    } else {
                        OutlinedTextField(
                            value = messageText,
                            onValueChange = { messageText = it },
                            modifier = Modifier.weight(1f),
                            placeholder = { Text("Написать сообщение...") },
                            shape = RoundedCornerShape(24.dp),
                            maxLines = 5,
                            trailingIcon = {
                                Row {
                                    IconButton(onClick = { isRecording = true }) {
                                        Icon(Icons.Default.Mic, contentDescription = "Записать")
                                    }
                                    if (messageText.isNotBlank()) {
                                        IconButton(onClick = {
                                            messages.add(
                                                MessageItem(
                                                    id = System.currentTimeMillis().toString(),
                                                    text = messageText,
                                                    isMe = true,
                                                    time = SimpleDateFormat("HH:mm", Locale.getDefault()).format(Date())
                                                )
                                            )
                                            messageText = ""
                                        }) {
                                            Icon(Icons.Default.Send, contentDescription = "Отправить", tint = AppColors.Primary)
                                        }
                                    }
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun MessageBubble(message: MessageItem) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = if (message.isMe) Arrangement.End else Arrangement.Start
    ) {
        Column(
            modifier = Modifier.widthIn(max = 280.dp),
            horizontalAlignment = if (message.isMe) Alignment.End else Alignment.Start
        ) {
            Surface(
                shape = RoundedCornerShape(16.dp),
                color = if (message.isMe) AppColors.Primary else AppColors.LightGrey
            ) {
                Text(
                    text = message.text,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp),
                    style = MaterialTheme.typography.bodyMedium,
                    color = if (message.isMe) AppColors.White else AppColors.TextPrimary
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = message.time,
                style = MaterialTheme.typography.bodySmall,
                color = AppColors.TextSecondary
            )
        }
    }
}

