package com.example.autoscoutdomain.useCases

import com.example.autoscoutdomain.repos.CarsRepo
import javax.inject.Inject

class GetAllCarsUseCase @Inject constructor(private val carsRepo: CarsRepo) {
    suspend operator fun invoke() = carsRepo.getCars()
}