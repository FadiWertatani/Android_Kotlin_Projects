package com.example.android_kotlin_learning.PostsApiApp

import android.app.Application
import com.example.android_kotlin_learning.PostsApiApp.DB.PostDB
import com.example.android_kotlin_learning.PostsApiApp.repository.PostRepository

class PostApplication : Application() {
    val database by lazy {
        PostDB.createDatabase(this)
    }

    val postRepository by lazy {
        PostRepository(database.createPostDAO())
    }
}