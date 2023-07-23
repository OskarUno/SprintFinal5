package com.awakelab.oskar.sprintfinal5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.awakelab.oskar.sprintfinal5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(
            layoutInflater
        )
        setContentView(binding!!.root)

    }


}