package com.example.android_kotlin_learning.Notes.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_kotlin_learning.Notes.model.Notes
import com.example.android_kotlin_learning.Notes.utils.NotesAdapter
import com.example.android_kotlin_learning.R
import com.example.android_kotlin_learning.ToDoApp.model.Todo
import com.example.android_kotlin_learning.ToDoApp.utils.TodoAdapter
import com.example.android_kotlin_learning.databinding.ActivityNotesBinding

class NotesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNotesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var newNote: String = intent.getStringExtra("newNote").toString()

        val noteListSingleItem = mutableListOf(Notes("Fadi"))

        val adapter = NotesAdapter(noteListSingleItem)

        binding.rvNotes.adapter = adapter
        binding.rvNotes.layoutManager = LinearLayoutManager(this)

        val newNotes = Notes(newNote) //new todoItem

        noteListSingleItem.add(newNotes)
        adapter.notifyDataSetChanged()

        binding.btnAddNote.setOnClickListener {
            val intent = Intent(this, NewNoteActivity::class.java)
            startActivity(intent)
        }

    }
}