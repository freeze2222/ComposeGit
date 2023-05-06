package com.example.compose.presentation.screen.media

import com.example.compose.domain.usecase.BaseUseCase
import com.example.compose.presentation.screen.base.Reducer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class LinkReducer (
    initial: LinkScreenState,
    val useCase: BaseUseCase<String>,
    val viewModelScope: CoroutineScope
) : Reducer<LinkScreenState, LinkScreenEvent>(initial) {
    override fun reduce(oldState: LinkScreenState, event: LinkScreenEvent) {
        when (event) {
            is LinkScreenEvent.ShowData -> {
                setState(oldState.copy(isLoading = false, data = event.data))
            }

            is LinkScreenEvent.LoadingData -> {
                viewModelScope.launch {
                    setState(oldState.copy(isLoading = true, data = ""))
                    try {
                        useCase.invoke().let { data ->
                            if (data.isNotEmpty()) {
                                sendEvent(LinkScreenEvent.ShowData(data = data))
                            } else {
                                sendEvent(LinkScreenEvent.ShowError(errorMessage = "data is empty"))
                            }
                        }
                    } catch (e: Exception) {
                        sendEvent(LinkScreenEvent.ShowError(errorMessage = e.message ?: "Exception"))
                    }
                }
            }
            is LinkScreenEvent.ShowError -> {
                setState(oldState.copy(isLoading = false, data = "", error = event.errorMessage))
            }
        }
    }
}