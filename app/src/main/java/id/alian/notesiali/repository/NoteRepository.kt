package id.alian.notesiali.repository

import androidx.lifecycle.LiveData
import id.alian.notesiali.data.NoteDao
import id.alian.notesiali.model.Note

class NoteRepository(private val noteDao: NoteDao) {
    val readAllNote: LiveData<List<Note>> = noteDao.readAllNote()

    fun addNote(note: Note) { noteDao.addNote(note) }

    fun updateNote(note: Note) { noteDao.updateNote(note) }

    fun deleteAllNote() { noteDao.deleteAllNote() }

    fun deleteNote(note: Note) { noteDao.deleteNote(note) }
}