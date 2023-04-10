package com.example.compose.presentation.screen.main

import androidx.compose.runtime.Immutable
import com.example.compose.domain.model.api_model.Media
import com.example.compose.presentation.screen.base.UiEvent

@Immutable
sealed class MainScreenEvent: UiEvent {
    object LoadingData: MainScreenEvent()
    data class ShowData(val data: List<Media>): MainScreenEvent()
    data class ShowError(val errorMessage: String?) : MainScreenEvent()
}