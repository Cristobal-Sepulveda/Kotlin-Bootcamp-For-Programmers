package com.example.helloworld

import android.content.Context
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            /****************************FUENTES PARA LOS COMPLEMENTOS*************************/
                //esta es una forma
                var starWarsFont = Typeface.createFromAsset(assets, "fonts/Starjedi.ttf" )
                textViewHello.typeface = starWarsFont
                textViewWelcome.typeface = starWarsFont
                // esta es otra forma
                editText.typeface = Typeface.createFromAsset(assets, "fonts/Starjedi.ttf")
                // buttonGET.typeface = Typeface.createFromAsset(assets, "fonts/Starjedi.ttf")
                // buttonPUT.typeface = Typeface.createFromAsset(assets, "fonts/Starjedi.ttf")
                // buttonDELETE.typeface = Typeface.createFromAsset(assets, "fonts/Starjedi.ttf")

            /***************************FUENTES PARA LOS COMPLEMENTOS*************************/

    }
}

