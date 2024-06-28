package com.example.alfamindo.presentation.screens.saldo.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.example.alfamindo.domain.model.WalletTransactionItem
import com.example.alfamindo.utils.toIdr

@Composable
fun WalletTransactionItem(
    modifier: Modifier = Modifier,
    data: WalletTransactionItem,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier.fillMaxWidth().clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(
                text = data.date,
                style = MaterialTheme.typography.bodySmall.copy(color = Color.LightGray)
            )
            Text(
                text = data.type,
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
            )
        }

        Text(
            text = data.amount.toIdr(),
            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
        )
    }
}