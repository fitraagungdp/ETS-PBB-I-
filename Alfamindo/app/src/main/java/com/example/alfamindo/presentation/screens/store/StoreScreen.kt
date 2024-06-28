package com.example.alfamindo.presentation.screens.store

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material.icons.outlined.Store
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.alfamindo.domain.model.listProducts
import com.example.alfamindo.presentation.screens.home.component.ProductItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StoreScreen(modifier: Modifier = Modifier, navHostController: NavHostController) {
    val config = LocalConfiguration.current
    val screenWidth = config.screenWidthDp.dp

    Column(
        modifier = modifier
            .padding(25.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .background(
                    color = MaterialTheme.colorScheme.primary,
                    shape = MaterialTheme.shapes.large
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .width(70.dp)
                        .clip(MaterialTheme.shapes.medium)
                        .clickable { },
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        modifier = Modifier.size(30.dp),
                        imageVector = Icons.Outlined.Store,
                        contentDescription = null,
                        tint = Color.White
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = "Profil Toko",
                        style = MaterialTheme.typography.bodySmall.copy(color = Color.White)
                    )
                }

                Spacer(
                    modifier = Modifier
                        .height(38.dp)
                        .width(2.dp)
                        .background(color = MaterialTheme.colorScheme.onPrimary)
                )

                Column(
                    modifier = Modifier
                        .width(70.dp)
                        .clip(MaterialTheme.shapes.medium)
                        .clickable { },
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        modifier = Modifier.size(30.dp),
                        imageVector = Icons.Outlined.Share,
                        contentDescription = null,
                        tint = Color.White
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = "Bagikan",
                        style = MaterialTheme.typography.bodySmall.copy(color = Color.White)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(17.dp))

        Text(
            modifier = Modifier.padding(bottom = 34.dp),
            text = "Produk Terbaru",
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
        )
        LazyVerticalGrid(
            modifier = Modifier.height((listProducts.size * 150).dp),
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(listProducts) { product ->
                ProductItem(
                    modifier = Modifier.padding(bottom = 10.dp),
                    data = product,
                    onClick = { /*TODO*/ },
                    onAddToCart = { /*TODO*/ },
                    onShare = { /*TODO*/ },
                    screenWidth = screenWidth
                )
            }
        }

        Spacer(modifier = Modifier.height(150.dp))
    }
}