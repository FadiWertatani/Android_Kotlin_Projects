package com.example.android_kotlin_learning.PostsApiApp.UI.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.android_kotlin_learning.PostsApiApp.repository.PostRepository
import kotlinx.coroutines.launch

class PostListViewModel(private val postRepository: PostRepository) : ViewModel() {
    init {
        refreshDataFromRepository()
    }
    //list from local database
    val postList = postRepository.postList

    //calling data from repository
    fun refreshDataFromRepository(){
        viewModelScope.launch {
            postRepository.refreshPost()
        }
    }
}

class PostListViewModelFactory(private val postRepository: PostRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PostListViewModel(postRepository) as T
    }
}