package com.example.android_kotlin_learning.Notes.UI.utils

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.android_kotlin_learning.Notes.model.AddNotesDialogListner
import com.example.android_kotlin_learning.Notes.model.NotesItem
import com.example.android_kotlin_learning.databinding.DialogNoteBinding

class NotesDialog(context: Context, var addNotesDialogListner: AddNotesDialogListner):AppCompatDialog(context) {

    private lateinit var binding : DialogNoteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DialogNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnADD.setOnClickListener {
            var notesTitle = binding.titleNote.text.toString()
            var notesText = binding.editTextNote.text.toString()

            if (notesText.isEmpty() || notesTitle.isEmpty()){
                Toast.makeText(context,"Please enter Notes and Title", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }else{
                var note = NotesItem(notesText,notesTitle)
                addNotesDialogListner.onAddNotesButtonClick(note)
                dismiss()
            }
        }
        binding.btnCancel.setOnClickListener {
            cancel()
        }

    }
}