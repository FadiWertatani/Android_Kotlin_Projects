package com.example.android_kotlin_learning.ShoppingListApp.UI.utils

import androidx.lifecycle.ViewModel
import com.example.android_kotlin_learning.ShoppingListApp.model.ShoppingItem
import com.example.android_kotlin_learning.ShoppingListApp.respository.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(private val repository:ShoppingRepository):ViewModel() {

    fun upsert(item: ShoppingItem) = CoroutineScope(Dispatchers.IO).launch {
        repository.upsert(item)
    }
    fun delete(item: ShoppingItem) = CoroutineScope(Dispatchers.IO).launch {
        repository.delete(item)
    }
    fun getAllShoppingItem() = repository.getAllShoppingItem()

}