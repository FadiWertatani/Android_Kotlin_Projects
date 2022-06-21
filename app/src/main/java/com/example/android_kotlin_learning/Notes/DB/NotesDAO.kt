package com.example.android_kotlin_learning.Notes.DB

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.android_kotlin_learning.Notes.model.NotesItem

@Dao
interface NotesDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(item:NotesItem)

    @Delete
    fun delete(item: NotesItem)

    @Query("Select * FROM Notes_item")
    fun getAllNotesItem(): LiveData<List<NotesItem>>
}