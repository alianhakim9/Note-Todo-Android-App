package id.alian.notesiali.view

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import id.alian.notesiali.databinding.FragmentAddNoteBinding
import id.alian.notesiali.model.Note
import id.alian.notesiali.viewmodel.NoteViewModel


class AddNoteFragment : BottomSheetDialogFragment() {
    private var _binding: FragmentAddNoteBinding? = null
    private lateinit var viewModel: NoteViewModel
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddNoteBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(NoteViewModel::class.java)

        val view = binding.root
        binding.btnAdd.setOnClickListener {
            val title = binding.etTitle.text.toString().trim()
            val content = binding.etContent.text.toString().trim()
            val note = Note(0, title, content)
            if (title.isEmpty()) {
                Toast.makeText(context, "Title Can't Be Empty", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.addNote(note)
                binding.etTitle.setText("")
                binding.etContent.setText("")
                Toast.makeText(context, "Successfully Added", Toast.LENGTH_SHORT).show()
                this.dismiss()
            }
        }

        binding.btnCancel.setOnClickListener {
            binding.etTitle.text.clear()
            binding.etContent.text.clear()
            this.dismiss()
        }

        return view
    }

    override fun onCancel(dialog: DialogInterface) {
        super.onCancel(dialog)
        binding.btnCancel.setOnClickListener {
            dialog.dismiss()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}