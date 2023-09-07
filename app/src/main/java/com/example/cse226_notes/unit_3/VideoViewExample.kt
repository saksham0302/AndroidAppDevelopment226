package com.example.cse226_notes.unit_3

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import com.example.cse226_notes.R

class VideoViewExample : AppCompatActivity() {

    private var sampleVideoView: VideoView? = null
    private lateinit var mediaControl: MediaController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_view_example)

        sampleVideoView = findViewById<View>(R.id.vv) as VideoView
        mediaControl = MediaController(this@VideoViewExample)

        if (mediaControl == null) {

            mediaControl.setAnchorView(sampleVideoView)
        }

        sampleVideoView!!.setVideoURI(
            Uri.parse(
                "android.resource://" + packageName + "/" + R.raw.squirrel
            )
        )
        sampleVideoView!!.requestFocus()
        sampleVideoView!!.setZOrderOnTop(false)
        sampleVideoView!!.start()

        sampleVideoView!!.setOnCompletionListener {

            Toast.makeText(applicationContext, "Thank You...!!!", Toast.LENGTH_LONG).show()
        }
    }
}