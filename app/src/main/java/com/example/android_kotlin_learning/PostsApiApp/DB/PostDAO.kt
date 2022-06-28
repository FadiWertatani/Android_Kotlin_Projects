package com.example.android_kotlin_learning.PostsApiApp.DB

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.android_kotlin_learning.PostsApiApp.model.PostModel


@Dao
interface PostDAO {
    @Query("SELECT * FROM post")
    fun findAllPosts(): LiveData<List<PostModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllPosts(postListList : List<PostModel>)
}