package com.example.alfamindo.presentation.screens.deposit

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DepositScreen(modifier: Modifier = Modifier, navHostController: NavHostController) {
    var depositValue by remember {
        mutableStateOf("")
    }
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                modifier = Modifier.shadow(elevation = 3.dp),
                title = {
                    Text(
                        text = "Deposit",
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navHostController.navigateUp() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
                            contentDescription = null
                        )
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(25.dp)
        ) {
            Text(
                text = "Masukkan jumlah top up yang kamu inginkan",
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(28.dp))
            Column(
                modifier = Modifier
                    .padding(bottom = 35.dp)
            ) {
                Text(text = "Jumlah Top Up", style = MaterialTheme.typography.bodySmall)
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 7.dp),
                    value = depositValue,
                    onValueChange = {
                        if (it.isDigitsOnly()) {
                            depositValue = it
                        }
                    },
                    placeholder = {
                        Text(
                            text = "Contoh: 100000",
                            style = MaterialTheme.typography.bodyMedium.copy(color = Color.LightGray)
                        )
                    },
                    shape = MaterialTheme.shapes.large,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
            }
            Button(
                modifier = Modifier
                    .padding(bottom = 11.dp)
                    .fillMaxWidth(),
                onClick = { /*TODO*/ },
                shape = MaterialTheme.shapes.medium,
            ) {
                Text(text = "Lanjut", style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}