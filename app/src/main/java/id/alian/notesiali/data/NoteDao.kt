package id.alian.notesiali.data

import androidx.lifecycle.LiveData
import androidx.room.*
import id.alian.notesiali.model.Note

@Dao
interface NoteDao {

    @Query("SELECT * FROM note")
    fun readAllNote(): LiveData<List<Note>>

    @Insert
    fun addNote(note: Note)

    @Update
    fun updateNote(note: Note)

    @Query("DELETE FROM note")
    fun deleteAllNote()

    @Delete
    fun deleteNote(note: Note)

}