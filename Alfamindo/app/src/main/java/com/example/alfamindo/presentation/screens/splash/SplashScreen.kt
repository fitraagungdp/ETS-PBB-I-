package com.example.alfamindo.presentation.screens.splash

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.alfamindo.R
import com.example.alfamindo.presentation.screens.navhost.Screen
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(modifier: Modifier = Modifier, navHostController: NavHostController) {
    var visible by remember { mutableStateOf(false) }
    LaunchedEffect(key1 = Unit) {
        delay(1000)
        visible = true
        delay(3000)
        navHostController.popBackStack()
        navHostController.navigate(Screen.Register)
    }
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.primary)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.8f), contentAlignment = Alignment.Center
        ) {
            this@Column.AnimatedVisibility(
                visible = visible,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.alfamind_transparent),
                    contentDescription = null
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Powered By",
                style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.onPrimary)
            )

            Text(
                text = "Alfamindo",
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}