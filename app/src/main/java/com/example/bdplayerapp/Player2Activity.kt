package com.example.bdplayerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bdplayerapp.databinding.ActivityPlayer2Binding
import com.example.bdplayerapp.databinding.ActivityPlayerBinding

class Player2Activity : AppCompatActivity() {
    private lateinit var binding: ActivityPlayer2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityPlayer2Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.title.text = intent.getStringExtra("title")
        binding.details.text = intent.getStringExtra("details")
        binding.img.setImageResource(intent.getIntExtra("img", 0))
    }
}