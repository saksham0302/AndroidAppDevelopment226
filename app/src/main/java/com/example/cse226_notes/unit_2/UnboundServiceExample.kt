package com.example.cse226_notes.unit_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.cse226_notes.R

class UnboundServiceExample : AppCompatActivity() {

    private lateinit var startButton: Button
    private lateinit var stopButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_unbound_service_example)

        startButton = findViewById(R.id.startService)
        stopButton = findViewById(R.id.stopService)

        startButton.setOnClickListener {

            startService(Intent(this, UnboundServiceDemo::class.java))
        }

        stopButton.setOnClickListener {

            stopService(Intent(this, UnboundServiceDemo::class.java))
        }
    }
}