package com.example.android_kotlin_learning.restaurant_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import com.example.android_kotlin_learning.databinding.ActivityResrtaurantMenuBinding

class ResrtaurantMenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResrtaurantMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResrtaurantMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnOrder.setOnClickListener {
            val checkedRadioButtonId = binding.rgBurgers.checkedRadioButtonId
            val burger = findViewById<RadioButton>(checkedRadioButtonId)
            val cheese = binding.chbCheese.isChecked
            val onions = binding.chbOnion.isChecked
            val salad = binding.chbSalad.isChecked
            val totalOrder = "You order a ${burger.text} burger with:"+
                    if (cheese == true) {"\n cheese"}else{""}+
                    if (salad == true)  {"\n salad"}  else{""}+
                    if (onions == true) {"\n onion"} else{""}
            binding.Result.text = totalOrder
        }
    }
}