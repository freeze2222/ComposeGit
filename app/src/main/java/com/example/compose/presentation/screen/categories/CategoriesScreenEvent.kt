package com.example.compose.presentation.screen.categories

import androidx.compose.runtime.Immutable
import com.example.compose.presentation.screen.base.UiEvent

@Immutable
sealed class CategoriesScreenEvent: UiEvent {
    object LoadingData: CategoriesScreenEvent()
    data class ShowData(val data: MutableList<String>): CategoriesScreenEvent()
    data class ShowError(val errorMessage: String?) : CategoriesScreenEvent()
}