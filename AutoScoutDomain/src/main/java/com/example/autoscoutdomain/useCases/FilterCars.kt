package com.example.autoscoutdomain.useCases

import com.example.autoscoutdomain.models.Car
import com.example.autoscoutdomain.repos.CarsRepo

class FilterCars(private val carsRepo: CarsRepo) {
    suspend operator fun invoke(filterCriteria: Map<String, List<String>>): List<Car> {

      return  carsRepo.getCars().filter { car ->
            filterCriteria.all { (key, values) ->
                when (key) {
                    "make" -> values.any { car.make.equals(it, ignoreCase = true) }
                    "fuel" -> values.any { car.fuel.equals(it, ignoreCase = true) }
                    "colour" -> values.any { car.colour.equals(it, ignoreCase = true) }
                    "hasImages" -> car.images.isNotEmpty()
                    else -> false

                }

            }

        }
    }
}