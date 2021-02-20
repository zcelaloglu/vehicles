package com.celaloglu.zafer.repository

import com.celaloglu.zafer.api.ApiService
import com.celaloglu.zafer.di.modules.*
import com.celaloglu.zafer.domain.repository.IVehiclesRepository
import com.celaloglu.zafer.helper.RequestDispatcher
import com.google.common.truth.Truth
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit

class VehicleRepositoryTest {

    private lateinit var mockWebServer: MockWebServer

    private lateinit var apiService: ApiService

    private lateinit var okHttpClient: OkHttpClient

    private lateinit var retrofit: Retrofit

    private lateinit var vehicleRepository: IVehiclesRepository

    @Before
    fun setup() {
        mockWebServer = MockWebServer().apply {
            dispatcher = RequestDispatcher()
            start()
        }

        okHttpClient = provideOkHttpClient()

        retrofit = provideRetrofitForTest(okHttpClient, mockWebServer.url("/")).newBuilder().build()

        apiService = provideService(retrofit)

        vehicleRepository = VehiclesRepository(apiService)
    }

    @Test
    fun `given repository when executed getVehicles() then return list of vehicle results`() {

        runBlocking {
            val results = vehicleRepository.getVehicles()
            results.collect { Truth.assertThat(it).isNotEmpty() }
        }
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

}