package com.example.compose.presentation.screen.token

import androidx.compose.runtime.Immutable
import com.example.compose.presentation.screen.base.UiEvent

@Immutable
sealed class TokenScreenEvent: UiEvent {
    object LoadingData: TokenScreenEvent()
    data class ShowData(val data: String): TokenScreenEvent()
    data class ShowError(val errorMessage: String?) : TokenScreenEvent()
}