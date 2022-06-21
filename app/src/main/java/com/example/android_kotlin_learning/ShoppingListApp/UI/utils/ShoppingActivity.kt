package com.example.android_kotlin_learning.ShoppingListApp.UI.utils

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_kotlin_learning.ShoppingListApp.DB.ShoppingDB
import com.example.android_kotlin_learning.ShoppingListApp.model.AddDialogListner
import com.example.android_kotlin_learning.ShoppingListApp.model.ShoppingItem
import com.example.android_kotlin_learning.ShoppingListApp.respository.ShoppingRepository
import com.example.android_kotlin_learning.databinding.ActivityShoppingBinding

class ShoppingActivity : AppCompatActivity() {
    private lateinit var binding:ActivityShoppingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShoppingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val database = ShoppingDB(this)
        val repository = ShoppingRepository(database as ShoppingDB)
        val factory = ShoppingViewModelFactory(repository)
        val viewModel = ViewModelProviders.of(this,factory).get(ShoppingViewModel::class.java)

        val ShoppingItemAdapter = ShoppingItemAdapter(listOf(),viewModel)
        binding.rvShopping.layoutManager = LinearLayoutManager(this)
        binding.rvShopping.adapter = ShoppingItemAdapter

        viewModel.getAllShoppingItem().observe(this, Observer {
            ShoppingItemAdapter.items = it
            ShoppingItemAdapter.notifyDataSetChanged() //update list
        })

        binding.btnAddShoppingItem.setOnClickListener {
            ShoppingItemDialog(
                this,
                object :AddDialogListner{
                override fun onAddButtonClick(item: ShoppingItem) {
                    viewModel.upsert(item)
                }
            }).show()
        }

    }
}