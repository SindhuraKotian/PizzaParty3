package com.zybooks.pizzaparty

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.zybooks.pizzaparty.ui.theme.PizzaPartyTheme
import kotlin.math.ceil

/**
 * Number of slices per pizza.
 */
const val SLICES_PER_PIZZA = 8

/**
 * MainActivity is the entry point for the Pizza Party app. It allows users to input the number of attendees,
 * select their hunger level, and calculate the number of pizzas needed.
 */
class MainActivity : ComponentActivity() {

    // Reference to the number of attendees input text field.
    private lateinit var numAttendEditText: EditText

    // Reference to the TextView that displays the number of pizzas needed.
    private lateinit var numPizzasTextView: TextView

    // Reference to the RadioGroup for selecting the hunger level.
    private lateinit var howHungryRadioGroup: RadioGroup


    /**
     * Called when the activity is starting. This is where most initialization should go.
     *
     * If the activity is being re-initialized after previously being shut down,
     * this contains the data it most recently supplied in onSaveInstanceState(Bundle).
     * Otherwise, it is null.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        numAttendEditText = findViewById(R.id.num_attend_edit_text)
        numPizzasTextView = findViewById(R.id.num_pizzas_text_view)
        howHungryRadioGroup = findViewById(R.id.hungry_radio_group)
    }


    /**
     * Called when the user taps the Calculate button. It reads the user input, calculates the number of pizzas,
     * and updates the UI with the result.
     *
     */
    @SuppressLint("SetTextI18n")
    fun calculateClick(view: View) {

        // Get the text that was typed into the EditText
        val numAttendStr = numAttendEditText.text.toString()

        // Convert the text into an integer
        val numAttend = numAttendStr.toInt()

        // Determine how many slices on average each person will eat
        val slicesPerPerson = when (howHungryRadioGroup.checkedRadioButtonId) {
            R.id.light_radio_button -> 2
            R.id.medium_radio_button -> 3
            else -> 4 // Assumes R.id.hungry_radio_button is the 'else' case
        }

        // Calculate and show the number of pizzas needed
        val totalPizzas = ceil(numAttend * slicesPerPerson / SLICES_PER_PIZZA.toDouble()).toInt()
        numPizzasTextView.text = "Total pizzas: $totalPizzas"
    }
}