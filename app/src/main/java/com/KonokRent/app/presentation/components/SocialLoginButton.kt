package com.airbnbclone.app.presentation.components

import android.graphics.drawable.Icon
import android.widget.ImageButton
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnbclone.app.R
import com.airbnbclone.app.presentation.theme.AppColors

@Composable
fun SocialLoginButton(
    onClick: () -> Unit,
    icon: Painter, // Используем Painter вместо Icon
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
            .size(22.dp, )
            .background(
                color = Color.White,
                shape = CircleShape
            )

    ) {
        Icon(
            painter = icon,
            contentDescription = null,
            modifier = Modifier.size(22.dp),
            tint = Color.Unspecified
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SocialLoginButtonPreview_Google() {
    MaterialTheme {
        SocialLoginButton(
            icon = painterResource(id = R.drawable.flat_color_icons_google),
            onClick = {}
        )
    }
}

