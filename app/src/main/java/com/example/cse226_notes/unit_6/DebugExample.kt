package com.example.cse226_notes.unit_6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.cse226_notes.R

class DebugExample : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_debug_example)
        division()
    }

    private fun division() {

        val numerator = 60
        var denominator = 4
        repeat(5) {

            Log.v("TAG", "${numerator / denominator}")
            denominator--
        }
    }
}