package com.example.android_kotlin_learning.PostsApiApp.DB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.android_kotlin_learning.PostsApiApp.model.PostModel

@Database(
    entities = [PostModel::class],
    version = 1,
)
abstract class PostDB : RoomDatabase() {
    abstract fun createPostDAO() : PostDAO

    companion object{
        @Volatile
        private var INSTANCE: PostDB?=null

        fun createDatabase(context: Context): PostDB {
            return INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PostDB::class.java,
                    "postDB.db",
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}