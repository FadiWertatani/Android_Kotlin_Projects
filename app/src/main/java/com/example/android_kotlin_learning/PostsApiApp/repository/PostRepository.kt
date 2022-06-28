package com.example.android_kotlin_learning.PostsApiApp.repository

import androidx.lifecycle.LiveData
import com.example.android_kotlin_learning.PostsApiApp.DB.PostDAO
import com.example.android_kotlin_learning.PostsApiApp.model.PostModel
import com.example.android_kotlin_learning.PostsApiApp.services.PostNetwork

class PostRepository(private val postDAO: PostDAO) {

    //GETTING LIST FROM LOCAL DB
    var postList: LiveData<List<PostModel>> = postDAO.findAllPosts()

    suspend fun refreshPost(){
        // Getting the list from API
        val postList = PostNetwork.serviceApi.getPosts()

        //SAVE TO THE LOCAL DATABASE
        postDAO.insertAllPosts(postList)
    }
}