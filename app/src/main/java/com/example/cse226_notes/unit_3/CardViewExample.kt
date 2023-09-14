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
    private lateinit var personName: EditText
    private lateinit var personContact: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_view_example)

        add = findViewById(R.id.floatActionButton)
        cardView = findViewById(R.id.cardView)
        saveBtn = findViewById(R.id.saveButton)

        personName = findViewById(R.id.personName)
        personContact = findViewById(R.id.personContact)

        gridView = findViewById(R.id.recyclerView)
        gridView.setHasFixedSize(true)
        list = ArrayList<CardRecyclerViewDataModel>()

        add.setOnClickListener {

            cardView.visibility = View.VISIBLE
            add.hide()
            gridView.visibility = View.GONE
        }

        saveBtn.setOnClickListener {

            val name = personName.text
            val contact = personContact.text
            list.add(
                CardRecyclerViewDataModel(
                    name,
                    R.drawable.baseline_perm_contact_calendar_24,
                    contact
                )
            )
            val gridLayoutManager = GridLayoutManager(this, 2)
            gridLayoutManager.orientation = RecyclerView.VERTICAL
            gridView.layoutManager = gridLayoutManager
            myAdap = CardRecyclerViewAdapter(this, list)
            gridView.adapter = myAdap
            cardView.visibility = View.GONE
            add.show()
            gridView.visibility = View.VISIBLE
            personName.text.clear()
            personContact.text.clear()
        }
    }
}