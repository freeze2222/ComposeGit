package com.example.compose.presentation.screen.media

import androidx.compose.runtime.Immutable
import com.example.compose.presentation.screen.base.UiEvent

@Immutable
sealed class LinkScreenEvent: UiEvent {
    object LoadingData: LinkScreenEvent()
    data class ShowData(val data: String): LinkScreenEvent()
    data class ShowError(val errorMessage: String?) : LinkScreenEvent()
}