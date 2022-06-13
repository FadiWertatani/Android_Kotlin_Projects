package com.example.android_kotlin_learning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.example.android_kotlin_learning.databinding.ActivityDrawerBinding

class ActivityDrawer : AppCompatActivity() {
    private lateinit var binding: ActivityDrawerBinding
    lateinit var toggle : ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDrawerBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_drawer)

        val drawer = findViewById<DrawerLayout>(R.id.DrawerLayout)

        toggle = ActionBarDrawerToggle(this,drawer,R.string.open,R.string.close)

        drawer.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true) //show the button
        binding.navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.MyName -> Toast.makeText(this,"Fadi",Toast.LENGTH_SHORT).show()
                R.id.MyEmail -> Toast.makeText(this,"example@gmail.com",Toast.LENGTH_SHORT).show()
                R.id.MyPhone -> Toast.makeText(this,"12345678",Toast.LENGTH_SHORT).show()
                R.id.MyPassword -> Toast.makeText(this,"pwd",Toast.LENGTH_SHORT).show()
            }
            true
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}


/* when(it.itemId){
                R.id.MyName -> Toast.makeText(this,"Fadi",Toast.LENGTH_SHORT).show()
                R.id.MyEmail -> Toast.makeText(this,"example@gmail.com",Toast.LENGTH_SHORT).show()
                R.id.MyPhone -> Toast.makeText(this,"12345678",Toast.LENGTH_SHORT).show()
                R.id.MyPassword -> Toast.makeText(this,"pwd",Toast.LENGTH_SHORT).show()
            }
            true*/