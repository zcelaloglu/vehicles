package com.celaloglu.zafer.repository

import com.celaloglu.zafer.api.ApiService
import com.celaloglu.zafer.domain.repository.IVehiclesRepository
import com.celaloglu.zafer.models.entities.Vehicle
import com.celaloglu.zafer.models.response.Image
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class VehiclesRepository(
    private val api: ApiService
) : IVehiclesRepository {

    override suspend fun getVehicles(): Flow<List<Vehicle>> = flow {

        emit(api.getVehicles().map {
            Vehicle(
                id = it.id,
                imageUrls = convertImagesFrom(it.images),
                title = it.make + " " + it.model,
                price = it.price,
                fuelType = it.fuel
            )
        })
    }

    private fun convertImagesFrom(images: List<Image>?): List<String>? {

        if (images.isNullOrEmpty()) return null

        val urls = mutableListOf<String>()

        for (image in images) {
            urls.add(image.url)
        }
        return urls
    }
}