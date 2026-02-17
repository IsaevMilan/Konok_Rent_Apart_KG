package com.airbnbclone.app.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnbclone.app.presentation.theme.AppColors

@Composable
fun CustomButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isLoading: Boolean = false,
    enabled: Boolean = true,
    backgroundColor: androidx.compose.ui.graphics.Color = AppColors.Primary,
    textColor: androidx.compose.ui.graphics.Color = AppColors.White
) {
    Button(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        enabled = enabled && !isLoading,
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = textColor,
            disabledContainerColor = AppColors.LightGrey,
            disabledContentColor = AppColors.TextSecondary
        )
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.size(24.dp),
                color = textColor,
                strokeWidth = 2.dp
            )
        } else {
            Text(
                text = text,
                style = MaterialTheme.typography.labelLarge
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CustomButtonPreview_CustomColors() {
    MaterialTheme {
        CustomButton(
            text = "Введите текст",
            onClick = {},
            backgroundColor = AppColors.Primary,
            textColor = AppColors.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CustomButtonPreview2_CustomColors() {
    MaterialTheme {
        CustomButton(
            text = "Введите текст",
            onClick = {},
            backgroundColor = AppColors.Grey,
            textColor = AppColors.White
        )
    }
}
