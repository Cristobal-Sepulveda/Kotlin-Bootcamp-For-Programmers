package com.scorpio.pensadora

import Classes.Note
import Classes.NoteAdapter
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_card.*

class NotepadListActivity : AppCompatActivity()
{
    /* variables a utilizar */

    var sharedPreference2 = getSharedPreferences("sharedNotes2", Context.MODE_PRIVATE)
    var editor2 = sharedPreference2.edit()


    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    /* variables a utilizar */

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notepadlist)

        /* get data from main activity */
        val intent = intent
        val msg = intent.getStringExtra("msg")
        val msg2= intent.getStringExtra("msg2")
        /* get data from main activity */

        /* passing data to the sharedpreference */
        editor2.putString(msg, msg2)
        editor2.commit()
        /* passing data to the sharedpreference */

        /* creating list of Notes*/
        var notepads = mutableListOf<Note>()
        var a = Note(msg,msg2)
        notepads.add(a)

        /* creating list of Notes*/

        viewManager = LinearLayoutManager(this)
        viewAdapter = NoteAdapter(notepads)

        recyclerView = findViewById<RecyclerView>(R.id.note_list).apply {
            /* use this setting to improve performance if you know that changes*/
            /* in content do not change the layout size of the RecyclerView*/
            setHasFixedSize(true)
            /* use a linear layout manager*/
            layoutManager = viewManager
            /* specify an viewAdapter */
            adapter = viewAdapter

        }

    }

    override fun onBackPressed()
    {
        val intent2 = Intent(this, MainActivity::class.java)
        startActivity(intent2)
        finish()
    }
}