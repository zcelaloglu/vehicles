package com.celaloglu.zafer.domain.repository

import com.celaloglu.zafer.models.entities.Vehicle
import kotlinx.coroutines.flow.Flow

interface IVehiclesRepository {
    suspend fun getVehicles(): Flow<List<Vehicle>>
}