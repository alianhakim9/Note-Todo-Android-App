package id.alian.notesiali.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Layout.JUSTIFICATION_MODE_INTER_WORD
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import id.alian.notesiali.databinding.ActivityDetailNoteBinding
import id.alian.notesiali.model.Note
import id.alian.notesiali.viewmodel.NoteViewModel

class DetailNoteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailNoteBinding

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val note = intent.getSerializableExtra("NOTE") as Note

        binding.tvTitle.text = note.title
        binding.tvContent.text = note.content
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            binding.tvContent.justificationMode = JUSTIFICATION_MODE_INTER_WORD;
        }

        binding.materialToolbar.setNavigationOnClickListener {
            finish()
        }

        binding.ivUpdate.setOnClickListener {
            val updateNoteFragment = UpdateNoteFragment(note,"detail")
            updateNoteFragment.show(supportFragmentManager, "UpdateNoteFragment")
        }
    }

}