package com.celaloglu.zafer.viewstate

import com.celaloglu.zafer.features.viewstates.VehicleEntityViewState
import com.celaloglu.zafer.models.entities.Vehicle
import com.google.common.truth.Truth
import org.junit.Test

class VehicleEntityViewStateTest {

    private val vehicle by lazy {
        Vehicle(
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

    @Test
    fun `should match title for given vehicle`() {

        // Given
        val givenViewState = VehicleEntityViewState(vehicle)

        // When
        val actualResult = givenViewState.getTitle()

        // Then
        Truth.assertThat(actualResult).isEqualTo("BMW 316i")
    }

    @Test
    fun `should match image urls for given vehicle`() {

        // Given
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
        val givenViewState = VehicleEntityViewState(vehicle)

        // When
        val actualResult = givenViewState.getFuelType()

        // Then
        Truth.assertThat(actualResult).isEqualTo("Gasoline")
    }

    @Test
    fun `should match price for given vehicle`() {

        // Given
        val givenViewState = VehicleEntityViewState(vehicle)

        // When
        val actualResult = givenViewState.getPrice()

        // Then
        Truth.assertThat(actualResult).isEqualTo(13000)
    }

    @Test
    fun `should match first image url for given vehicle`() {

        // Given
        val givenViewState = VehicleEntityViewState(vehicle)

        // When
        val actualResult = givenViewState.firstImageUrl()

        // Then
        Truth.assertThat(actualResult).isEqualTo("https://loremflickr.com/g/320/240/bmw")
    }

    @Test
    fun `should match second image url for given vehicle`() {

        // Given
        val givenViewState = VehicleEntityViewState(vehicle)

        // When
        val actualResult = givenViewState.secondImageUrl()

        // Then
        Truth.assertThat(actualResult).isEqualTo("https://loremflickr.com/g/640/480/bmw")
    }

    @Test
    fun `should match third image url for given vehicle`() {

        // Given
        val givenViewState = VehicleEntityViewState(vehicle)

        // When
        val actualResult = givenViewState.thirdImageUrl()

        // Then
        Truth.assertThat(actualResult).isEqualTo("https://loremflickr.com/g/1600/1200/bmw")
    }

    @Test
    fun `should match fourth image url for given vehicle`() {

        // Given
        val givenViewState = VehicleEntityViewState(vehicle)

        // When
        val actualResult = givenViewState.fourthImageUrl()

        // Then
        Truth.assertThat(actualResult).isEqualTo("")
    }

    @Test
    fun `should match fifth image url for given vehicle`() {

        // Given
        val givenViewState = VehicleEntityViewState(vehicle)

        // When
        val actualResult = givenViewState.fifthImageUrl()

        // Then
        Truth.assertThat(actualResult).isEqualTo("")
    }

    @Test
    fun `should match first image visibility for given vehicle`() {

        // Given
        val givenViewState = VehicleEntityViewState(vehicle)

        // When
        val actualResult = givenViewState.isFirstImageVisible()

        // Then
        Truth.assertThat(actualResult).isEqualTo(true)
    }

    @Test
    fun `should match second image visibility for given vehicle`() {

        // Given
        val givenViewState = VehicleEntityViewState(vehicle)

        // When
        val actualResult = givenViewState.isSecondImageVisible()

        // Then
        Truth.assertThat(actualResult).isEqualTo(true)
    }

    @Test
    fun `should match third image visibility for given vehicle`() {

        // Given
        val givenViewState = VehicleEntityViewState(vehicle)

        // When
        val actualResult = givenViewState.isThirdImageVisible()

        // Then
        Truth.assertThat(actualResult).isEqualTo(true)
    }

    @Test
    fun `should match fourth image visibility for given vehicle`() {

        // Given
        val givenViewState = VehicleEntityViewState(vehicle)

        // When
        val actualResult = givenViewState.isFourthImageVisible()

        // Then
        Truth.assertThat(actualResult).isEqualTo(false)
    }

    @Test
    fun `should match fifth image visibility for given vehicle`() {

        // Given
        val givenViewState = VehicleEntityViewState(vehicle)

        // When
        val actualResult = givenViewState.isFifthImageVisible()

        // Then
        Truth.assertThat(actualResult).isEqualTo(false)
    }

}