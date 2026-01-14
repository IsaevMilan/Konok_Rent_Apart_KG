package com.KonokRent.app.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnbclone.app.presentation.theme.AppColors

@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    placeholder: String = "",
    modifier: Modifier = Modifier,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    trailingIcon: @Composable (() -> Unit)? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    enabled: Boolean = true,
    singleLine: Boolean = true
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        placeholder = { Text(placeholder) },
        modifier = modifier.fillMaxWidth(),
        visualTransformation = visualTransformation,
        trailingIcon = trailingIcon,
        keyboardOptions = keyboardOptions,
        enabled = enabled,
        singleLine = singleLine,
        shape = RoundedCornerShape(10.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = AppColors.TextPrimary,
            unfocusedTextColor = AppColors.TextPrimary,
            focusedLabelColor = AppColors.TextSecondary,
            unfocusedLabelColor = AppColors.TextSecondary,
            focusedBorderColor = AppColors.Primary,
            unfocusedBorderColor = AppColors.LightGrey
        )
    )
}

@Preview(showBackground = true)
@Composable
fun CustomTextFieldPreview_AllStates() {
    MaterialTheme {
            CustomTextField(
                value = "",
                onValueChange = {},
                label = "Email",
                placeholder = "Введите email"
            )

    }
}


/*@Preview(showBackground = true)
@Composable
fun CustomTextFieldPreview() {
    MaterialTheme {
        CustomTextField(
            value = "password123",
            onValueChange = {},
            label = "Пароль",
            visualTransformation = PasswordVisualTransformation()
        )

    }
}*/

