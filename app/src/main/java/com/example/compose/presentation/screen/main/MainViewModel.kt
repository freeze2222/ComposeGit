package com.example.compose.presentation.screen.main

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.compose.data.DomainRepositoryImpl
import com.example.compose.domain.usecase.LoadStreamsUseCase
import com.example.compose.domain.usecase.LoadVideosUseCase
import com.example.compose.presentation.screen.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
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
    fun updateData(query:String){
        sendEvent(MainScreenEvent.LoadingData)
        Log.e("DEBUG","Query: $query")
        DomainRepositoryImpl.query = query
        reducer.viewModelScope.launch {
            reducer.useCase.invoke()
        }

        //reducer.sendEvent(MainScreenEvent.UpdateData)

    }
    fun sendEvent(event: MainScreenEvent) {
        reducer.sendEvent(event)
    }

}