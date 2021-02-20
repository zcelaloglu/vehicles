package com.celaloglu.zafer.domain.usecases

import com.celaloglu.zafer.domain.repository.IVehiclesRepository

class VehiclesUseCase(private val iVehiclesRepository: IVehiclesRepository) {

    suspend operator fun invoke() = iVehiclesRepository.getVehicles()
}