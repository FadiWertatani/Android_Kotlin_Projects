package com.example.android_kotlin_learning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_kotlin_learning.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        var Count = 0
        binding.btnPlus.setOnClickListener {
            Count++
            binding.tvCounter.text = "Lets Count Together $Count"
        }
        binding.btnMinus.setOnClickListener {
            Count--
            binding.tvCounter.text = "Lets Count Together $Count"
        }
        binding.btnReset.setOnClickListener {
            Count = 0
            binding.tvCounter.text = "Lets Count Together"
        }
    }
}