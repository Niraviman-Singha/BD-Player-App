package com.example.bdplayerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bdplayerapp.databinding.ActivityPlayerBinding


class PlayerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPlayerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityPlayerBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.title.text = intent.getStringExtra("title")
        binding.details.text = intent.getStringExtra("details")
        binding.img.setImageResource(intent.getIntExtra("img", 0))
    }
}