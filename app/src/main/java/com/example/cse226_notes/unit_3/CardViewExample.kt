package com.example.cse226_notes.unit_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.cardview.widget.CardView
import com.example.cse226_notes.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class CardViewExample : AppCompatActivity() {

    private lateinit var add: FloatingActionButton
    private lateinit var cardView: CardView
    private lateinit var saveBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_view_example)

        add = findViewById(R.id.floatActionButton)
        cardView = findViewById(R.id.cardView)
        saveBtn = findViewById(R.id.saveButton)

        add.setOnClickListener {

            cardView.visibility = View.VISIBLE
            add.hide()
        }

        saveBtn.setOnClickListener {

            cardView.visibility = View.GONE
            add.show()
        }
    }
}