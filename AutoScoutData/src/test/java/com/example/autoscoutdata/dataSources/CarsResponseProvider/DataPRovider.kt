package com.example.autoscoutdata.dataSources.CarsResponseProvider

import com.example.autoscoutdata.models.CarResponse
import com.example.autoscoutdata.models.ImageResponse
import com.example.autoscoutdata.models.SellerResponse
import retrofit2.Response


val carResponseList = Response.success(
    listOf(
        CarResponse(
            id = 1,
            make = "BMW",
            model = "316i",
            price = 13000,
            colour = "White",
            firstRegistration = "01-2000",
            mileage = 25000,
            fuel = "Gasoline",
            images = listOf(
                ImageResponse("https://loremflickr.com/g/320/240/bmw"),
                ImageResponse("https://loremflickr.com/g/640/480/bmw"),
                ImageResponse("https://loremflickr.com/g/1600/1200/bmw")
            ),
            description = "Almost like new. Full service history"
        ),
        CarResponse(
            id = 2,
            make = "Audi",
            model = "A8",
            fuel = "Gasoline",
            modelline = "quattro",
            price = 16000,
            firstRegistration = "02-2008",
            mileage = 0,
            seller = SellerResponse("Private", "+123456789", "München"),
            description = "No description available."
        ),
        CarResponse(
            id = 3,
            make = "Audi",
            model = "A7",
            price = 20000,
            mileage = 0,
            fuel = "Gasoline",
            seller = SellerResponse("Dealer", "+123456789", "Stuttgart"),
            images = listOf(
                ImageResponse("https://loremflickr.com/g/480/640/audi"),
                ImageResponse("https://loremflickr.com/g/1600/1200/audi"),
                ImageResponse("https://loremflickr.com/g/640/480/audi"),
                ImageResponse("https://loremflickr.com/g/640/480/audi"),
                ImageResponse("https://loremflickr.com/g/480/640/audi")
            ),
            description = "Good condition, had an accident two years ago."
        ),
        CarResponse(
            id = 4,
            make = "Ford",
            model = "Mondeo",
            colour = "White",
            price = 5000,
            mileage = 250000,
            fuel = "Diesel",
            seller = SellerResponse("Private", "+123456789", "Rosenheim"),
            images = listOf(
                ImageResponse("https://loremflickr.com/g/480/640/ford"),
                ImageResponse("https://loremflickr.com/g/1200/1600/ford"),
                ImageResponse("https://loremflickr.com/g/640/480/ford"),
                ImageResponse("https://loremflickr.com/g/640/480/ford"),
                ImageResponse("https://loremflickr.com/g/480/640/ford")
            ),
            description = "Engine replaced at 180000km."
        ),
        CarResponse(
            id = 5,
            make = "Porsche",
            model = "911",
            colour = "Brown",
            price = 100000,
            mileage = 4500,
            fuel = "Gasoline",
            seller = SellerResponse("Private", "+123456789", "Köln"),
            images = listOf(
                ImageResponse("https://loremflickr.com/g/480/640/porsche"),
                ImageResponse("https://loremflickr.com/g/1200/1600/porsche"),
                ImageResponse("https://loremflickr.com/g/480/640/porsche")
            ),
            description = "Engine replaced at 180000km."
        )
    )
)