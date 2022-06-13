package com.example.android_kotlin_learning.auth_system

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.android_kotlin_learning.databinding.ActivityUberSplashScreenBinding

class UberSplashScreen : AppCompatActivity() {
    private lateinit var binding: ActivityUberSplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUberSplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        Handler().postDelayed({
            val intent = Intent(this, UberLoginActivity::class.java)
            startActivity(intent)
            finish()
        },5000)

    }
} 