package com.example.android_kotlin_learning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_kotlin_learning.databinding.ActivityUberLoginBinding

class UberLoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUberLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUberLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()


        binding.button.setOnClickListener {
            val intent = Intent(this,ResrtaurantMenuActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.SignUp.setOnClickListener{
            val intent = Intent(this,UberSignUp::class.java)
            startActivity(intent)
            finish()
        }
    }
}