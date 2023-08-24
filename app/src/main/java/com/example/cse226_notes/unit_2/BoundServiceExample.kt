package com.example.cse226_notes.unit_2

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.cse226_notes.R

class BoundServiceExample : AppCompatActivity() {

    private lateinit var timeStampText: TextView
    private lateinit var timeStampPrint: Button
    private lateinit var timeStampStop: Button

    private var mBoundService: BoundServiceDemo? = null
    private var mServiceBound = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bound_service_example)

        timeStampText = findViewById(R.id.timeStampText)
        timeStampPrint = findViewById(R.id.timeStampPrint)
        timeStampStop = findViewById(R.id.timeStampStop)

        timeStampPrint.setOnClickListener {

            if (mServiceBound) {
                timeStampText.text = mBoundService!!.getTimestamp()
            }
        }

        timeStampStop.setOnClickListener {

            if (mServiceBound) {
                unbindService(mServiceConnection)
                mServiceBound = false
            }

            val intent = Intent(this@BoundServiceExample, BoundServiceDemo::class.java)

            stopService(intent)
        }
    }

    override fun onStart() {
        super.onStart()

        val intent = Intent(this, BoundServiceDemo::class.java)
        startService(intent)
        bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE)
    }

    override fun onStop() {
        super.onStop()

        if (mServiceBound) {
            unbindService(mServiceConnection)
            mServiceBound = false
        }
    }

    private val mServiceConnection: ServiceConnection = object : ServiceConnection {

        override fun onServiceDisconnected(name: ComponentName?) {
            mServiceBound = false
        }

        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {

            val myBinder: BoundServiceDemo.MyBinder = service as BoundServiceDemo.MyBinder
            mBoundService = myBinder.getService()
        }
    }
}