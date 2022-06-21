package com.example.android_kotlin_learning.Notes.UI.utils

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_kotlin_learning.Notes.DB.NotesDB
import com.example.android_kotlin_learning.Notes.model.AddNotesDialogListner
import com.example.android_kotlin_learning.Notes.model.NotesItem
import com.example.android_kotlin_learning.Notes.respository.NotesRepository
import com.example.android_kotlin_learning.databinding.ActivityNotes2Binding

class NotesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNotes2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotes2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val database = NotesDB(this)
        val repository = NotesRepository(database as NotesDB)
        val factory = NotesViewModelFactory(repository)
        val viewModel = ViewModelProviders.of(this,factory).get(NotesViewModel::class.java)

        val notesAdapter = NoteAdapter(listOf(),viewModel)
        binding.rvNote.layoutManager = LinearLayoutManager(this)
        binding.rvNote.adapter = notesAdapter

        viewModel.getAllNotesItem().observe(this, Observer {
            notesAdapter.notes = it
            notesAdapter.notifyDataSetChanged() //update list
        })

        binding.btnAddNote.setOnClickListener {
            NotesDialog(
                this,
                object : AddNotesDialogListner {
                    override fun onAddNotesButtonClick(item: NotesItem) {
                        viewModel.upsert(item)
                    }
                }).show()
        }

    }
}


/*import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_kotlin_learning.MyNotes.utils.NotesAdapter
import com.example.android_kotlin_learning.Notes.DB.NotesDB
import com.example.android_kotlin_learning.Notes.model.AddNotesDialogListner
import com.example.android_kotlin_learning.Notes.model.NotesItem
import com.example.android_kotlin_learning.Notes.respository.NotesRepository
import com.example.android_kotlin_learning.ShoppingListApp.UI.utils.ShoppingItemDialog
import com.example.android_kotlin_learning.ShoppingListApp.model.AddDialogListner
import com.example.android_kotlin_learning.ShoppingListApp.model.ShoppingItem
import com.example.android_kotlin_learning.databinding.ActivityNotes2Binding

class NotesActivity : AppCompatActivity() {
    private lateinit var binding:ActivityNotes2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotes2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val database = NotesDB(this)
        val repository = NotesRepository(database as NotesDB)
        val factory = NotesViewModelFactory(repository)
        val viewModel = ViewModelProviders.of(this,factory).get(NotesViewModel::class.java)

        val notesAdapter = NotesAdapter(listOf(),viewModel)
        binding.rvNote.layoutManager = LinearLayoutManager(this)
        binding.rvNote.adapter = notesAdapter

        viewModel.getAllNotesItem().observe(this, Observer {
            notesAdapter.notes = it
            notesAdapter.notifyDataSetChanged() //update list
        })

        binding.btnAddNote.setOnClickListener {
            NotesDialog(
                this,
                object : AddNotesDialogListner {
                    override fun onAddNotesButtonClick(item: NotesItem) {
                        viewModel.upsert(item)
                    }
                }).show()
        }

    }
}*/