package com.example.autoscout24.home

import com.example.autoscoutdomain.models.Car

sealed class HomeUiState {
    data class Failure(val messageId: Int) : HomeUiState()
    data class Success(val cars: List<Car>) : HomeUiState()

    object Loading : HomeUiState()

    object NoCarsFound : HomeUiState()
}
