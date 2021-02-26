package com.celaloglu.zafer.features.viewstates

import com.celaloglu.zafer.models.entities.Vehicle

class VehicleEntityViewState(private val vehicle: Vehicle) {

    fun getImageUrls() = vehicle.imageUrls
    fun getTitle() = vehicle.title
    fun getPrice() = vehicle.price
    fun getFuelType() = vehicle.fuelType

    private fun isImageNotNull() = getImageUrls().isNullOrEmpty().not()

    fun isFirstImageVisible() = isImageNotNull()
    fun isSecondImageVisible() = isImageNotNull() && getImageUrls()?.size!! >= 2
    fun isThirdImageVisible() = isImageNotNull() && getImageUrls()?.size!! >= 3
    fun isFourthImageVisible() = isImageNotNull() && getImageUrls()?.size!! >= 4

    fun isFifthImageVisible() = isImageNotNull() && getImageUrls()?.size!! == 5

    fun firstImageUrl(): String {
        return if (isImageNotNull()) {
            vehicle.imageUrls?.get(0)!!
        } else {
            ""
        }
    }

    fun secondImageUrl(): String {
        return if (vehicle.imageUrls != null && vehicle.imageUrls.size >= 2) {
            vehicle.imageUrls[1]
        } else {
            ""
        }
    }

    fun thirdImageUrl(): String {
        return if (vehicle.imageUrls != null && vehicle.imageUrls.size >= 3) {
            vehicle.imageUrls[2]
        } else {
            ""
        }
    }

    fun fourthImageUrl(): String {
        return if (vehicle.imageUrls != null && vehicle.imageUrls.size >= 4) {
            vehicle.imageUrls[3]
        } else {
            ""
        }
    }

    fun fifthImageUrl(): String {
        return if (vehicle.imageUrls != null && vehicle.imageUrls.size == 5) {
            vehicle.imageUrls[4]
        } else {
            ""
        }
    }

}