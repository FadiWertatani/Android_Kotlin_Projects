package com.example.android_kotlin_learning.Notes.DB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.android_kotlin_learning.Notes.model.NotesItem


@Database(
    entities = [NotesItem::class],
    version = 1
)
abstract class NotesDB : RoomDatabase() {

    abstract fun getNotesDAO(): NotesDAO

    companion object {
        @Volatile
        private var instance: NotesDB? = null
        private val LOCK = Any()
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also {
                instance = it
            }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                NotesDB::class.java,
                "NotesDB.db"
            ).build()
    }

}