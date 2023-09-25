package com.example.cse226_notes.unit_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cse226_notes.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class CardViewExample : AppCompatActivity() {

    private lateinit var add: FloatingActionButton
    private lateinit var cardView: CardView
    private lateinit var saveBtn: Button
    private var list = ArrayList<CardRecyclerViewDataModel>()
    private lateinit var myAdap: CardRecyclerViewAdapter
    private lateinit var gridView: RecyclerView
    private lateinit var contactName: EditText
    private lateinit var personContact: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_view_example)

        add = findViewById(R.id.floatActionButton)
        cardView = findViewById(R.id.cardView)
        saveBtn = findViewById(R.id.saveButton)

        contactName = findViewById(R.id.contactName)
        personContact = findViewById(R.id.personContact)

        gridView = findViewById(R.id.recyclerView)
        gridView.setHasFixedSize(true)

        add.setOnClickListener {

            cardView.visibility = View.VISIBLE
            add.hide()
            gridView.visibility = View.GONE
            
            contactName.text.clear()
            personContact.text.clear()
        }

        val gridLayoutManager = GridLayoutManager(this, 2)
        gridLayoutManager.orientation = RecyclerView.VERTICAL
        gridView.layoutManager = gridLayoutManager
        myAdap = CardRecyclerViewAdapter(this, list)
        gridView.adapter = myAdap
        var count = 0

        saveBtn.setOnClickListener {

            list.add(
                CardRecyclerViewDataModel(
                    contactName.text,
                    R.drawable.baseline_perm_contact_calendar_24,
                    personContact.text
                )
            )
            myAdap.notifyItemInserted(count)
            count++

            cardView.visibility = View.GONE
            add.show()
            gridView.visibility = View.VISIBLE
        }
    }
}