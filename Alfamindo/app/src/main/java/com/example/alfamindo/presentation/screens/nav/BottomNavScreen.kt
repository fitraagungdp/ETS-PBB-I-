package com.example.alfamindo.presentation.screens.nav

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.example.alfamindo.R
import com.example.alfamindo.domain.model.listBottomNavItem
import com.example.alfamindo.presentation.screens.navhost.BottomNavhost

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavScreen(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    viewModel: BottomNavScreenViewModel,
    onDeposit: () -> Unit
) {
    val selectedItem = viewModel.selected.collectAsState().value
    LaunchedEffect(key1 = Unit) {
        Log.d(TAG, "BottomNavScreen: $selectedItem")
    }
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = modifier.shadow(elevation = 3.dp),
                title = { /*TODO*/ },
                navigationIcon = {
                    Image(
                        modifier = Modifier.width(90.dp),
                        painter = painterResource(id = R.drawable.alfamind_transparent),
                        contentDescription = null
                    )
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Outlined.Notifications, contentDescription = null)
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Outlined.ShoppingCart, contentDescription = null)
                    }
                })
        },
        bottomBar = {
            NavigationBar(
                modifier = Modifier
                    .fillMaxWidth(),
                containerColor = Color.White,
                contentColor = MaterialTheme.colorScheme.primary
            ) {
                listBottomNavItem.forEachIndexed { index, bottomNavItem ->
                    NavigationBarItem(
                        selected = index == selectedItem,
                        onClick = {
                            viewModel.updateSelected(index)
                            Log.d(TAG, "BottomNavScreen: $selectedItem")
                            navHostController.navigate(bottomNavItem.route) {
                                popUpTo(navHostController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = {
                            Icon(
                                imageVector = bottomNavItem.icon,
                                contentDescription = null
                            )
                        },
                        label = {
                            Text(
                                text = bottomNavItem.label,
                                style = MaterialTheme.typography.bodySmall
                            )
                        }
                    )
                }
            }
        }
    ) { paddingValues ->
        BottomNavhost(
            navHostController = navHostController,
            modifier = Modifier.padding(paddingValues),
            onDeposit = onDeposit
        )
    }
}