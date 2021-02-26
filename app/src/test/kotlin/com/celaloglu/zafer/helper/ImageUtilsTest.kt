package com.celaloglu.zafer.helper

import com.celaloglu.zafer.commons.ImageUtils
import com.celaloglu.zafer.models.response.Image
import com.google.common.truth.Truth
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ImageUtilsTest {

    @Test
    fun `given list of null images when convertImagesFrom() executed then return list of image urls`() {

        // Given
        val images = emptyList<Image>()

        // When
        val actualResult = ImageUtils.convertImagesFrom(images)

        // Then
        Truth.assertThat(actualResult).isEqualTo(null)
    }

    @Test
    fun `given list of images when convertImagesFrom() executed then return list of image urls`() {

        // Given
        val images = listOf(Image("https://loremflickr.com/g/320/240/bmw"),
                Image("https://loremflickr.com/g/320/240/bmw"),
                Image("https://loremflickr.com/g/320/240/bmw"))

        // When
        val actualResult = ImageUtils.convertImagesFrom(images)

        // Then
        Truth.assertThat(actualResult).isEqualTo(listOf("https://loremflickr.com/g/320/240/bmw",
                "https://loremflickr.com/g/320/240/bmw", "https://loremflickr.com/g/320/240/bmw"))
    }

}