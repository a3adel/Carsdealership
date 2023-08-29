package com.example.autoscoutdata.models

import com.example.autoscoutdomain.models.Image
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ImageResponse(
    @Json(name = "url")
    val url: String? = null
)

fun ImageResponse.toImage(): Image {
    return Image(
        url = url
    )
}