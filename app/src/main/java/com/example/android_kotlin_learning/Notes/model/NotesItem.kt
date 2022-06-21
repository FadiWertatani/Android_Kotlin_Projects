package com.example.android_kotlin_learning.Notes.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Notes_item")
data class NotesItem(
    @ColumnInfo(name="item_text") var text:String,
    @ColumnInfo(name ="item_title") var title:String,
) {
    @PrimaryKey(autoGenerate = true) var id:Int? = null;
}