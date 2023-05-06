package com.example.compose.presentation.screen.token

import com.example.compose.presentation.screen.base.UiState
import com.google.errorprone.annotations.Immutable

@Immutable
data class TokenScreenState (
    val isLoading: Boolean,
    val data: String,
    val error: String? = null
): UiState {
    companion object {
        fun initial() = TokenScreenState(isLoading = true, data = "", error = null)
    }
}