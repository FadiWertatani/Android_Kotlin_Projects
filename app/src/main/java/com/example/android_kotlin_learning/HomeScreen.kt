package com.example.android_kotlin_learning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_kotlin_learning.databinding.ActivityHomeScreenBinding

class HomeScreen : AppCompatActivity() {
    private lateinit var binding:ActivityHomeScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ActivityCounter.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.ActivityRestaurant.setOnClickListener {
            val intent = Intent(this,ResrtaurantMenuActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.ActivityUberApp.setOnClickListener {
            val intent = Intent(this,UberSplashScreen::class.java)
            startActivity(intent)
            finish()
        }
    }
}