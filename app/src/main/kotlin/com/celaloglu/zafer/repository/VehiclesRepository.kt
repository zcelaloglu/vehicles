package com.celaloglu.zafer.repository

import com.celaloglu.zafer.api.ApiService
import com.celaloglu.zafer.commons.ImageUtils
import com.celaloglu.zafer.domain.repository.IVehiclesRepository
import com.celaloglu.zafer.models.entities.Vehicle
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class VehiclesRepository(
    private val api: ApiService
) : IVehiclesRepository {

    override suspend fun getVehicles(): Flow<List<Vehicle>> = flow {

        emit(api.getVehicles().map {
            Vehicle(
                id = it.id,
                imageUrls = ImageUtils.convertImagesFrom(it.images),
                title = it.make + " " + it.model,
                price = it.price,
                fuelType = it.fuel
            )
        })
    }
}