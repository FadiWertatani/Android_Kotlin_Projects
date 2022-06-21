package com.example.android_kotlin_learning.ShoppingListApp.UI.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_kotlin_learning.ShoppingListApp.model.ShoppingItem
import com.example.android_kotlin_learning.databinding.ItemShoppingBinding

class ShoppingItemAdapter (var items:List<ShoppingItem>,private val ViewModel:ShoppingViewModel) : RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {

    inner class ShoppingViewHolder(val binding: ItemShoppingBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        return ShoppingViewHolder(ItemShoppingBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        var currentShoppingItem = items[position]
        holder.binding.txtname.text = currentShoppingItem.name
        holder.binding.txtnbr.text = "${currentShoppingItem.amount}"
        holder.binding.delete.setOnClickListener {
            ViewModel.delete(currentShoppingItem)
        }
        holder.binding.add.setOnClickListener {
            currentShoppingItem.amount++
            ViewModel.upsert(currentShoppingItem)
        }
        holder.binding.remove.setOnClickListener {
            if (currentShoppingItem.amount >0){
                currentShoppingItem.amount--
                ViewModel.upsert(currentShoppingItem)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

}