package com.example.alfamindo.presentation.screens.navhost

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.alfamindo.presentation.screens.deposit.DepositScreen
import com.example.alfamindo.presentation.screens.login.LoginScreen
import com.example.alfamindo.presentation.screens.nav.BottomNavScreen
import com.example.alfamindo.presentation.screens.nav.BottomNavScreenViewModel
import com.example.alfamindo.presentation.screens.register.RegisterScreen
import com.example.alfamindo.presentation.screens.saldo.SaldoScreen
import com.example.alfamindo.presentation.screens.splash.SplashScreen

@Composable
fun MainNavHost(navHostController: NavHostController) {
    val bottomNavScreenViewModel: BottomNavScreenViewModel =
        viewModel(modelClass = BottomNavScreenViewModel::class.java)
    NavHost(navController = navHostController, startDestination = Screen.Splash) {
        composable<Screen.Splash> {
            SplashScreen(navHostController = navHostController)
        }
        composable<Screen.Register> {
            RegisterScreen(navHostController = navHostController)
        }
        composable<Screen.Login> {
            LoginScreen(navHostController = navHostController)
        }
        composable<Screen.BottomNav> {
            val bottomNavHost = rememberNavController()
            BottomNavScreen(
                navHostController = bottomNavHost,
                onDeposit = {
                    navHostController.navigate(Screen.Saldo)
                },
                viewModel = bottomNavScreenViewModel
            )
        }
        composable<Screen.Deposit> {
            DepositScreen(navHostController = navHostController)
        }
        composable<Screen.Saldo> {
            SaldoScreen(navHostController = navHostController)
        }
    }
}