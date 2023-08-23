package com.example.cse226_notes.unit_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.content.ContextCompat
import com.example.cse226_notes.R

class ForegroundServiceExample : AppCompatActivity() {

    private lateinit var startForegroundService: Button
    private lateinit var stopForegroundService: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_foreground_service_example)

        startForegroundService = findViewById(R.id.startForegroundService)
        stopForegroundService = findViewById(R.id.stopForegroundService)

        startForegroundService.setOnClickListener {

            val intent = Intent(this, ForegroundServiceDemo::class.java)
            intent.putExtra("inputExtra", "Foreground Service is running ...")
            ContextCompat.startForegroundService(this, intent)
        }

        stopForegroundService.setOnClickListener {

            val stopIntent = Intent(this, ForegroundServiceDemo::class.java)
            stopService(stopIntent)
        }
    }
}