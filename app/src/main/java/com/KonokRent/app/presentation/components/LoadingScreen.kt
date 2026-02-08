package com.KonokRent.app.presentation.components


import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnbclone.app.R
import kotlin.math.sin


@Composable
fun LoadingScreen() {
    val infiniteTransition = rememberInfiniteTransition()

    val rotY by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(3000, easing = LinearEasing)
        )
    )

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        // Отбрасывание тени
        Box(
            modifier = Modifier
                .size(110.dp)
                .background(
                    brush = Brush.radialGradient(
                        colors = listOf(
                            Color.Black.copy(alpha = 0.1f),
                            Color.Transparent
                        ),
                        radius = 180.dp.value
                    ),
                    shape = CircleShape
                )
                .offset(y = 40.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.main_logo),
            contentDescription = "Advanced Loading",
            modifier = Modifier
                .size(100.dp)
                .graphicsLayer {
                    //задаем вращение по осям rotationY или Z,X
                    rotationY = rotY
                    // Добавляем перспективу для 3D
                    cameraDistance = 10f * density
                    // Легкое искажение при вращении
                    transformOrigin = TransformOrigin(0.5f, 0.5f)
                    scaleX = 1f + sin(Math.toRadians(rotY.toDouble())).toFloat() * 0.2f

                }

        )
    }
}

@Preview(showBackground = true)
@Composable

fun LoadingScreenPreview() {
    LoadingScreen()
}
