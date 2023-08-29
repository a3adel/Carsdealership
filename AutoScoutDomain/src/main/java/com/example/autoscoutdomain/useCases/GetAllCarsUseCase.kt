package com.example.autoscoutdomain.useCases

import com.example.autoscoutdomain.repos.CarsRepo

class GetAllCarsUseCase(private val carsRepo: CarsRepo) {
    suspend operator fun invoke() = carsRepo.getCars()
}