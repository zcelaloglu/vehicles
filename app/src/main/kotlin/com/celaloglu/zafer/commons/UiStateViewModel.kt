package com.celaloglu.zafer.commons

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@ExperimentalCoroutinesApi
open class UiStateViewModel : ViewModel() {

    val uiState: StateFlow<UiState>
        get() = _uiState

    protected var _uiState = MutableStateFlow<UiState>(Loading)

    protected val handler = CoroutineExceptionHandler { _, exception ->
        _uiState.value = Error(exception)
    }

}