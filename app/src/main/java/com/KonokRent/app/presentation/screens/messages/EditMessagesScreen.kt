package com.airbnbclone.app.presentation.screens.messages

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.airbnbclone.app.presentation.theme.AppColors
import java.text.SimpleDateFormat
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditMessagesScreen(
    navController: NavController,
    viewModel: EditMessagesViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        if (uiState.selectedIds.isEmpty()) "Выбрать сообщения"
                        else "Выбрано: ${uiState.selectedIds.size}"
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.Close, contentDescription = "Закрыть")
                    }
                },
                actions = {
                    if (uiState.selectedIds.isNotEmpty()) {
                        IconButton(
                            onClick = { viewModel.deleteSelected() },
                            enabled = !uiState.isLoading
                        ) {
                            if (uiState.isLoading) {
                                CircularProgressIndicator(
                                    modifier = Modifier.size(24.dp),
                                    strokeWidth = 2.dp
                                )
                            } else {
                                Icon(Icons.Default.Delete, contentDescription = "Удалить", tint = Color.Red)
                            }
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            )
        }
    ) { paddingValues ->
        if (uiState.isLoading && uiState.conversations.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                items(uiState.conversations) { conversation ->
                    val isSelected = uiState.selectedIds.contains(conversation.id)
                    
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                viewModel.toggleSelection(conversation.id)
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
                                    text = conversation.otherUser.name.first().uppercase(),
                                    style = MaterialTheme.typography.titleLarge
                                )
                            }
                        }
                        Spacer(modifier = Modifier.width(12.dp))
                        
                        // Content
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = conversation.otherUser.name,
                                style = MaterialTheme.typography.titleMedium
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = conversation.lastMessage?.text ?: "",
                                style = MaterialTheme.typography.bodyMedium,
                                color = AppColors.TextSecondary,
                                maxLines = 1
                            )
                        }
                        
                        // Time
                        val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
                        val dateFormat = SimpleDateFormat("dd.MM", Locale.getDefault())
                        val now = System.currentTimeMillis()
                        val timeText = when {
                            now - conversation.updatedAt < 86400000 -> 
                                timeFormat.format(Date(conversation.updatedAt))
                            else -> dateFormat.format(Date(conversation.updatedAt))
                        }
                        
                        Text(
                            text = timeText,
                            style = MaterialTheme.typography.bodySmall,
                            color = AppColors.TextSecondary
                        )
                    }
                    Divider()
                }
            }
        }
        
        // Error message
        uiState.error?.let { error ->
            LaunchedEffect(error) {
                kotlinx.coroutines.delay(3000)
            }
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = RoundedCornerShape(8.dp),
                color = MaterialTheme.colorScheme.errorContainer
            ) {
                Text(
                    text = error,
                    modifier = Modifier.padding(16.dp),
                    color = MaterialTheme.colorScheme.onErrorContainer,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

