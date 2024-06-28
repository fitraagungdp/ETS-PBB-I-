package com.example.alfamindo.presentation.screens.navhost

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.alfamindo.presentation.screens.home.HomeScreen
import com.example.alfamindo.presentation.screens.profile.ProfileScreen
import com.example.alfamindo.presentation.screens.store.StoreScreen
import kotlinx.serialization.Serializable

interface Screen {
    @Serializable
    data object Home : Screen

    @Serializable
    data object Login : Screen

    @Serializable
    data object Register : Screen

    @Serializable
    data object Deposit : Screen

    @Serializable
    data object Saldo : Screen

    @Serializable
    data object Profile : Screen

    @Serializable
    data object Store : Screen

    @Serializable
    data object Splash : Screen

    @Serializable
    data object BottomNav : Screen
}

@Composable
fun BottomNavhost(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    onDeposit: () -> Unit
) {
    NavHost(
        modifier = Modifier.zIndex(0f),
        navController = navHostController,
        startDestination = Screen.Home
    ) {
        composable<Screen.Home> {
            HomeScreen(
                navHostController = navHostController,
                modifier = modifier,
                onDeposit = onDeposit
            )
        }
        composable<Screen.Profile> {
            ProfileScreen(
                navHostController = navHostController,
                modifier = modifier,
                onDeposit = onDeposit
            )
        }
        composable<Screen.Store> {
            StoreScreen(navHostController = navHostController, modifier = modifier)
        }
    }
}