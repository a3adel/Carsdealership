package com.example.autoscoutdomain.models

data class Car(
    val id: Int,
    val make: String,
    val model: String,
    val price: Int,
    val firstRegistration: String?=null,
    val mileage: Int,
    val fuel: String,
    val modelline: String? = null,
    val colour: String? = null,
    val seller: Seller ?= null,
    val images: List<Image> = emptyList(),
    val description: String?=null
)