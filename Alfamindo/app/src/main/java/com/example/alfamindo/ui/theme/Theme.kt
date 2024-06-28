package com.example.alfamindo.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.materialkolor.PaletteStyle
import com.materialkolor.dynamicColorScheme

@Composable
fun AlfamindoTheme(
    content: @Composable () -> Unit
) {
    val colorScheme = dynamicColorScheme(
        seedColor = Color(0xFFEA0A2A),
        isDark = false,
        style = PaletteStyle.Vibrant,
    )

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}