package com.example.android_kotlin_learning.Notes.UI.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_kotlin_learning.Notes.model.NotesItem
import com.example.android_kotlin_learning.databinding.ItemNotesBinding

class NoteAdapter (var notes:List<NotesItem>, private val ViewModel: NotesViewModel) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    inner class NoteViewHolder(val binding: ItemNotesBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(ItemNotesBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        var currentNote = notes[position]
        holder.binding.TitleNote.text = "${currentNote.title}"
        holder.binding.notesText.text = currentNote.text
        holder.binding.deleteNote.setOnClickListener {
            ViewModel.delete(currentNote)
        }
    }

    override fun getItemCount(): Int {
        return notes.size
    }


}