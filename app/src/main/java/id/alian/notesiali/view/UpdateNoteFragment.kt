package id.alian.notesiali.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import id.alian.notesiali.databinding.FragmentUpdateNoteBinding
import id.alian.notesiali.model.Note
import id.alian.notesiali.viewmodel.NoteViewModel

class UpdateNoteFragment(val note: Note, val status: String?) : BottomSheetDialogFragment() {
    private var _binding: FragmentUpdateNoteBinding? = null
    private lateinit var viewModel: NoteViewModel
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUpdateNoteBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(NoteViewModel::class.java)

        val view = binding.root

        binding.etTitle.setText(note.title)
        binding.etContent.setText(note.content)

        binding.btnUpdate.setOnClickListener {
            val titleUpdate = binding.etTitle.text.toString().trim()
            val contentUpdate = binding.etContent.text.toString().trim()
            val id = note.id
            val noteUpdate = Note(id, titleUpdate, contentUpdate)
            if (titleUpdate.isEmpty()) {
                Toast.makeText(context, "Title Cannot Be Empty", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.updateNote(noteUpdate)
                Toast.makeText(context, "Note Update", Toast.LENGTH_SHORT).show()
                this.dismiss()
                if (status.equals("detail")) {
                    activity?.finish()
                }
            }
        }

        binding.btnCancel.setOnClickListener {
            this.dismiss()
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}