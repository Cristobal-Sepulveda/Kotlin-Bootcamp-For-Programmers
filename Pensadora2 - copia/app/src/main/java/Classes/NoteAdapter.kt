package Classes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.scorpio.pensadora.R
import kotlinx.android.synthetic.main.layout_card.view.*

class NoteAdapter(var notepads: MutableList<Note>) :
        RecyclerView.Adapter<NoteAdapter.notecardViewHolder>()
{

    /*CLASES*/
    /* clase que recolecta los cardView*/

    class notecardViewHolder(var view: CardView): RecyclerView.ViewHolder(view)

    /* FUNCIONES */

    /*Esta funcion crea el cardFolder */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): notecardViewHolder {

        val notecard= LayoutInflater.from(parent.context).
        inflate(R.layout.layout_card , parent, false) as CardView
        //set the view's size, margin, paddings and layout parameters
        return notecardViewHolder(notecard)
    }

    /*Esta funcion retorna el size de nuestra lista */
    override fun getItemCount() = notepads.size

    /* Esta enlaza la data actual que queremos desplegar */
    override fun onBindViewHolder(viewHolder: notecardViewHolder, position: Int) {
        val note= notepads[position]
        viewHolder.view.card.notepad_topic.text = note.topic
        viewHolder.view.card.notepad_body.text = note.body
    }
}