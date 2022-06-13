package com.example.android_kotlin_learning.Notes.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_kotlin_learning.Notes.model.Notes
import com.example.android_kotlin_learning.Notes.utils.NotesAdapter
import com.example.android_kotlin_learning.ToDoApp.model.Todo
import com.example.android_kotlin_learning.databinding.ActivityNewNoteBinding
import com.example.android_kotlin_learning.databinding.ActivityNotesBinding

class NewNoteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewNoteBinding
    private lateinit var binding1 : ActivityNotesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val noteListSingleItem = mutableListOf(Notes("Run"))

        val adapter = NotesAdapter(noteListSingleItem)

        binding.btnAddNewNote.setOnClickListener {
            var newNote = binding.etAddNote.text
            if (newNote.isEmpty()){
                binding.alert.text = "This field should not be empty"
            }else{
                val addNewNote = Notes(newNote.toString())
                noteListSingleItem.add(addNewNote)
                adapter.notifyDataSetChanged()
                val intent = Intent(this, NotesActivity::class.java)
                startActivity(intent)
                intent.putExtra("newNote",newNote)
            }
        }

    }
}