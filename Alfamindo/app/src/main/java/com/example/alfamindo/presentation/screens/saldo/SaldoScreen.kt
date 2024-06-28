package com.example.alfamindo.presentation.screens.saldo

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import com.example.alfamindo.R
import com.example.alfamindo.domain.model.listWalletTransactionItem
import com.example.alfamindo.presentation.screens.navhost.Screen
import com.example.alfamindo.presentation.screens.saldo.component.WalletTransactionItem
import com.example.alfamindo.utils.toIdr

@Composable
fun SaldoScreen(modifier: Modifier = Modifier, navHostController: NavHostController){
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.primary)
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .zIndex(1f),
            painter = painterResource(id = R.drawable.alfamind_auth_svg),
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .zIndex(2f)
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Row(
                modifier = Modifier
                    .clickable { },
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { navHostController.navigateUp() }) {
                    Icon(
                        modifier = Modifier
                            .padding(end = 10.dp)
                            .size(30.dp),
                        imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
                        contentDescription = null,
                        tint = Color.White,
                    )
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(130.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Saldo Alfamindo",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                )
                Text(
                    text = 100000000.toIdr(),
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                )
                Spacer(modifier = Modifier.height(11.dp))
                Box(
                    modifier = Modifier
                        .background(
                            brush = Brush.linearGradient(
                                colors = listOf(
                                    Color(0xFFF19100),
                                    MaterialTheme.colorScheme.primary
                                ),
                            ),
                            shape = MaterialTheme.shapes.large.copy(CornerSize(20.dp))
                        )
                        .clip(MaterialTheme.shapes.large.copy(CornerSize(20.dp)))
                        .clickable {
                            navHostController.navigate(Screen.Deposit)
                        }
                        .padding(10.dp)
                ) {
                    Text(
                        text = "Topup Saldo", style = MaterialTheme.typography.bodyMedium.copy(
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }

                Spacer(modifier = Modifier.height(54.dp))
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)
                    )
                    .padding(25.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Histori Transaksi Bulan",
                        style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    LazyColumn(modifier = Modifier.height((listWalletTransactionItem.size * 40).dp)) {
                        items(listWalletTransactionItem) { data ->
                            WalletTransactionItem(data = data, onClick = {})
                        }
                    }
                }
            }
        }
    }
}