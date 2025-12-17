package com.airbnbclone.app.presentation.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnbclone.app.presentation.theme.AppColors

@Composable
fun AuthLogo() {
    Icon(
        imageVector = Icons.Default.Home,
        contentDescription = "Logo",
        modifier = Modifier.size(80.dp),
        tint = AppColors.Primary
    )
}

