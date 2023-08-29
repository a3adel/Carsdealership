package com.example.autoscout24.di

import com.example.autoscoutdomain.repos.CarsRepo
import com.example.autoscoutdomain.useCases.FilterCars
import com.example.autoscoutdomain.useCases.GetAllCarsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(ViewModelComponent::class)
object DomainModules {
    @Provides
    @ViewModelScoped
    fun provideGetCarsUseCase(carRepository: CarsRepo): GetAllCarsUseCase {
        return GetAllCarsUseCase(carRepository)
    }

    @Provides
    @ViewModelScoped
    fun provideFilterCarsUseCase(carRepository: CarsRepo): FilterCars {
        return FilterCars(carRepository)
    }

    @Provides
    @ViewModelScoped
    fun provideDispatcher() = Dispatchers.IO
}