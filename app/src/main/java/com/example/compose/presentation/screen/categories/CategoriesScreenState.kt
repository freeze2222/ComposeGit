package com.example.compose.presentation.screen.categories

import com.example.compose.presentation.screen.base.UiState
import com.google.errorprone.annotations.Immutable

@Immutable
data class CategoriesScreenState(
    val isLoading: Boolean,
    val data: MutableList<String>,
    val error: String? = null
): UiState {
    companion object {
        fun initial() = CategoriesScreenState(isLoading = true, data = mutableListOf(), error = null)
    }
}