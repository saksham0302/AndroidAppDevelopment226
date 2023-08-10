package com.example.cse226_notes.unit_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cse226_notes.R

class RecyclerViewExample : AppCompatActivity() {

    private val list = mutableListOf<RecyclerViewDataModel>()
    private lateinit var myAdap: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_example)

        val rv: RecyclerView = findViewById(R.id.recyclerView)
        myAdap = RecyclerViewAdapter(list)
        val layoutManager = LinearLayoutManager(applicationContext)
        rv.layoutManager = layoutManager
        rv.itemAnimator = DefaultItemAnimator()
        rv.adapter = myAdap
        call()
    }

    private fun call() {

        val data = RecyclerViewDataModel("Semester 1","CGPA 9","2020")
        list.add(data)
        list.add(RecyclerViewDataModel("Semester 2","CGPA 8","2021"))
        list.add(RecyclerViewDataModel("Semester 3","CGPA 5","2026"))
        list.add(RecyclerViewDataModel("Semester 4","CGPA 6","2025"))
    }

}