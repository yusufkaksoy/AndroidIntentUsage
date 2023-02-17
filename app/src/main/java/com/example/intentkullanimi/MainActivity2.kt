package com.example.intentkullanimi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intentkullanimi.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var  binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val comingText = intent.getStringExtra("NAME")
        binding.textView.text = comingText
    }
}