package com.example.cse226_notes.unit_2

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.os.SystemClock
import android.util.Log
import android.widget.Chronometer

class BoundServiceDemo : Service() {

    private val LOG_TAG = "Bound Service"
    private val mBinder: IBinder = MyBinder()
    private var mChronometer: Chronometer? = null
    override fun onCreate() {
        super.onCreate()
        Log.v(LOG_TAG, "in onCreate: ")
        mChronometer = Chronometer(this)
        mChronometer!!.base = SystemClock.elapsedRealtime()
        mChronometer!!.start()
    }

    override fun onBind(intent: Intent?): IBinder? {
        return mBinder
    }

    override fun onRebind(intent: Intent?) {
        Log.v(LOG_TAG, "in Rebind")
        super.onRebind(intent)
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.v(LOG_TAG, "in Unbind")
        return super.onUnbind(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v(LOG_TAG, "in onDestroy")
        mChronometer!!.stop()
    }

    fun getTimestamp(): String? {

        val elapsedMillis = (SystemClock.elapsedRealtime() - mChronometer!!.base)
        val hours = (elapsedMillis / 3600000).toInt()
        val minutes = (elapsedMillis - hours * 3600000).toInt() / 60000
        val seconds = (elapsedMillis - hours * 3600000 - minutes * 60000).toInt() / 1000
        val millis = (elapsedMillis - hours * 3600000 - minutes * 60000 -
                seconds * 1000).toInt()

        return "$hours:$minutes:$seconds:$millis"
    }

    inner class MyBinder : Binder() {

        fun getService(): BoundServiceDemo {
            return this@BoundServiceDemo
        }
    }
}