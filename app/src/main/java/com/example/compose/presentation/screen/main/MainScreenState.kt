package com.example.compose.presentation.screen.main

import androidx.compose.runtime.Immutable
import com.example.compose.domain.model.api_model.Media
import com.example.compose.presentation.screen.base.UiState

@Immutable
data class MainScreenState(
    val isLoading: Boolean,
    val data: List<Media>,
    val error: String? = null
) : UiState {
    companion object {
        fun initial() = MainScreenState(isLoading = true, data = emptyList(), error = null)
    }
}