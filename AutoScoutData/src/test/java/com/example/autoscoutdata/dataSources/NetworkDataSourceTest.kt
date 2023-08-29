package com.example.autoscoutdata.dataSources

import com.example.autoscoutdata.DataErrors.ApiException
import com.example.autoscoutdata.DataErrors.NoNetworkException
import com.example.autoscoutdata.apiServices.CarsApiService
import com.example.autoscoutdata.dataSources.CarsResponseProvider.carResponseList
import com.example.autoscoutdata.utils.ConnectivityService
import com.example.autoscoutdomain.models.Car
import com.example.autoscoutdomain.models.Image
import com.example.autoscoutdomain.models.Seller
import io.mockk.called
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.ResponseBody
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import retrofit2.Response

class NetworkDataSourceTest {
    lateinit var connectivityService: ConnectivityService
    lateinit var carsApiService: CarsApiService
    lateinit var sut: NetworkDataSource

    @Before
    fun setUp() {
        connectivityService = mockk()
        carsApiService = mockk()
        sut = NetworkDataSource(carsApiService, connectivityService)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `get cars returns cars from network if there is network`() = runTest {
        val excpectedResult = listOf(
            Car(
                id = 1,
                make = "BMW",
                model = "316i",
                price = 13000,
                colour = "White",
                firstRegistration = "01-2000",
                mileage = 25000,
                fuel = "Gasoline",
                images = listOf(
                    Image("https://loremflickr.com/g/320/240/bmw"),
                    Image("https://loremflickr.com/g/640/480/bmw"),
                    Image("https://loremflickr.com/g/1600/1200/bmw")
                ),
                description = "Almost like new. Full service history"
            ), Car(
                id = 2,
                make = "Audi",
                model = "A8",
                fuel = "Gasoline",
                modelline = "quattro",
                price = 16000,
                firstRegistration = "02-2008",
                mileage = 0,
                seller = Seller("Private", "+123456789", "München"),
                description = "No description available."
            ), Car(
                id = 3,
                make = "Audi",
                model = "A7",
                price = 20000,
                mileage = 0,
                fuel = "Gasoline",
                seller = Seller("Dealer", "+123456789", "Stuttgart"),
                images = listOf(
                    Image("https://loremflickr.com/g/480/640/audi"),
                    Image("https://loremflickr.com/g/1600/1200/audi"),
                    Image("https://loremflickr.com/g/640/480/audi"),
                    Image("https://loremflickr.com/g/640/480/audi"),
                    Image("https://loremflickr.com/g/480/640/audi")
                ),
                description = "Good condition, had an accident two years ago."
            ), Car(
                id = 4,
                make = "Ford",
                model = "Mondeo",
                colour = "White",
                price = 5000,
                mileage = 250000,
                fuel = "Diesel",
                seller = Seller("Private", "+123456789", "Rosenheim"),
                images = listOf(
                    Image("https://loremflickr.com/g/480/640/ford"),
                    Image("https://loremflickr.com/g/1200/1600/ford"),
                    Image("https://loremflickr.com/g/640/480/ford"),
                    Image("https://loremflickr.com/g/640/480/ford"),
                    Image("https://loremflickr.com/g/480/640/ford")
                ),
                description = "Engine replaced at 180000km."
            ), Car(
                id = 5,
                make = "Porsche",
                model = "911",
                colour = "Brown",
                price = 100000,
                mileage = 4500,
                fuel = "Gasoline",
                seller = Seller("Private", "+123456789", "Köln"),
                images = listOf(
                    Image("https://loremflickr.com/g/480/640/porsche"),
                    Image("https://loremflickr.com/g/1200/1600/porsche"),
                    Image("https://loremflickr.com/g/480/640/porsche")
                ),
                description = "Engine replaced at 180000km."
            )
        )

        coEvery { connectivityService.checkNetwork() } returns true
        coEvery { carsApiService.getCars() } returns carResponseList
        val result = sut.getCars()
        assertEquals(excpectedResult, result)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `get cars returns emptylist from network if there is network if result is null`() =
        runTest {
            val excpectedResult = listOf<Car>()

            coEvery { connectivityService.checkNetwork() } returns true
            coEvery { carsApiService.getCars() } returns Response.success(null)
            val result = sut.getCars()
            assertEquals(excpectedResult, result)
        }


    @OptIn(ExperimentalCoroutinesApi::class)
    @Test(expected = NoNetworkException::class)
    fun `get cars throws network exception if there is no network`() = runTest {

        coEvery { connectivityService.checkNetwork() } returns false
        coVerify { carsApiService.getCars() wasNot called }
        sut.getCars()
    }


    @OptIn(ExperimentalCoroutinesApi::class)
    @Test(expected = ApiException::class)
    fun `get cars throws API exception if there is no network if response returned error`() =
        runTest {

            coEvery { connectivityService.checkNetwork() } returns true
            coEvery { carsApiService.getCars()  } returns Response.error(
                404, ResponseBody.create(null,"")
            )
           sut.getCars()
        }
}