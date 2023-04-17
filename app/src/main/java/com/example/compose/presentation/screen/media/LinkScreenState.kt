package com.example.compose.presentation.screen.media

import com.example.compose.presentation.screen.base.UiState
import com.google.errorprone.annotations.Immutable

@Immutable
data class LinkScreenState (
    val isLoading: Boolean,
    val data: String,
    val error: String? = null
): UiState {
    companion object {
        fun initial() = LinkScreenState(isLoading = true, data = "", error = null)
    }
}