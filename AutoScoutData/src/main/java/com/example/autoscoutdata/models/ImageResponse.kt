package com.example.autoscoutdata.models

import com.example.autoscoutdomain.models.Image
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ImageResponse(
    @Json(name = "image")
    val url: String){
}
fun ImageResponse.toImage(): Image {
    return Image(
        url = url
    )
}