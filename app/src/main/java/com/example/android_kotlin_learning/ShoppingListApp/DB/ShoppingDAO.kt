package com.example.android_kotlin_learning.ShoppingListApp.DB

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.android_kotlin_learning.ShoppingListApp.model.ShoppingItem

@Dao
interface ShoppingDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(item: ShoppingItem)

    @Delete
    fun delete(item: ShoppingItem)

    @Query("SELECT * FROM shopping_items")
    fun getAllShoppingItem(): LiveData<List<ShoppingItem>>
}