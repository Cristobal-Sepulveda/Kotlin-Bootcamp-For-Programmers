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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val roll_button: Button = findViewById(R.id.roll_button)
        roll_button.setOnClickListener {
            rollDice()
            Toast.makeText(this, "button clicked", Toast.LENGTH_LONG).show()
        }
    }

    private fun rollDice() {

        val randomInt = Random.nextInt(6) + 1
        val diceImage: ImageView = findViewById(R.id.dice_image)
        when (randomInt){
            1 -> diceImage.setImageResource(R.drawable.dice_1)
            1 -> diceImage.setImageResource(R.drawable.dice_1)
            1 -> diceImage.setImageResource(R.drawable.dice_1)
            1 -> diceImage.setImageResource(R.drawable.dice_1)
            1 -> diceImage.setImageResource(R.drawable.dice_1)
            1 -> diceImage.setImageResource(R.drawable.dice_1)
            
        }
    }

}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           