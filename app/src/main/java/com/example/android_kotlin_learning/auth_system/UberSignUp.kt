package com.example.android_kotlin_learning.auth_system

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_kotlin_learning.databinding.ActivityUberSignUpBinding
import com.example.android_kotlin_learning.restaurant_app.ResrtaurantMenuActivity

class UberSignUp : AppCompatActivity() {
    private lateinit var binding: ActivityUberSignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUberSignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.btnsignup.setOnClickListener {
            val intent = Intent(this, ResrtaurantMenuActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.btnSign.setOnClickListener{
            val intent = Intent(this, UberLoginActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}