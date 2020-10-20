package com.scorpio.pensadora

import Classes.Note
import Classes.NoteAdapter
import android.app.ActivityManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_notepadlist.*
import kotlinx.android.synthetic.main.layout_card.*

class NotepadListActivity : AppCompatActivity()
{
    /* variables a utilizar */

    /* variables a utilizar */

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notepadlist)

        val notepads= listOf(
            Note(topic = notepad_topic.text, body = notepad_body.text)
        )
        note_list.layoutManager = LinearLayoutManager(this)
        note_list.adapter = NoteAdapter (notepads)
    }

    override fun onBackPressed()
    {
        val intent2 = Intent(this, MainActivity::class.java)
        startActivity(intent2)
        finish()
    }
}