package com.celaloglu.zafer.features.viewstates

import com.celaloglu.zafer.models.entities.Vehicle

class VehicleEntityViewState(private val vehicle: Vehicle) {

    fun getImageUrls() = vehicle.imageUrls
    fun getTitle() = vehicle.title
    fun getPrice() = vehicle.price
    fun getFuelType() = vehicle.fuelType
}