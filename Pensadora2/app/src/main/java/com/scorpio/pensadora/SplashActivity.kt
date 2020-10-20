package com.scorpio.pensadora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.lang.Exception

class SplashActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        setTheme(R.style.SplashTheme)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

            val background = object : Thread()
            {
                override fun run ()
                {
                    try
                    {
                        Thread.sleep(500)
                        val intent = Intent(baseContext, MainActivity::class.java)
                        startActivity(intent)
                    }
                    catch(e: Exception)
                    {
                        e.printStackTrace()
                    }
                }
            }

        background.start()
    }
}