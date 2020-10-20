package Classes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.scorpio.pensadora.R
import kotlinx.android.synthetic.main.layout_card.view.*

class NoteAdapter (val notepads: List<Note>) : RecyclerView.Adapter<NoteAdapter.notecardViewHolder>()
{
    /*Esta funcion crea el cardFolder */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): notecardViewHolder {
        return notecardViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_card , parent, false))
    }
    /*Esta funcion retorna el size de nuestra lista */
    override fun getItemCount() = notepads.size
    /* Esta enlaza la data actual que queremos desplegar */
    override fun onBindViewHolder(holder: notecardViewHolder, position: Int) {
        val note= notepads[position]
        holder.view.notepad_topic.text = note.topic
        holder.view.notepad_body.text= note.body
        // holder.view.note.visibility = if (note.isNew) View.VISIBLE else View.INVISIBLE
    }

    /* clase que recolecta los cardView*/
    class notecardViewHolder(val view: View): RecyclerView.ViewHolder(view)

}