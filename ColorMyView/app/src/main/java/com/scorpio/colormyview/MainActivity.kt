package com.scorpio.colormyview

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

    class MainActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()


    }

        private fun setListeners(){

            val clickableViews: List<View> =
            listOf (boxOneText,
                    boxTwoText,
                    boxThreeText,
                    boxFourText,
                    boxFiveText,
                    constraintLayout,
                    redButton,
                    yellowButton,
                    greenButton)

            for (item in clickableViews){
            item.setOnClickListener{
                makeColored (it)
            }
        }
        }

        private fun  makeColored(view: View){
            when(view.id){

                //Boxes using Color class colors for background
                R.id.boxOneText -> view.setBackgroundColor(Color.DKGRAY)
                R.id.boxTwoText -> view.setBackgroundColor(Color.GRAY)

                //Boxes using provided Android Color Resources for background
                R.id.boxThreeText -> view.setBackgroundResource(android.R.color.holo_green_light)
                R.id.boxFourText -> view.setBackgroundResource(android.R.color.holo_green_dark)
                R.id.boxFiveText -> view.setBackgroundResource(android.R.color.holo_green_light)

                //Boxes using Custom Colors for Background
                R.id.redButton -> boxThreeText.setBackgroundResource(R.color.red)
                R.id.yellowButton -> boxFourText.setBackgroundResource(R.color.yellow)
                R.id.greenButton -> boxFiveText.setBackgroundResource(R.color.green)

                else -> view.setBackgroundColor(Color.LTGRAY)
            }
        }


}