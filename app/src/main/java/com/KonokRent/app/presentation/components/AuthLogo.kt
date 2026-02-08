package com.airbnbclone.app.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnbclone.app.R

import com.airbnbclone.app.presentation.theme.AppColors

@Composable
fun AuthLogo(
    modifier: Modifier = Modifier
) {

    Image(
        painter = painterResource( R.drawable.main_logo),
        contentDescription = "Logo",
        modifier = Modifier.size(80.dp),
        colorFilter = ColorFilter.tint(AppColors.Accent),
    )
}

@Preview
@Composable
fun AuthLogoPreview() {
    Image(
        imageVector = ImageVector.vectorResource ( R.drawable.main_logo),
        contentDescription = "Logo",
        modifier = Modifier.size(80.dp),
        colorFilter = ColorFilter.tint(AppColors.Accent)
    )
}


@Composable
fun AuthOrnament() {
    Icon(
        imageVector = ImageVector.vectorResource ( R.drawable.top_ornament),
        contentDescription = "Logo",
        modifier = Modifier.size(220.dp, 40.dp),
        tint = AppColors.LightGrey
    )
}

@Preview
@Composable
fun AuthOrnamentPreview() {
    Icon(
        imageVector = ImageVector.vectorResource ( R.drawable.top_ornament),
        contentDescription = "Logo",
        modifier = Modifier.size(80.dp),
        tint = AppColors.LightGrey
    )
}