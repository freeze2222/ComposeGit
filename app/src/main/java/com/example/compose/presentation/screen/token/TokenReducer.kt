package com.example.compose.presentation.screen.token

import com.example.compose.domain.usecase.BaseUseCase
import com.example.compose.presentation.screen.base.Reducer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class TokenReducer (
    initial: TokenScreenState,
    val useCase: BaseUseCase<String>,
    val viewModelScope: CoroutineScope
) : Reducer<TokenScreenState, TokenScreenEvent>(initial) {
    override fun reduce(oldState: TokenScreenState, event: TokenScreenEvent) {
        when (event) {
            is TokenScreenEvent.ShowData -> {
                setState(oldState.copy(isLoading = false, data = event.data))
            }

            is TokenScreenEvent.LoadingData -> {
                viewModelScope.launch {
                    setState(oldState.copy(isLoading = true, data = ""))
                    try {
                        useCase.invoke().let { data ->
                            if (data.isNotEmpty()) {
                                sendEvent(TokenScreenEvent.ShowData(data = data))
                            } else {
                                sendEvent(TokenScreenEvent.ShowError(errorMessage = "data is empty"))
                            }
                        }
                    } catch (e: Exception) {
                        sendEvent(TokenScreenEvent.ShowError(errorMessage = e.message ?: "Exception"))
                    }
                }
            }
            is TokenScreenEvent.ShowError -> {
                setState(oldState.copy(isLoading = false, data = "", error = event.errorMessage))
            }
        }
    }
}