package com.example.autoscoutdomain.useCases

import com.example.autoscoutdomain.dataProvider.carList
import com.example.autoscoutdomain.repos.CarsRepo
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test


class GetAllCarsUseCaseTest {
    @Test
    fun `test getCarListUseCase`() = runBlockingTest {
        // Mocking dependencies using MockK
        val carRepository: CarsRepo = mockk()
        val getCarListUseCase = GetAllCarsUseCase(carRepository)

        // Mock repository response using coEvery
        coEvery { carRepository.getCars() } returns carList

        // Execute the use case
        val result = getCarListUseCase.invoke()

        // Assert the result
        assertEquals(carList, result)
    }
}