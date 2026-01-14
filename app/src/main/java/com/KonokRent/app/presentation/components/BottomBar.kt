package com.KonokRent.app.presentation.components

// presentation/components/BottomBar.kt  (или screens/main/BottomBar.kt — как тебе удобнее)
// или другой подходящий пакет

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AirbnbBottomBar(
    selectedIndex: Int,
    onItemSelected: (Int) -> Unit
) {
    NavigationBar(
        containerColor = Color.White,
        tonalElevation = 8.dp
    ) {
        val itemWidth = 72.dp
        val centerWidth = 90.dp

        // 0 — Вишлисты
        NavigationBarItem(
            modifier = Modifier.width(itemWidth),
            selected = selectedIndex == 0,
            onClick = { onItemSelected(0) },
            icon = {
                Icon(
                    imageVector = if (selectedIndex == 0) Icons.Filled.Favorite else Icons.Default.FavoriteBorder,
                    contentDescription = "Избранное",
                    tint = if (selectedIndex == 0) Color.Black else Color(0xFF666666)
                )
            },
            label = {
                Text(
                    "Вишлисты",
                    fontSize = 10.sp,
                    color = if (selectedIndex == 0) Color.Black else Color(0xFF666666)
                )
            },
            alwaysShowLabel = true
        )

        // 1 — Сообщения
        NavigationBarItem(
            modifier = Modifier.width(itemWidth),
            selected = selectedIndex == 1,
            onClick = { onItemSelected(1) },
            icon = {
                Icon(
                    imageVector = Icons.Default.ChatBubbleOutline,
                    contentDescription = "Сообщения",
                    tint = if (selectedIndex == 1) Color.Black else Color(0xFF666666)
                )
            },
            label = {
                Text(
                    "Сообщения",
                    color = if (selectedIndex == 1) Color.Black else Color(0xFF666666)
                )
            },
            alwaysShowLabel = true
        )

        // 2 — Поиск (центр)
        NavigationBarItem(
            modifier = Modifier.width(centerWidth),
            selected = selectedIndex == 2,
            onClick = { onItemSelected(2) },
            icon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Поиск",
                    tint = if (selectedIndex == 2) Color.Black else Color(0xFF666666)
                )
            },
            label = {
                Text(
                    "Поиск",
                    color = if (selectedIndex == 2) Color.Black else Color(0xFF666666)
                )
            },
            alwaysShowLabel = true
        )

        // 3 — Поездки
        NavigationBarItem(
            modifier = Modifier.width(itemWidth),
            selected = selectedIndex == 3,
            onClick = { onItemSelected(3) },
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Поездки",
                    tint = if (selectedIndex == 3) Color.Black else Color(0xFF666666)
                )
            },
            label = {
                Text(
                    "Поездки",
                    color = if (selectedIndex == 3) Color.Black else Color(0xFF666666)
                )
            },
            alwaysShowLabel = true
        )

        // 4 — Профиль
        NavigationBarItem(
            modifier = Modifier.width(itemWidth),
            selected = selectedIndex == 4,
            onClick = { onItemSelected(4) },
            icon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Профиль",
                    tint = if (selectedIndex == 4) Color.Black else Color(0xFF666666)
                )
            },
            label = {
                Text(
                    "Профиль",
                    color = if (selectedIndex == 4) Color.Black else Color(0xFF666666)
                )
            },
            alwaysShowLabel = true
        )
    }
}