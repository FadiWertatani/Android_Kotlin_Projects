package com.example.android_kotlin_learning.ToDoApp.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_kotlin_learning.R
import com.example.android_kotlin_learning.ToDoApp.model.Todo
import com.example.android_kotlin_learning.ToDoApp.utils.TodoAdapter
import com.example.android_kotlin_learning.databinding.ActivityTodoListBinding

class TodoListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTodoListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTodoListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val todoListSingleItem = mutableListOf(Todo("Run",false))

        val adapter = TodoAdapter(todoListSingleItem)

        binding.rvtodo.adapter = adapter
        binding.rvtodo.layoutManager = LinearLayoutManager(this)

        binding.btnAddTodo.setOnClickListener {
            val newTodoTitle = binding.etAddTodo.text.toString()  //getting the todos as text
            val newTodo = Todo(newTodoTitle,false) //new todoItem

            todoListSingleItem.add(newTodo)
            adapter.notifyDataSetChanged() //adapter update
            binding.etAddTodo.text.clear() //clear of data
        }

    }
}