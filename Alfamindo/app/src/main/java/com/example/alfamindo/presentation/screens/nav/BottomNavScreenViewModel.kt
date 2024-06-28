package com.example.alfamindo.presentation.screens.nav

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class BottomNavScreenViewModel : ViewModel() {

    private val _selected = MutableStateFlow(0)
    val selected: StateFlow<Int> = _selected.asStateFlow()

    fun updateSelected(value: Int) {
        _selected.value = value
    }
}