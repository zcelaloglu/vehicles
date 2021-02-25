package com.celaloglu.zafer.features.vehicles

import androidx.lifecycle.viewModelScope
import com.celaloglu.zafer.commons.Loading
import com.celaloglu.zafer.commons.Success
import com.celaloglu.zafer.commons.UiStateViewModel
import com.celaloglu.zafer.domain.usecases.VehiclesUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class VehiclesViewModel(
    private val vehiclesUseCase: VehiclesUseCase
) : UiStateViewModel() {

    fun getVehicles() {
        _uiState.value = Loading
        viewModelScope.launch(handler) {
            vehiclesUseCase.invoke().collect { results ->
                _uiState.value = Success(results)
            }
        }
    }
}
