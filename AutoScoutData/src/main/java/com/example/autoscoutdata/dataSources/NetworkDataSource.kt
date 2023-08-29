package com.example.autoscoutdata.dataSources

import com.example.autoscoutdata.DataErrors.ApiException
import com.example.autoscoutdata.DataErrors.NoNetworkException
import com.example.autoscoutdata.apiServices.CarsApiService
import com.example.autoscoutdata.models.toCar
import com.example.autoscoutdata.utils.ConnectivityService
import com.example.autoscoutdomain.models.Car
import javax.inject.Inject

class NetworkDataSource @Inject constructor(
    private val carsApiService: CarsApiService,
    private val connectivityService: ConnectivityService
) {

    suspend fun getCars(): List<Car> {
        if (connectivityService.checkNetwork()) {
            val response = carsApiService.getCars()
            return if (response.isSuccessful) {
                response.body()?.map { it.toCar() } ?: emptyList()
            } else
                throw ApiException(response.errorBody().toString())
        } else
            throw NoNetworkException("no network available")
    }
}