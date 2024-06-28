package com.example.alfamindo.presentation.screens.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.alfamindo.R
import com.example.alfamindo.domain.model.CategoryItem
import com.example.alfamindo.domain.model.ProductItem
import com.example.alfamindo.utils.toIdr

@Composable
fun CategoryItem(modifier: Modifier = Modifier, data: CategoryItem, onClick: () -> Unit) {
    Column(
        modifier = modifier
            .heightIn(min = 69.dp)
            .clip(shape = MaterialTheme.shapes.medium)
            .clickable { onClick() },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            modifier = Modifier.size(40.dp),
            imageVector = data.icon,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary
        )
        Text(
            modifier = Modifier.width(61.dp),
            text = data.label,
            style = MaterialTheme.typography.bodySmall.copy(
                fontSize = 8.sp,
                textAlign = TextAlign.Center
            )
        )
    }
}

@Composable
fun ProductItem(
    modifier: Modifier = Modifier,
    data: ProductItem,
    onClick: (ProductItem) -> Unit,
    onAddToCart: (ProductItem) -> Unit,
    onShare: (ProductItem) -> Unit,
    screenWidth: Dp
) {
    Box(modifier = modifier
        .width(screenWidth / 2.5f)
        .shadow(elevation = 2.dp, shape = MaterialTheme.shapes.medium)
        .background(color = Color.White, shape = MaterialTheme.shapes.medium)
        .clip(shape = MaterialTheme.shapes.medium)
        .clickable { onClick(data) }
    ) {
        Column {
            AsyncImage(
                model = data.image.first(),
                error = painterResource(
                    id = R.drawable.alfamind
                ),
                placeholder = painterResource(
                    id = R.drawable.alfamind
                ),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .clip(MaterialTheme.shapes.large),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier.padding(horizontal = 10.dp)
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(37.dp),
                    text = data.name,
                    style = MaterialTheme.typography.bodySmall,
                    overflow = TextOverflow.Ellipsis,
                )
                Text(
                    text = data.price.toIdr(),
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = MaterialTheme.colorScheme.primary
                    )
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(
                        modifier = Modifier.width(screenWidth / 4.5f),
                        onClick = { onAddToCart(data) },
                        shape = MaterialTheme.shapes.small,
                        contentPadding = PaddingValues(10.dp)
                    ) {
                        Text(text = "Keranjang", style = MaterialTheme.typography.bodySmall)
                    }
                    IconButton(onClick = { onShare(data) }) {
                        Icon(
                            modifier = Modifier.size(20.dp),
                            imageVector = Icons.Outlined.Share,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            }
        }
    }
}