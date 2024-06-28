package com.example.alfamindo.utils

import java.text.NumberFormat
import java.util.Currency


fun Int.toIdr(): String {
    val format: NumberFormat = NumberFormat.getCurrencyInstance()
    format.setMaximumFractionDigits(0)
    format.currency = Currency.getInstance("IDR")

    val result = format.format(this)
    return result.replace("IDR", "Rp ")
}