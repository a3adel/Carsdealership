package com.example.autoscoutdata.repos

import com.example.autoscoutdata.dataSources.MemoryDataSource
import com.example.autoscoutdata.dataSources.NetworkDataSource
import com.example.autoscoutdomain.models.Car
import com.example.autoscoutdomain.repos.CarsRepo
import javax.inject.Inject

class CarsRepImp @Inject constructor(
    private val networkDataSource: NetworkDataSource,
    private val memoryDataSource: MemoryDataSource
) :
    CarsRepo {
    override suspend fun getCars(): List<Car> {
        if (memoryDataSource.cars.isNullOrEmpty()) {
            memoryDataSource.cars = networkDataSource.getCars()
        }
        return memoryDataSource.cars!!
    }
}