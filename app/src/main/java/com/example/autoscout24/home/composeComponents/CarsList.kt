package com.example.autoscout24.home.composeComponents

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.example.autoscoutdomain.models.Car

@Composable
fun CarsList(
    cars: List<Car>,
    onCallItemClicked: (phone: String) -> Unit
) {
    LazyColumn {
        for (car in cars)
            item {
                CarItem(
                    car,
                    onCallClicked = onCallItemClicked
                )
            }
    }
}