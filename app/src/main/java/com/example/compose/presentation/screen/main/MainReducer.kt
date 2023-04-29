package com.example.compose.presentation.screen.main

import com.example.compose.domain.model.api_model.Media
import com.example.compose.domain.usecase.BaseUseCase
import com.example.compose.presentation.screen.base.Reducer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainReducer(
    initial: MainScreenState,
    val useCase: BaseUseCase<List<Media>>,
    val viewModelScope: CoroutineScope
) : Reducer<MainScreenState, MainScreenEvent>(initial) {
    override fun reduce(oldState: MainScreenState, event: MainScreenEvent) {
        when (event) {
            is MainScreenEvent.ShowData -> {
                setState(oldState.copy(isLoading = false, data = event.data))
            }

            is MainScreenEvent.LoadingData -> {
                viewModelScope.launch {
                    setState(oldState.copy(isLoading = true, data = emptyList()))
                    try {
                        useCase.invoke().let { data ->
                            if (data.isNotEmpty()) {
                                sendEvent(MainScreenEvent.ShowData(data = data))
                            } else {
                                sendEvent(MainScreenEvent.ShowError(errorMessage = "data is empty"))
                            }
                        }
                    } catch (e: Exception) {
                        sendEvent(MainScreenEvent.ShowError(errorMessage = e.message ?: "Exception"))
                    }
                }
            }
            is MainScreenEvent.UpdateData -> {
                viewModelScope.launch {
                    setState(oldState.copy(isLoading = true, data = emptyList()))
                    try {
                        useCase.invoke().let { data ->
                            if (data.isNotEmpty()) {
                                sendEvent(MainScreenEvent.ShowData(data = data))
                            } else {
                                sendEvent(MainScreenEvent.ShowError(errorMessage = "data is empty"))
                            }
                        }
                    } catch (e: Exception) {
                        sendEvent(MainScreenEvent.ShowError(errorMessage = e.message ?: "Exception"))
                    }
                }
            }
            is MainScreenEvent.ShowError -> {
                setState(oldState.copy(isLoading = false, data = emptyList(), error = event.errorMessage))
            }
        }
    }
}