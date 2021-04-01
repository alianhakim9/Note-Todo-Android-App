package id.alian.notesiali.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.alian.notesiali.databinding.ItemNoteBinding
import id.alian.notesiali.model.Note

class NoteAdapter(
    private val itemClick: OnItemClickListener,
    private val longItemClick: OnLongItemClickListener
) :
    RecyclerView.Adapter<NoteAdapter.MyViewHolder>() {

    private var noteList = emptyList<Note>()

    class MyViewHolder(val binding: ItemNoteBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemNoteBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.tvTitle.text = noteList[position].title
        holder.binding.tvContent.text = noteList[position].content

        val note = Note(noteList[position].id, noteList[position].title, noteList[position].content)
        holder.binding.root.setOnClickListener {
            itemClick.onItemClick(note)
        }
        holder.binding.root.setOnLongClickListener {
            longItemClick.onLongItemClick(note)
            true
        }
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    fun setData(note: List<Note>) {
        this.noteList = note
        notifyDataSetChanged()
    }

    interface OnItemClickListener {
        fun onItemClick(note: Note)
    }

    interface OnLongItemClickListener {
        fun onLongItemClick(note: Note)
    }
}