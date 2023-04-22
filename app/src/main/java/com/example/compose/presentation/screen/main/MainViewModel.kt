package com.example.compose.presentation.screen.main

import androidx.lifecycle.viewModelScope
import com.example.compose.data.DomainRepositoryImpl
import com.example.compose.domain.usecase.LoadStreamsUseCase
import com.example.compose.domain.usecase.LoadVideosUseCase
import com.example.compose.presentation.screen.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    loadStreamsUseCase: LoadStreamsUseCase,
    loadVideosUseCase: LoadVideosUseCase
) : BaseViewModel<MainScreenState, MainScreenEvent>() {

    private val reducer = MainReducer(
        initial = MainScreenState.initial(),
        useCase =
        if (DomainRepositoryImpl.page == "Streams")
            loadStreamsUseCase
        else
            loadVideosUseCase,
        viewModelScope = viewModelScope
    )

    override val state: StateFlow<MainScreenState>
        get() = reducer.state

    init {
        sendEvent(MainScreenEvent.LoadingData)
    }

    fun sendEvent(event: MainScreenEvent) {
        reducer.sendEvent(event)
    }

}