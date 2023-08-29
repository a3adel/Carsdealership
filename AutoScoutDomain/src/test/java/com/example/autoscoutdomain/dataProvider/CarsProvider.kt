package com.example.autoscoutdomain.dataProvider

import com.example.autoscoutdomain.models.Car
import com.example.autoscoutdomain.models.Image
import com.example.autoscoutdomain.models.Seller

val carList = listOf(
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
    ),
    Car(
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
    ),
    Car(
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
    ),
    Car(
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
    ),
    Car(
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