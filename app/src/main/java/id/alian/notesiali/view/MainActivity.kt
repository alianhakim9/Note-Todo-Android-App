package id.alian.notesiali.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import id.alian.notesiali.R
import id.alian.notesiali.databinding.ActivityMainBinding
import id.alian.notesiali.model.Note
import id.alian.notesiali.view.NoteAdapter.OnItemClickListener
import id.alian.notesiali.view.NoteAdapter.OnLongItemClickListener
import id.alian.notesiali.viewmodel.NoteViewModel

class MainActivity : AppCompatActivity(), OnItemClickListener, OnLongItemClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: NoteViewModel
    private val noteAdapter by lazy {
        NoteAdapter(this, this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(NoteViewModel::class.java)
        setupRecyclerView()

        val addNoteFragment = AddNoteFragment()
        viewModel.readAllNote.observe(this, {
            noteAdapter.setData(it)
        })

        binding.fbAdd.setOnClickListener {
            addNoteFragment.show(supportFragmentManager, "addNoteFragment")
        }

        binding.materialToolbar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.delete -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Delete All Note ?")
                        .setNegativeButton("No") { dialog, _ ->
                            // Respond to negative button press
                            dialog.cancel()
                        }
                        .setPositiveButton("Yes") { _, _ ->
                            viewModel.deleteAllNote()
                            Toast.makeText(this, "Notes Deleted", Toast.LENGTH_SHORT).show()
                        }
                        .show()
                    true
                }
                else -> false
            }
        }

        binding.materialToolbar.setNavigationOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }
    }

    private fun setupRecyclerView() {
        binding.recyclerView.apply {
            this.layoutManager = GridLayoutManager(this@MainActivity, 2)
            this.adapter = noteAdapter
        }
    }

    override fun onItemClick(note: Note) {
        val options = arrayOf("View", "Edit")
        MaterialAlertDialogBuilder(this)
            .setItems(options) { _, which ->
                if (options[which] == "Edit") {
                    val updateNoteFragment = UpdateNoteFragment(note, null)
                    updateNoteFragment.show(supportFragmentManager, "UpdateNoteFragment")
                } else {
                    Intent(this, DetailNoteActivity::class.java).also {
                        it.putExtra("NOTE", note)
                        startActivity(it)
                    }
                }
            }
            .show()
    }

    override fun onLongItemClick(note: Note) {
        val title = note.title
        MaterialAlertDialogBuilder(this)
            .setTitle("Delete $title ?")
            .setNegativeButton("No") { dialog, _ ->
                // Respond to negative button press
                dialog.cancel()
            }
            .setPositiveButton("Yes") { _, _ ->
                viewModel.deleteNote(note)
                Toast.makeText(this, "Notes Deleted", Toast.LENGTH_SHORT).show()
            }
            .show()
    }
}