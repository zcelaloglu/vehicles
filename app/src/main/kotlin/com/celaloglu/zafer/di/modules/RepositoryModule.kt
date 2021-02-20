package com.celaloglu.zafer.di.modules

import com.celaloglu.zafer.domain.repository.IVehiclesRepository
import com.celaloglu.zafer.repository.VehiclesRepository
import org.koin.dsl.module

val repositoriesModule = module {

    single<IVehiclesRepository> { VehiclesRepository(get()) }

}