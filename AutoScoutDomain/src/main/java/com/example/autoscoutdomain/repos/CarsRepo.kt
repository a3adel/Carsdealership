package com.example.autoscoutdomain.repos

import com.example.autoscoutdomain.models.Car

interface CarsRepo {

    suspend fun getCars():List<Car>
}