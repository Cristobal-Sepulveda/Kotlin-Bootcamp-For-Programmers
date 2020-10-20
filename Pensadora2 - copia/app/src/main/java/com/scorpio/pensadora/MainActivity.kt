package com.scorpio.pensadora

import Classes.Note
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_translate.*
import android.view.View
import android.content.SharedPreferences
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity()
{

    /* Variables a Utilizar */

    var sharedPreference = getSharedPreferences("sharedNotes", Context.MODE_PRIVATE)
    var editor = sharedPreference.edit()

    /* Variables a Utilizar */

    override fun onCreate(savedInstanceState: Bundle?)
    {
        setTheme(R.style.SplashTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* AlertDialog's */

        var alertMain = AlertDialog.Builder(this) /* aqui lo creo */
        alertMain.setTitle("Wrong Command")
        alertMain.setMessage("You can see the list of commands whit the button Commands below or cli" +
                "king the button OK, if you dont want to see the command list right know, click ON CANCEL")
        alertMain.setPositiveButton("OK", null)
        alertMain.setNegativeButton("CANCEL", null)

        var alertNewNote = AlertDialog.Builder(this) /* aqui lo creo */
        alertNewNote.setTitle("Tinker")
        alertNewNote.setMessage("Nota Creada")
        alertNewNote.setPositiveButton("Ok",null)
        /* AlertDialog's */

        /* como pasar de una activity a otra*/
        /**val intent = Intent(this, TranslateActivity::class.java)
        startActivity(intent)*/

        /* Botones */
            /* Boton Send*/
            buttonSend.setOnClickListener {
                val editTxt = findViewById<EditText>(R.id.editText)
                val msg = editTxt.text.toString()
                val msg2 = msg.split(" ")

                if(msg2[0] == "translate" || msg2[0] == "traducir"){

                    val intent = Intent(this, TranslateActivity::class.java)
                    intent.putExtra("msg", msg2[1])
                    startActivity(intent)
                    finish()

                }else if(msg2[0] == "synonymous" || msg2[0] == "sinonimo") {

                    val intent = Intent(this, SynonymousActivity::class.java)
                    intent.putExtra("msg", msg2[2])
                    startActivity(intent)
                    finish()
                }else if(msg2[0] == "note" || msg2[0] == "nota"){
                    val a = msg2[1]
                    msg2[0] == ""
                    msg2[1] == ""
                    msg2.forEach {
                        editor.putString(a,it)
                        editor.commit()
                    }
                    alertNewNote.show()
                }else{
                    alertMain.show()
                }
            }
            /*Boton Notepad*/
            /** buttonNotepad.setOnClickListener {
                val intent = Intent(this, NotepadListActivity::class.java)
                startActivity(intent)
                finish()
            }*/
            /*Boton ShowNotepads*/
            buttonShowNotepads.setOnClickListener {
                val intent = Intent(this, NotepadListActivity::class.java)
                startActivity(intent)
                finish()
            }
            /*boton Commads*/

        /* Botones */

    }

    override fun onBackPressed() {
        super.onBackPressed()
    }


}

















