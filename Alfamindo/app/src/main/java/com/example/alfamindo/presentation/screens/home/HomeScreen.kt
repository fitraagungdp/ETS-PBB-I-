package com.example.alfamindo.presentation.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Wallet
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
import com.example.alfamindo.domain.model.listCategories
import com.example.alfamindo.domain.model.listProducts
import com.example.alfamindo.presentation.screens.home.component.CategoryItem
import com.example.alfamindo.presentation.screens.home.component.ProductItem
import com.example.alfamindo.utils.toIdr

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    onDeposit: () -> Unit
) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp

    Column(
        modifier = modifier
            .verticalScroll(state = rememberScrollState())
            .padding(horizontal = 25.dp)
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Box(
            modifier = Modifier
                .padding(bottom = 33.dp)
                .fillMaxWidth()
                .background(
                    color = MaterialTheme.colorScheme.primary,
                    shape = MaterialTheme.shapes.medium
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(vertical = 15.dp, horizontal = 25.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(0.5f)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Wallet,
                            contentDescription = null,
                            modifier = Modifier.size(35.dp),
                            tint = MaterialTheme.colorScheme.onPrimary
                        )
                        Text(
                            text = "Saldo",
                            style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.onPrimary)
                        )
                    }
                    Text(
                        text = 1000000000.toIdr(),
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = MaterialTheme.colorScheme.onPrimary,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }

                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .background(
                            color = Color(0xFFF19100),
                            shape = MaterialTheme.shapes.medium
                        )
                        .clip(MaterialTheme.shapes.medium)
                        .clickable {
                            onDeposit()
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Add,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }
        }

        Text(
            modifier = Modifier.padding(bottom = 34.dp),
            text = "Kategori",
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
        )

        LazyVerticalGrid(
            modifier = Modifier.height((listCategories.size * 40).dp),
            columns = GridCells.Fixed(4),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(items = listCategories, key = { data -> data.label }) { category ->
                CategoryItem(
                    data = category,
                    modifier = Modifier.padding(bottom = 24.dp),
                    onClick = {})
            }
        }

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
    }
}