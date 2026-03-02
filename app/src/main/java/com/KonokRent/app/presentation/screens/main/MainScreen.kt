package com.KonokRent.app.presentation.screens.main

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.KonokRent.app.presentation.components.AirbnbBottomBar

// Убираем старый NavigationBar и вставляем новый компонент

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavHostController) {
    var selectedIndex by remember { mutableIntStateOf(2) } // Поиск по умолчанию

    Scaffold(
        bottomBar = {
            AirbnbBottomBar(
                selectedIndex = selectedIndex,
                onItemSelected = { index -> selectedIndex = index }
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            when (selectedIndex) {
                0 -> Text("Wishlist", modifier = Modifier.padding(16.dp))
                1 -> Text("Messages", modifier = Modifier.padding(16.dp))
                2 -> navController.navigate("search")
                3 -> Text("Home", modifier = Modifier.padding(16.dp))
                4 -> Text("Profile", modifier = Modifier.padding(16.dp))
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MaterialTheme {
        MainScreen(
            navController = rememberNavController()
        )
    }
}