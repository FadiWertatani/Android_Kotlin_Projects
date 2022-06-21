package com.example.android_kotlin_learning.Notes.respository

import com.example.android_kotlin_learning.Notes.DB.NotesDB
import com.example.android_kotlin_learning.Notes.model.NotesItem

class NotesRepository(private val db: NotesDB) {

    suspend fun upsert(item: NotesItem) = db.getNotesDAO().upsert(item)

    suspend fun delete(item: NotesItem) = db.getNotesDAO().delete(item)

    fun getAllNotesItem() = db.getNotesDAO().getAllNotesItem()

}