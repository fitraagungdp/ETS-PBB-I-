package com.example.alfamindo.presentation.screens.register

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.alfamindo.R
import com.example.alfamindo.presentation.screens.navhost.Screen

@Composable
fun RegisterScreen(modifier: Modifier = Modifier, navHostController: NavHostController) {
    var value by remember { mutableStateOf("") }
    Column(
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 36.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.alfamind_auth_svg),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(25.dp)
            ) {
                Spacer(modifier = Modifier.height(24.dp))
                Image(
                    painter = painterResource(id = R.drawable.alfamind),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(bottom = 14.dp)
                        .width(140.dp)
                        .height(50.dp)
                        .background(Color.Blue),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = "Jadi Store Owner di\n" +
                            "Alfamindo",
                    style = MaterialTheme.typography.headlineSmall.copy(
                        color = MaterialTheme.colorScheme.onPrimary,
                        fontWeight = FontWeight.Bold
                    ),
                )
                Text(
                    text = "Wujudkan mimpi kamu memiliki toko ritel sendiri dan dapatkan penghasilan yang melimpah",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = MaterialTheme.colorScheme.onPrimary
                    ),
                )
            }
        }

        Column(
            modifier = Modifier
                .padding(bottom = 52.dp)
                .padding(horizontal = 24.dp)
        ) {
            Text(text = "Nomor HP Kamu", style = MaterialTheme.typography.bodySmall)
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 7.dp),
                value = value,
                onValueChange = {
                    value = it
                },
                placeholder = {
                    Text(
                        text = "Contoh: 081234567890",
                        style = MaterialTheme.typography.bodyMedium.copy(color = Color.LightGray)
                    )
                },
                shape = MaterialTheme.shapes.large
            )
            Text(
                text = "Dengan mendaftar atau masuk, Kamu scara otomatis menyetujui Syarat & Ketentuan yang berlaku",
                style = MaterialTheme.typography.bodySmall.copy(fontSize = 10.sp)
            )
        }

        Button(
            modifier = Modifier
                .padding(bottom = 11.dp)
                .padding(horizontal = 24.dp)
                .fillMaxWidth(),
            onClick = {
                navHostController.popBackStack()
                navHostController.navigate(Screen.BottomNav)
            },
            shape = MaterialTheme.shapes.medium,
        ) {
            Text(text = "Daftar", style = MaterialTheme.typography.bodyMedium)
        }
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            Text(
                modifier = Modifier
                    .clickable {
                        navHostController.navigate(Screen.Login)
                    },
                text = buildAnnotatedString {
                    append("Belum punya akun?")
                    withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)) {
                        append(" Masuk disini")
                    }
                },
                style = MaterialTheme.typography.bodySmall.copy(
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            )
        }
    }
}