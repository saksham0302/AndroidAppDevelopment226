package com.example.cse226_notes.unit_2

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class BroadcastReceiverBatteryStatusDemo : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent) {

        val batteryStatus = intent.getIntExtra("level", 0)
        Log.d("TAG", "$batteryStatus")
        if (batteryStatus < 10)
            Toast.makeText(context, "Battery is about to die!", Toast.LENGTH_LONG).show()

    }
}