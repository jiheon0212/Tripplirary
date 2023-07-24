package com.example.tripplirary_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tripplirary_project.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var activityMainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        activityMainBinding.run {

        }

        setContentView(activityMainBinding.root)
    }
}