package com.example.alfamindo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.navigation.compose.rememberNavController
import com.example.alfamindo.presentation.screens.nav.MainNavScreen
import com.example.alfamindo.ui.theme.AlfamindoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AlfamindoTheme {
                Surface {
                    val navHostController = rememberNavController()
                    MainNavScreen(navHostController = navHostController)
                }
            }
        }
    }
}