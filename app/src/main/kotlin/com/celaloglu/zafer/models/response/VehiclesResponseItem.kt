package com.celaloglu.zafer.models.response

data class VehiclesResponseItem(
    val id: Int,
    val fuel: String,
    val images: List<Image>?,
    val make: String,
    val model: String,
    val price: Int
)