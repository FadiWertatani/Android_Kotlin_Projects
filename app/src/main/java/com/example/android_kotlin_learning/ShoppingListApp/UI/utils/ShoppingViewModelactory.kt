package com.example.android_kotlin_learning.ShoppingListApp.UI.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android_kotlin_learning.ShoppingListApp.respository.ShoppingRepository

class ShoppingViewModelFactory(private val repository:ShoppingRepository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ShoppingViewModel(repository) as T
    }
}