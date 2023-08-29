package com.example.autoscoutdata.repos

import com.example.autoscoutdata.dataSources.MemoryDataSource
import com.example.autoscoutdata.dataSources.NetworkDataSource
import com.example.autoscoutdomain.models.Car
import com.example.autoscoutdomain.models.Image
import com.example.autoscoutdomain.repos.CarsRepo
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class CarsRepImpTest {
    lateinit var sut: CarsRepo
    lateinit var networkDataSource: NetworkDataSource
    lateinit var memoryDataSource: MemoryDataSource

    @Before
    fun setUp() {
        networkDataSource = mockk()
        memoryDataSource = MemoryDataSource()
        sut = CarsRepImp(networkDataSource, memoryDataSource)
    }

    @Test
    fun `after getting data from networkdata source memory datasource isupdated and car list is returned`() =
        runBlocking {
            assertEquals(memoryDataSource.cars, null)
            val expectedResult = listOf(
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
                )
            )
            coEvery { networkDataSource.getCars() } returns
                    listOf(
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
                        )
                    )

            val result = sut.getCars()
            assertEquals(expectedResult,memoryDataSource.cars)
            assertEquals(expectedResult,result)
        }
}