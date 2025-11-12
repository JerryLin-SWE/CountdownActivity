package com.example.countdownactivity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.util.Log
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val input = findViewById<EditText>(R.id.editTextNumber)
        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            val text = input.text?.toString()?.trim()
            val seconds = text?.toIntOrNull()

            if(seconds ==null || seconds <0){
                Log.i("MainActivity","Invalid Text")
                input.error = " Please Enter a non-negative Int"
                return@setOnClickListener
            }

            val intent = Intent(this, CountdownService::class.java)
                .putExtra(CountdownService.EXTRA_TIME,seconds)
            startService(intent)
        }
    }
}

