package com.example.alfamindo.presentation.screens.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowForwardIos
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.Wallet
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.alfamindo.R
import com.example.alfamindo.presentation.screens.profile.component.ProfileListItem

@Composable
fun ProfileScreen(modifier: Modifier = Modifier, navHostController: NavHostController,onDeposit: () -> Unit){
    Column(
        modifier = modifier
            .padding(25.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(
                    color = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f),
                    shape = MaterialTheme.shapes.medium
                ),
            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(25.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .size(50.dp)
                        .clip(MaterialTheme.shapes.medium),
                    painter = painterResource(id = R.drawable.timotironaldo),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
                Column {
                    Text(
                        text = "Timothy Ronaldo",
                        style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Bold)
                    )
                    Text(
                        text = "Bergabung sejak 27 Juni 1999",
                        style = MaterialTheme.typography.bodySmall.copy(fontSize = 11.sp)
                    )
                    Text(
                        text = "Saldo: Rp 1,000,000,000",
                        style = MaterialTheme.typography.bodySmall.copy(fontSize = 11.sp)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        ProfileListItem(
            modifier = Modifier.padding(bottom = 10.dp),
            onClick = { /*TODO*/ },
            leadingIcon = Icons.Outlined.Settings,
            label = "Pengaturan Akun",
            trailingIcon = Icons.AutoMirrored.Outlined.ArrowForwardIos
        )

        ProfileListItem(
            modifier = Modifier.padding(bottom = 10.dp),
            onClick = {
                onDeposit()
            },
            leadingIcon = Icons.Outlined.Wallet,
            label = "Saldo",
            trailingIcon = Icons.AutoMirrored.Outlined.ArrowForwardIos
        )
    }
}
