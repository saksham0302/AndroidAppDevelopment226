package com.example.cse226_notes.unit_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.example.cse226_notes.R

class CustomListViewExample : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_list_view_example)

        var listView: ListView = findViewById(R.id.listView)
        var list = mutableListOf<CustomListViewDataModel>()

        list.add(CustomListViewDataModel("Nisha", "friend", R.drawable.ic_launcher_foreground))
        list.add(CustomListViewDataModel("Nishant", "friends", R.drawable.ic_launcher_foreground))
        list.add(CustomListViewDataModel("Sahil", "cousin", R.drawable.ic_launcher_foreground))
        list.add(CustomListViewDataModel("Moksh", "family", R.drawable.ic_launcher_foreground))
        list.add(CustomListViewDataModel("Tript", "?", R.drawable.ic_launcher_foreground))

        listView.adapter = CustomListViewAdapter(this, R.layout.custom_list_view, list)
    }
}