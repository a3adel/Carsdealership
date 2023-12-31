package com.example.autoscoutdata.apiServices

import com.example.autoscoutdata.models.CarResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface CarsApiService {
 @GET(".")
    suspend fun getCars(): Response<List<CarResponse>>
}