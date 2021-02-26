package com.celaloglu.zafer.commons

import com.celaloglu.zafer.models.response.Image

object ImageUtils {

    fun convertImagesFrom(images: List<Image>?): List<String>? {

        if (images.isNullOrEmpty()) return null

        val urls = mutableListOf<String>()

        for (image in images) {
            urls.add(image.url)
        }
        return urls
    }

}
