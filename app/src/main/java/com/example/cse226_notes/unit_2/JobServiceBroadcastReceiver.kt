package com.example.cse226_notes.unit_2

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.util.Log
import android.widget.Toast
import com.example.cse226_notes.R

class JobServiceBroadcastReceiver : BroadcastReceiver() {
    
    override fun onReceive(context: Context?, intent: Intent?) {
        val mp = MediaPlayer.create(context, R.raw.drums)
        Log.d("Hello", "repeating alarm")
        mp.start()
        Toast.makeText(context, "Message", Toast.LENGTH_LONG).show()
    }

}