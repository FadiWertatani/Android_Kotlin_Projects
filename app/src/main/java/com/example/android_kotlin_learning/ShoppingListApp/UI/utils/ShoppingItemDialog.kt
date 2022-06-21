package com.example.android_kotlin_learning.ShoppingListApp.UI.utils

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.android_kotlin_learning.ShoppingListApp.model.AddDialogListner
import com.example.android_kotlin_learning.ShoppingListApp.model.ShoppingItem
import com.example.android_kotlin_learning.databinding.DialogAddShoppingItemBinding

class ShoppingItemDialog(context:Context, var addDialogListner: AddDialogListner):AppCompatDialog(context) {

    private lateinit var binding: DialogAddShoppingItemBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DialogAddShoppingItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnShoppingItemAdd.setOnClickListener {
            var shoppingItemName =  binding.editTextShoppingItem.text.toString()
            var shoppingItemAmount =  binding.editTextAmount.text.toString()

            if (shoppingItemName.isEmpty() || shoppingItemAmount.isEmpty()){
                Toast.makeText(context,"Please enter item name and amount",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }else{
               var item = ShoppingItem(shoppingItemName,shoppingItemAmount.toInt())
                addDialogListner.onAddButtonClick(item)
                dismiss()
            }

        }
        binding.btnShoppingItemCancel.setOnClickListener {
            cancel()
        }

    }

}