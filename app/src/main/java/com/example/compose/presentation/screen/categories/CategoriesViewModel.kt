package com.example.compose.presentation.screen.categories

import androidx.lifecycle.viewModelScope
import com.example.compose.domain.usecase.CategoriesUseCase
import com.example.compose.presentation.screen.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class CategoriesViewModel @Inject constructor(
    categoriesUseCase: CategoriesUseCase,
) : BaseViewModel<CategoriesScreenState, CategoriesScreenEvent>() {

    private val reducer = CategoriesReducer(
        initial = CategoriesScreenState.initial(),
        useCase = categoriesUseCase,
        viewModelScope = viewModelScope
    )

    override val state: StateFlow<CategoriesScreenState>
        get() = reducer.state

    init {
        sendEvent(CategoriesScreenEvent.LoadingData)
    }

    fun sendEvent(event: CategoriesScreenEvent) {
        reducer.sendEvent(event)
    }

}