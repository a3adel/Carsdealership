package com.example.autoscoutdata.models

import com.example.autoscoutdomain.models.Seller
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SellerResponse(
    @Json(name = "type")
    val type: String,
    @Json(name = "phone")
    val phone: String,
    @Json(name = "city")
    val city: String
)
fun SellerResponse.toSeller(): Seller {
    return Seller(
        type = type,
        phone = phone,
        city = city
    )
}
