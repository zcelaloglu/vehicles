package com.celaloglu.zafer.models.entities

data class Vehicle(
    val id: Int,
    val imageUrls: List<String>?,
    val title: String,
    val price: Int,
    val fuelType: String
)