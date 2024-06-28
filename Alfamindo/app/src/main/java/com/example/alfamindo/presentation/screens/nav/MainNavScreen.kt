package com.example.alfamindo.presentation.screens.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.alfamindo.presentation.screens.navhost.MainNavHost

@Composable
fun MainNavScreen(navHostController: NavHostController) {
    MainNavHost(navHostController = navHostController)
}