package com.celaloglu.zafer.di.modules

import com.celaloglu.zafer.features.vehicles.VehiclesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {

    viewModel { VehiclesViewModel(get()) }

}