package com.example.android_kotlin_learning.ShoppingListApp.DB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.android_kotlin_learning.ShoppingListApp.model.ShoppingItem

@Database(
    entities = [ShoppingItem::class],
    version = 1
)
abstract class ShoppingDB : RoomDatabase() {

    abstract fun getShoppingDAO(): ShoppingDAO

    companion object {
        @Volatile
        private var instance: ShoppingDB? = null
        private val LOCK = Any()
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also {
                instance = it
            }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ShoppingDB::class.java,
                "ShoppingDB.db"
            ).build()
    }

}