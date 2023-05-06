package com.example.compose.presentation.screen.media

import androidx.lifecycle.viewModelScope
import com.example.compose.domain.usecase.LoadM3U8UseCase
import com.example.compose.presentation.screen.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class LinkViewModel@Inject constructor(
    loadM3U8UseCase: LoadM3U8UseCase,
) : BaseViewModel<LinkScreenState, LinkScreenEvent>() {

    private val reducer = LinkReducer(
        initial = LinkScreenState.initial(),
        useCase = loadM3U8UseCase,
        viewModelScope = viewModelScope
    )

    override val state: StateFlow<LinkScreenState>
        get() = reducer.state

    init {
        sendEvent(LinkScreenEvent.LoadingData)
    }

    fun sendEvent(event: LinkScreenEvent) {
        reducer.sendEvent(event)
    }

}