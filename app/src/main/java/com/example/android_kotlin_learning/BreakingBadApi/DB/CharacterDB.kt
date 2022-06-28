package com.example.android_kotlin_learning.BreakingBadApi.DB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.android_kotlin_learning.BreakingBadApi.model.BreakingBadCharacter

@Database(
    entities = [BreakingBadCharacter::class],
    version = 1,
)
@TypeConverters(AppTypeConverters::class)
abstract class CharacterDB : RoomDatabase() {
    abstract fun createCharacterDAO() : CharacterDAO

    companion object{
        @Volatile
        private var INSTANCE:CharacterDB?=null

        fun createDatabase(context: Context):CharacterDB{
            return INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CharacterDB::class.java,
                    "breakingBadDB.db",
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }

}