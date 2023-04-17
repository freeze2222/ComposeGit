package com.example.compose.presentation.screen.token

import androidx.lifecycle.viewModelScope
import com.example.compose.domain.usecase.LoadAccessTokenUseCase
import com.example.compose.presentation.screen.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class TokenViewModel@Inject constructor(
    loadAccessTokenUseCase: LoadAccessTokenUseCase,
) : BaseViewModel<TokenScreenState, TokenScreenEvent>() {

    private val reducer = TokenReducer(
        initial = TokenScreenState.initial(),
        useCase = loadAccessTokenUseCase,
        viewModelScope = viewModelScope
    )

    override val state: StateFlow<TokenScreenState>
        get() = reducer.state

    init {
        sendEvent(TokenScreenEvent.LoadingData)
    }

    fun sendEvent(event: TokenScreenEvent) {
        reducer.sendEvent(event)
    }

}