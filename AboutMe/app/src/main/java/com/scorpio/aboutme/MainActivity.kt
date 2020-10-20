package com.scorpio.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.scorpio.aboutme.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var myName:MyName= MyName()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        //findViewById<Button>(R.id.done_button).setOnClickListener{
        //    addNickName(it)
        //}
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        myName= MyName("Cristl Sepúlveda")
        binding.myName = myName
        binding.doneButton.setOnClickListener{
            addNickName(it )
        }

    }

    private fun addNickName(view: View){

        /*first option */

        binding.apply{
            /* in order to refresh the UI with the new data we need to invalidate all binding*/
            /* expression so that they get recreated with the correct data*/
            /*                                     */
            myName?.nickname= nicknameEdit.text.toString()
            nicknameText.text = nicknameEdit.text
            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE

        }

        /*first option */

        /*second option */
        //val editTextView= findViewById<EditText>(R.id.nickname_edit)
        //val nickNameTextView= findViewById<TextView>(R.id.nickname_text)

        //nickNameTextView.text = editTextView.text
        //editTextView.visibility = View.GONE
        //view.visibility = View.GONE
        //nickNameTextView.visibility = View.VISIBLE
        /*second option */
    }
}