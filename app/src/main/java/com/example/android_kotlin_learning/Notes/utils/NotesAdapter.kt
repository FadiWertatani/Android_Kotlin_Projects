package com.example.android_kotlin_learning.Notes.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_kotlin_learning.Notes.model.Notes
import com.example.android_kotlin_learning.databinding.ItemNotesBinding

class NotesAdapter(var notes:List<Notes>) : RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {

    inner class NotesViewHolder(var binding: ItemNotesBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        return NotesViewHolder(ItemNotesBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        holder.binding.apply {
            notesText.text = notes[position].text
        }
    }

    override fun getItemCount(): Int {
        return notes.size
    }

}