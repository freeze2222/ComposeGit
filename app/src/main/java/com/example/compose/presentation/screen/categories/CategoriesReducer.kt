package com.example.compose.presentation.screen.categories

import com.example.compose.domain.usecase.CategoriesUseCase
import com.example.compose.presentation.screen.base.Reducer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class CategoriesReducer(
    initial: CategoriesScreenState,
    val useCase: CategoriesUseCase,
    val viewModelScope: CoroutineScope
) : Reducer<CategoriesScreenState, CategoriesScreenEvent>(initial) {
    override fun reduce(oldState: CategoriesScreenState, event: CategoriesScreenEvent) {
        when (event) {
            is CategoriesScreenEvent.ShowData -> {
                setState(oldState.copy(isLoading = false, data = event.data))
            }

            is CategoriesScreenEvent.LoadingData -> {
                viewModelScope.launch {
                    setState(oldState.copy(isLoading = true, data = mutableListOf()))
                    try {
                        useCase.invoke().let { data ->
                            if (data.isNotEmpty()) {
                                sendEvent(CategoriesScreenEvent.ShowData(data = data))
                            } else {
                                sendEvent(CategoriesScreenEvent.ShowError(errorMessage = "data is empty"))
                            }
                        }
                    } catch (e: Exception) {
                        sendEvent(CategoriesScreenEvent.ShowError(errorMessage = e.message ?: "Exception"))
                    }
                }
            }
            is CategoriesScreenEvent.ShowError -> {
                setState(oldState.copy(isLoading = false, data = mutableListOf(), error = event.errorMessage))
            }
        }
    }
}