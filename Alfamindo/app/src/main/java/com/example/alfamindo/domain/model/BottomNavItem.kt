package com.example.alfamindo.domain.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Store
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.alfamindo.presentation.screens.navhost.Screen

data class BottomNavItem(
    val label: String,
    val icon: ImageVector,
    val route: Screen
)

val listBottomNavItem = listOf(
    BottomNavItem("Home", Icons.Outlined.Home, Screen.Home),
    BottomNavItem("Store", Icons.Outlined.Store, Screen.Store),
    BottomNavItem("Profile", Icons.Outlined.Person, Screen.Profile),
)