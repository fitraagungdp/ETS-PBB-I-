package com.example.alfamindo.domain.model

data class WalletTransactionItem(
    val date: String,
    val amount: Int,
    val type: String,
)

val listWalletTransactionItem = listOf(
    WalletTransactionItem(
        date = "21 Jun 2024 00:00",
        amount = -10000,
        type = "PAY_TO"
    ),
    WalletTransactionItem(
        date = "22 Jun 2024 00:00",
        amount = -20000,
        type = "PAY_TO"
    ),
    WalletTransactionItem(
        date = "23 Jun 2024 00:00",
        amount = -30000,
        type = "PAY_TO"
    ),
    WalletTransactionItem(
        date = "24 Jun 2024 00:00",
        amount = -40000,
        type = "PAY_TO"
    ),
    WalletTransactionItem(
        date = "25 Jun 2024 00:00",
        amount = -50000,
        type = "PAY_TO"
    ),
    WalletTransactionItem(
        date = "26 Jun 2024 00:00",
        amount = -60000,
        type = "PAY_TO"
    ),
)