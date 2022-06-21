package com.example.android_kotlin_learning.Notes.UI.utils

import androidx.lifecycle.ViewModel
import com.example.android_kotlin_learning.Notes.model.NotesItem
import com.example.android_kotlin_learning.Notes.respository.NotesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotesViewModel(private val repository:NotesRepository):ViewModel() {

    fun upsert(item:NotesItem) = CoroutineScope(Dispatchers.IO).launch {
        repository.upsert(item)
    }
    fun delete(item:NotesItem) = CoroutineScope(Dispatchers.IO).launch {
        repository.delete(item)
    }
    fun getAllNotesItem() = repository.getAllNotesItem()

}