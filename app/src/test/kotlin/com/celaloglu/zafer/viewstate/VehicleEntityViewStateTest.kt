package com.celaloglu.zafer.viewstate

import com.celaloglu.zafer.features.viewstates.VehicleEntityViewState
import com.celaloglu.zafer.models.entities.Vehicle
import com.google.common.truth.Truth
import org.junit.Test

class VehicleEntityViewStateTest {

    @Test
    fun `should match title for given vehicle`() {

        // Given
        val vehicle = createDummyVehicle()
        val givenViewState = VehicleEntityViewState(vehicle)

        // When
        val actualResult = givenViewState.getTitle()

        // Then
        Truth.assertThat(actualResult).isEqualTo("BMW 316i")
    }

    @Test
    fun `should match image urls for given vehicle`() {

        // Given
        val vehicle = createDummyVehicle()
        val givenViewState = VehicleEntityViewState(vehicle)

        // When
        val actualResult = givenViewState.getImageUrls()

        // Then
        Truth.assertThat(actualResult).isEqualTo(
            listOf(
                "https://loremflickr.com/g/320/240/bmw",
                "https://loremflickr.com/g/640/480/bmw",
                "https://loremflickr.com/g/1600/1200/bmw"
            )
        )
    }

    @Test
    fun `should match fuel type for given vehicle`() {

        // Given
        val vehicle = createDummyVehicle()
        val givenViewState = VehicleEntityViewState(vehicle)

        // When
        val actualResult = givenViewState.getFuelType()

        // Then
        Truth.assertThat(actualResult).isEqualTo("Gasoline")
    }

    @Test
    fun `should match price for given vehicle`() {

        // Given
        val vehicle = createDummyVehicle()
        val givenViewState = VehicleEntityViewState(vehicle)

        // When
        val actualResult = givenViewState.getPrice()

        // Then
        Truth.assertThat(actualResult).isEqualTo(13000)
    }

    private fun createDummyVehicle(): Vehicle {
        return Vehicle(
            id = 1,
            imageUrls = listOf(
                "https://loremflickr.com/g/320/240/bmw",
                "https://loremflickr.com/g/640/480/bmw",
                "https://loremflickr.com/g/1600/1200/bmw"
            ),
            title = "BMW 316i",
            price = 13000,
            fuelType = "Gasoline"
        )
    }
}