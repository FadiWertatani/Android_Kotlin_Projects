package com.example.android_kotlin_learning.ShoppingListApp.respository

import com.example.android_kotlin_learning.ShoppingListApp.DB.ShoppingDB
import com.example.android_kotlin_learning.ShoppingListApp.model.ShoppingItem

class ShoppingRepository(private val db:ShoppingDB) {

    suspend fun upsert(item: ShoppingItem) = db.getShoppingDAO().upsert(item)

    suspend fun delete(item: ShoppingItem) = db.getShoppingDAO().delete(item)

    fun getAllShoppingItem() = db.getShoppingDAO().getAllShoppingItem()
}