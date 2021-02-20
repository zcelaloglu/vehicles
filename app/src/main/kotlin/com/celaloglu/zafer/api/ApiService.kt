package com.celaloglu.zafer.api

import com.celaloglu.zafer.models.response.VehiclesResponseItem
import retrofit2.http.GET

interface ApiService {

    @GET(".")
    suspend fun getVehicles(): List<VehiclesResponseItem>
}