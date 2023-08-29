package com.example.cse226_notes.unit_2

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cse226_notes.R

class BroadcastReceiverAirplaneModeExample : AppCompatActivity() {

    private lateinit var receiver: BroadcastReceiverAirplaneModeDemo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_broadcast_receiver_airplane_mode_example)

        receiver = BroadcastReceiverAirplaneModeDemo()

        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {

            registerReceiver(receiver, it)
        }
    }

    override fun onStop() {
        super.onStop()

        unregisterReceiver(receiver)
    }
}