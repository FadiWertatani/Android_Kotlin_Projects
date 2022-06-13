package com.example.android_kotlin_learning

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.android_kotlin_learning.CounterApp.MainActivity
import com.example.android_kotlin_learning.ToDoApp.UI.TodoListActivity
import com.example.android_kotlin_learning.auth_system.UberSplashScreen
import com.example.android_kotlin_learning.databinding.ActivityHomeScreenBinding
import com.example.android_kotlin_learning.restaurant_app.ResrtaurantMenuActivity

class HomeScreen : AppCompatActivity() {
    private lateinit var binding:ActivityHomeScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ActivityCounter.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.ActivityRestaurant.setOnClickListener {
            val intent = Intent(this, ResrtaurantMenuActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.ActivityUberApp.setOnClickListener {
            val intent = Intent(this, UberSplashScreen::class.java)
            startActivity(intent)
            finish()
        }
        binding.ActivityTodoList.setOnClickListener {
            val intent = Intent(this, TodoListActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.ActivityDrawer.setOnClickListener {
            val intent = Intent(this, ActivityDrawer::class.java)
            startActivity(intent)
            finish()
        }
    }
}