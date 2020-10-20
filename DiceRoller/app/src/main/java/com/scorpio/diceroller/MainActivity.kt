package com.scorpio.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlin.random.Random

class MainActivity : AppCompatActivity()
{

lateinit var diceImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* variables a utilizar */
        val roll_button: Button = findViewById(R.id.roll_button)
        diceImage = findViewById(R.id.dice_image)
        /* variables a utilizar */

        roll_button.setOnClickListener {
            rollDice()
            Toast.makeText(this, "button clicked", Toast.LENGTH_LONG).show()
        }
    }


    /* FUNCIONES A utilizar en onCreate */

    private fun rollDice()
    {
        val randomInt = Random.nextInt(6) + 1
        val drawableResource = when (randomInt)
        {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
    }
    /* FUNCIONES A utilizar en onCreate */
}