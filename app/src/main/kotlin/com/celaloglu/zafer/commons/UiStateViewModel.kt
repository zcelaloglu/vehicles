package com.celaloglu.zafer.commons

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineExceptionHandler

open class UiStateViewModel : ViewModel() {

    val uiState: LiveData<UiState>
        get() = _uiState

    protected var _uiState = MutableLiveData<UiState>()

    protected val handler = CoroutineExceptionHandler { _, exception ->
        _uiState.value = Error(exception)
    }

}