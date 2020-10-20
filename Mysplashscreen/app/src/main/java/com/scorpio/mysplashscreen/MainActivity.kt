package com.scorpio.mysplashscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        /**  xq hacemos esto,si recordais lo que hicimos en el android manifest, es indicarle
         *  que nuestr activity principal va a tener un nuevo tema, un nuevo tema que es el
         *  encargado de mostrar el splashscreen, el tema que creamos en el video, abajo lo que
         *  hicimos es recordarle al programa que luego del splash screen, use el tema por defecto,
         *  el tema llamado, AppTheme, asi utilizaremos splash screen en el momento que se crea
         *  nuestra app y apptheme en el moment oen que ya se encuentra cargada
         */
        Thread.sleep(2000) /** esto sirve para configurar un tiempo minimo de carga en el
                                      splash screen*/
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
