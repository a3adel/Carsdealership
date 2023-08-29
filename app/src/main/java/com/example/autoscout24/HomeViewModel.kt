package com.example.autoscout24

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.autoscoutdomain.useCases.FilterCars
import com.example.autoscoutdomain.useCases.GetAllCarsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllCarsUseCase: GetAllCarsUseCase,
    private val filterCars: FilterCars,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
): ViewModel() {
    fun getAllCars() = viewModelScope.launch(dispatcher) {
       val result= getAllCarsUseCase.invoke()
        println(result.size)
    }
}