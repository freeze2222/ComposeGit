package com.example.compose.presentation.screen.main

import androidx.lifecycle.viewModelScope
import com.example.compose.domain.usecase.LoadMediaUseCase
import com.example.compose.presentation.screen.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    loadNotesUseCase: LoadMediaUseCase
) : BaseViewModel<MainScreenState, MainScreenEvent>() {

    private val reducer = MainReducer(
        initial = MainScreenState.initial(),
        useCase = loadNotesUseCase,
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