package com.KonokRent.app.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnbclone.app.R

@Composable
fun AirbnbBottomBar(
    selectedIndex: Int,
    onItemSelected: (Int) -> Unit
) {
    NavigationBar(
        containerColor = Color.White,
        tonalElevation = 10.dp,
    ) {

        // 0 Вишлисты
        NavigationBarItem(
            modifier = Modifier.weight(1f),
            selected = selectedIndex == 0,
            onClick = { onItemSelected(0) },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.heart), // Исправлено
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

        // 1 Сообщения
        NavigationBarItem(
            modifier = Modifier.weight(1f),
            selected = selectedIndex == 1,
            onClick = { onItemSelected(1) },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_chat), // Исправлено
                    contentDescription = "Сообщения",
                    tint = if (selectedIndex == 1) Color.Black else Color(0xFF666666)
                )
            },
            label = {
                Text(
                    "Сообщения",
                    fontSize = 10.sp,
                    color = if (selectedIndex == 1) Color.Black else Color(0xFF666666)
                )
            },
            alwaysShowLabel = true
        )

        // 2 Поиск
        NavigationBarItem(
            modifier = Modifier.weight(1f),
            selected = selectedIndex == 2,
            onClick = { onItemSelected(2) },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.icon_search), // Исправлено
                    contentDescription = "Поиск",
                    tint = if (selectedIndex == 2) Color.Black else Color(0xFF666666)
                )
            },
            label = {
                Text(
                    "Поиск",
                    fontSize = 10.sp,
                    color = if (selectedIndex == 2) Color.Black else Color(0xFF666666)
                )
            },
            alwaysShowLabel = true
        )

        // 3 Поездки
        NavigationBarItem(
            modifier = Modifier.weight(1f),
            selected = selectedIndex == 3,
            onClick = { onItemSelected(3) },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.map_arrow_up), // Исправлено
                    contentDescription = "Поездки",
                    tint = if (selectedIndex == 3) Color.Black else Color(0xFF666666)
                )
            },
            label = {
                Text(
                    "Поездки",
                    fontSize = 10.sp,
                    color = if (selectedIndex == 3) Color.Black else Color(0xFF666666)
                )
            },
            alwaysShowLabel = true
        )

        // 4 Профиль
        NavigationBarItem(
            modifier = Modifier.weight(1f),
            selected = selectedIndex == 4,
            onClick = { onItemSelected(4) },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.icon_user), // Исправлено
                    contentDescription = "Профиль",
                    tint = if (selectedIndex == 4) Color.Black else Color(0xFF666666)
                )
            },
            label = {
                Text(
                    "Профиль",
                    fontSize = 10.sp,
                    color = if (selectedIndex == 4) Color.Black else Color(0xFF666666)
                )
            },
            alwaysShowLabel = true
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AirbnbBottomBarPreview() {
    var selectedIndex by remember { mutableIntStateOf(1) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
    ) {
        AirbnbBottomBar(
            selectedIndex = selectedIndex,
            onItemSelected = { index ->
                selectedIndex = index
            }
        )
    }
}