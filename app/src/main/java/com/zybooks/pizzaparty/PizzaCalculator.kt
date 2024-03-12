package com.zybooks.pizzaparty

import kotlin.math.ceil

// Define a constant representing the number of slices in each pizza.
const val SLICES_PER_PIZZA = 8
// Define a class named PizzaCalculator to calculate the number of pizzas needed for a party.
class PizzaCalculator (partySize: Int, var hungerLevel: HungerLevel) {
    // Define a variable for party size with initial setter logic to prevent negative values.
    var partySize = 0
        set(value) {
            field = if (value >= 0) value else 0
        }

    enum class HungerLevel(var numSlices: Int) {
        LIGHT(2), MEDIUM(3), RAVENOUS(4)
    }

    // Define a computed property to calculate the total number of pizzas needed
    val totalPizzas: Int
        get() {
            // Calculate total slices needed, divide by slices per pizza, and round up to get the total number of pizzas.
            return ceil(partySize * hungerLevel.numSlices / SLICES_PER_PIZZA.toDouble()).toInt()
        }

    // Initialize the class by setting the party size.
    init {
        this.partySize = partySize
    }
}