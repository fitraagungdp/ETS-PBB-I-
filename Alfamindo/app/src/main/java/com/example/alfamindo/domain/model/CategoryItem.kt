package com.example.alfamindo.domain.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Blender
import androidx.compose.material.icons.outlined.Book
import androidx.compose.material.icons.outlined.Devices
import androidx.compose.material.icons.outlined.Square
import androidx.compose.material.icons.outlined.Store
import androidx.compose.ui.graphics.vector.ImageVector

data class CategoryItem(
    val icon: ImageVector,
    val label: String
)

val listCategories = listOf(
    CategoryItem(
        icon = Icons.Outlined.Devices,
        label = "Gadget & Smartphone"
    ),
    CategoryItem(
        icon = Icons.Outlined.Book,
        label = "Buku & Alat Tulis"
    ),
    CategoryItem(
        icon = Icons.Outlined.Blender,
        label = "Peralatan dapur"
    ),
    CategoryItem(
        icon = Icons.Outlined.Store,
        label = "Pojok usaha"
    ),
    CategoryItem(
        icon = Icons.Outlined.Square,
        label = "Semua Kategori"
    ),
)
