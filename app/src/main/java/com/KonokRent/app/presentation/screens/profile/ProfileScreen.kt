package com.airbnbclone.app.presentation.screens.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.KonokRent.app.presentation.theme.AirbnbCloneTheme
import com.airbnbclone.app.R
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
            Box(modifier = Modifier.fillMaxSize()) {

                Image(
                    painter = painterResource(id = R.drawable.ornament_prifile_backgraund),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )

                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Spacer(modifier = Modifier.height(108.dp))

                    // Аватар
                    Box(
                        modifier = Modifier
                            .padding(bottom = 8.dp)
                            .size(102.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Surface(
                            modifier = Modifier.size(102.dp),
                            shape = CircleShape,
                            color = AppColors.LightGrey
                        ) {
                        }

                        // кнопка редактирования
                        FloatingActionButton(
                            onClick = { /* TODO */ },
                            modifier = Modifier
                                .align(Alignment.BottomEnd)
                                .size(32.dp)
                                .offset(x = -2.dp, y = 2.dp),

                            ) {
                            Image(
                                painter = painterResource(id = R.drawable.icon_pencil),
                                contentDescription = null,
                            )
                        }
                    }

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(364.dp)
                            .padding(horizontal = 22.dp)
                            .offset(y = (-38).dp)
                    ) {
                        // Твой фон карточки
                        Image(
                            painter = painterResource(id = R.drawable.profile_background),
                            contentDescription = null,
                            modifier = Modifier.fillMaxWidth(),
                            contentScale = ContentScale.Crop
                        )

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .offset(y = -32.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Spacer(modifier = Modifier.height(98.dp))
                            Text(
                                text = "Пользователь",
                                style = MaterialTheme.typography.headlineMedium,
                                color = AppColors.TextPrimary
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            Text(
                                text = "Гость",
                                style = MaterialTheme.typography.bodyLarge,
                                color = AppColors.TextSecondary
                            )

                            Spacer(modifier = Modifier.height(40.dp))

                            ProfileMenuItem(
                                icon = painterResource(R.drawable.icon_user),
                                title = "Мой аккаунт",
                                onClick = {})
                            ProfileMenuItem(
                                icon = painterResource(R.drawable.icons_door),
                                title = "Настройки",
                                onClick = {})
                            ProfileMenuItem(
                                icon = painterResource(R.drawable.question_circle),
                                title = "Помощь",
                                onClick = {})
                            ProfileMenuItem(
                                icon = painterResource(R.drawable.shield_user),
                                title = "Конфиденциальность",
                                onClick = {})
                            ProfileMenuItem(
                                icon = painterResource(R.drawable.icons_door),
                                title = "Выйти",
                                onClick = {})
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ProfileMenuItem(
    icon: Painter,
    title: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 20.dp)
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = icon,
            contentDescription = null,
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreenContent() {

    Box(modifier = Modifier.fillMaxSize()) {

        Image(
            painter = painterResource(id = R.drawable.ornament_prifile_backgraund),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(108.dp))

            // Аватар
            Box(
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .size(102.dp),
                contentAlignment = Alignment.Center
            ) {
                Surface(
                    modifier = Modifier.size(102.dp),
                    shape = CircleShape,
                    color = AppColors.LightGrey
                ) {
                }

                // кнопка редактирования
                FloatingActionButton(
                    onClick = { /* TODO */ },
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .size(32.dp)
                        .offset(x = -2.dp, y = 2.dp),

                ) {
                    Image(
                        painter = painterResource(id = R.drawable.icon_pencil),
                        contentDescription = null,
                    )
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(364.dp)
                    .padding(horizontal = 22.dp)
                    .offset(y = (-38).dp)
            ) {
                // Твой фон карточки
                Image(
                    painter = painterResource(id = R.drawable.profile_background),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset( y=-32.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(98.dp))
                    Text(
                        text = "Пользователь",
                        style = MaterialTheme.typography.headlineMedium,
                        color = AppColors.TextPrimary
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Гость",
                        style = MaterialTheme.typography.bodyLarge,
                        color = AppColors.TextSecondary
                    )

                    Spacer(modifier = Modifier.height(40.dp))

                    ProfileMenuItem(icon = painterResource(R.drawable.icon_user), title = "Мой аккаунт", onClick = {})
                    ProfileMenuItem(icon = painterResource(R.drawable.icons_door), title = "Настройки", onClick = {})
                    ProfileMenuItem(icon = painterResource(R.drawable.question_circle), title = "Помощь", onClick = {})
                    ProfileMenuItem(icon = painterResource(R.drawable.shield_user), title = "Конфиденциальность", onClick = {})
                    ProfileMenuItem(icon = painterResource(R.drawable.icons_door), title = "Выйти", onClick = {})
                }
            }
        }
    }
}


@Composable
@Preview(showBackground = true)
fun ProfileScreenPreview() {
    AirbnbCloneTheme {
        ProfileScreenContent(


        )
    }
}





