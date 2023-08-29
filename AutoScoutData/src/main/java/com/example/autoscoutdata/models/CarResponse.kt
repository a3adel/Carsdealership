package com.example.autoscoutdata.models

import com.example.autoscoutdomain.models.Car
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CarResponse(
    @Json(name = "id")
    val id: Int,
    @Json(name = "make")
    val make: String,
    @Json(name = "model")
    val model: String,
    @Json(name = "price")
    val price: Int,
    @Json(name = "firstRegistration")
    val firstRegistration: String? = null,
    @Json(name = "mileage")
    val mileage: Int,
    @Json(name = "fuel")
    val fuel: String,
    @Json(name = "moelline")
    val modelline: String? = null,
    @Json(name = "colour")
    val colour: String? = null,
    @Json(name = "seller")
    val seller: SellerResponse? = null,
    @Json(name = "images")
    val images: List<ImageResponse> ?= null,
    @Json(name = "description")
    val description: String? = null
)
fun CarResponse.toCar(): Car {
    return Car(
        id = id,
        make = make,
        model = model,
        price = price,
        firstRegistration = firstRegistration,
        mileage = mileage,
        fuel = fuel,
        modelline = modelline,
        colour = colour,
        seller = seller?.toSeller(),
        images = images?.map { it.toImage() },
        description = description
    )
}