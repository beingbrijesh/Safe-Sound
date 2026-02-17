package com.safesound.app.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors = lightColorScheme(
    primary = SafeSoundGreen,
    secondary = SafeSoundOrange,
    tertiary = SafeSoundRed,
    background = SafeSoundBackground,
    surface = SafeSoundSurface,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black
)

private val DarkColors = darkColorScheme(
    primary = SafeSoundGreen,
    secondary = SafeSoundOrange,
    tertiary = SafeSoundRed,
    background = Color(0xFF121212),
    surface = Color(0xFF1B1B1B),
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.White,
    onSurface = Color.White
)

@Composable
fun SafeSoundTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (useDarkTheme) DarkColors else LightColors

    MaterialTheme(
        colorScheme = colors,
        typography = SafeSoundTypography,
        content = content
    )
}
