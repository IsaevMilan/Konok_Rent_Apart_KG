package com.airbnbclone.app.presentation.screens.profile

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.airbnbclone.app.presentation.theme.AppColors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    navController: NavController,
    viewModel: ProfileViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Профиль") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            )
        }
    ) { paddingValues ->
        if (uiState.isLoading) {
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
                    .padding(paddingValues),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    Spacer(modifier = Modifier.height(32.dp))
                    
                    Box {
                        Surface(
                            modifier = Modifier.size(120.dp),
                            shape = androidx.compose.foundation.shape.CircleShape,
                            color = AppColors.LightGrey
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Icon(
                                    Icons.Default.Person,
                                    contentDescription = null,
                                    modifier = Modifier.size(60.dp),
                                    tint = AppColors.Grey
                                )
                            }
                        }
                        FloatingActionButton(
                            onClick = { /* TODO */ },
                            modifier = Modifier
                                .align(Alignment.BottomEnd)
                                .size(40.dp)
                                .offset(x = (-8).dp, y = (-8).dp),
                            containerColor = AppColors.Primary,
                        ) {
                            Icon(Icons.Default.CameraAlt, contentDescription = null)
                        }
                    }
                    
                    Spacer(modifier = Modifier.height(24.dp))
                    
                    Text(
                        text = uiState.user?.name ?: "Пользователь",
                        style = MaterialTheme.typography.headlineMedium,
                        color = AppColors.TextPrimary
                    )
                    
                    Spacer(modifier = Modifier.height(8.dp))
                    
                    Text(
                        text = uiState.user?.email ?: "",
                        style = MaterialTheme.typography.bodyLarge,
                        color = AppColors.TextSecondary
                    )
                    
                    Spacer(modifier = Modifier.height(40.dp))
                }
                
                item {
                    ProfileMenuItem(
                        icon = Icons.Default.Edit,
                        title = "Редактировать профиль",
                        onClick = { navController.navigate("profile/edit") }
                    )
                    Divider(modifier = Modifier.padding(start = 64.dp))
                    ProfileMenuItem(
                        icon = Icons.Default.Lock,
                        title = "Конфиденциальность",
                        onClick = { navController.navigate("profile/privacy") }
                    )
                    Divider(modifier = Modifier.padding(start = 64.dp))
                    ProfileMenuItem(
                        icon = Icons.Default.AccountCircle,
                        title = "Мой аккаунт",
                        onClick = { navController.navigate("profile/account") }
                    )
                    Divider(modifier = Modifier.padding(start = 64.dp))
                    ProfileMenuItem(
                        icon = Icons.Default.Settings,
                        title = "Настройки",
                        onClick = { navController.navigate("profile/settings") }
                    )
                    Divider(modifier = Modifier.padding(start = 64.dp))
                    ProfileMenuItem(
                        icon = Icons.Default.Security,
                        title = "Смена пароля",
                        onClick = { navController.navigate("profile/change-password") }
                    )
                    Divider(modifier = Modifier.padding(start = 64.dp))
                    ProfileMenuItem(
                        icon = Icons.Default.AdminPanelSettings,
                        title = "Разрешения",
                        onClick = { navController.navigate("profile/permissions") }
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                }
            }
        }
    }
}

@Composable
fun ProfileMenuItem(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    title: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 16.dp)
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = AppColors.TextPrimary,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = title,
            style = MaterialTheme.typography.bodyLarge,
            color = AppColors.TextPrimary,
            modifier = Modifier.weight(1f)
        )
        Icon(
            Icons.Default.ChevronRight,
            contentDescription = null,
            tint = AppColors.Grey
        )
    }
}
