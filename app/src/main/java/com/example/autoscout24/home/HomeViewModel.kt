package com.example.autoscout24.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.autoscout24.R
import com.example.autoscoutdata.DataErrors.ApiException
import com.example.autoscoutdata.DataErrors.NoNetworkException
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
) : ViewModel() {

    val homeUiState = mutableStateOf<HomeUiState>(HomeUiState.Loading)
    fun getAllCars() = viewModelScope.launch(dispatcher) {
        homeUiState.value = HomeUiState.Loading
        try {
            val result = getAllCarsUseCase.invoke()
            if (result.isEmpty())
                homeUiState.value = HomeUiState.NoCarsFound
            else
                homeUiState.value = HomeUiState.Success(result)
        } catch (exc: NoNetworkException) {
            homeUiState.value = HomeUiState.Failure(R.string.network_error)
        } catch (exc: ApiException) {
            homeUiState.value = HomeUiState.Failure(R.string.api_error)
        } catch (exc: Exception) {
            homeUiState.value = HomeUiState.Failure(R.string.general_error)
        }
    }
}