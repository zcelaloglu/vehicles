package com.celaloglu.zafer.di.modules

import com.celaloglu.zafer.domain.usecases.VehiclesUseCase
import org.koin.dsl.module

val useCasesModule = module {
    
    single { VehiclesUseCase(get()) }

}