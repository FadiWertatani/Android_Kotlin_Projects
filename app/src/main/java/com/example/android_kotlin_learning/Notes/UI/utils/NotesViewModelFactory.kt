package com.example.android_kotlin_learning.Notes.UI.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android_kotlin_learning.Notes.respository.NotesRepository

class NotesViewModelFactory(private val repository: NotesRepository):ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NotesViewModel(repository) as T
    }

}