package com.airbnbclone.app.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnbclone.app.presentation.theme.AppColors

@Composable
fun SocialLoginButton(
    text: String,
    onClick: () -> Unit,
    backgroundColor: androidx.compose.ui.graphics.Color,
    modifier: Modifier = Modifier
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp),
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = backgroundColor
        ),
        border = ButtonDefaults.outlinedButtonBorder.copy(
            brush = androidx.compose.ui.graphics.SolidColor(backgroundColor)
        )
    ) {
        Text(text = text)
    }
}

@Preview(showBackground = true)
@Composable
fun SocialLoginButtonPreview_Google() {
    MaterialTheme {
        SocialLoginButton(
            text = "Войти через Google",
            onClick = {},
            backgroundColor = AppColors.GoogleBlue
        )
    }
}

