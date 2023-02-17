package com.example.intentkullanimi

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intentkullanimi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnSend.setOnClickListener {
            intent = Intent(this,MainActivity2::class.java)
            intent.putExtra("NAME",binding.tvNote.text.toString())
            startActivity(intent)
        }

        binding.btnPhoto.setOnClickListener {
            intent = Intent(Intent.ACTION_GET_CONTENT).also {
                it.type =  "image/*"
                startActivityIfNeeded(it,0)
            }
        }
        handleIntent(intent)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        handleIntent(intent)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode== Activity.RESULT_OK && requestCode == 0){
            val uri = data?.data
            binding.imageView.setImageURI(uri)
        }
    }

    private fun handleIntent(intent: Intent?){
        if (intent?.action == Intent.ACTION_SEND && intent.type =="text/plain"){
            binding.tvNote.setText(intent.getStringExtra(Intent.EXTRA_TEXT))
        }
    }

}