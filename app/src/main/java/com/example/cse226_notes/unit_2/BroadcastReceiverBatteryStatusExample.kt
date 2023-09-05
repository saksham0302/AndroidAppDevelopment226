package com.example.cse226_notes.unit_2

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.content.getSystemService
import com.example.cse226_notes.R

class BroadcastReceiverBatteryStatusExample : AppCompatActivity() {

    private lateinit var receiver: BroadcastReceiverBatteryStatusDemo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_broadcast_receiver_battery_status_example)

        receiver = BroadcastReceiverBatteryStatusDemo()

        IntentFilter(Intent.ACTION_BATTERY_CHANGED).also {

            registerReceiver(receiver, it)
        }
    }

    override fun onStop() {
        super.onStop()

        unregisterReceiver(receiver)
    }
}