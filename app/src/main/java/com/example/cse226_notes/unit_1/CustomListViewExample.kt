package com.example.cse226_notes.unit_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import com.example.cse226_notes.R

class CustomListViewExample : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_list_view_example)

        var listView: ListView = findViewById(R.id.listView)
        var list = mutableListOf<CustomListViewDataModel>()

        list.add(CustomListViewDataModel("Earphones", "Bluetooth", R.drawable.headset, false))
        list.add(CustomListViewDataModel("Mouse", "Wireless", R.drawable.mouse, false))
        list.add(CustomListViewDataModel("Keyboard", "Wired", R.drawable.keyboard, false))
        list.add(CustomListViewDataModel("MousePad", "Solid", R.drawable.mouse_pad, false))

        listView.adapter = CustomListViewAdapter(this, R.layout.custom_list_view, list)

        var cart: Button = findViewById(R.id.cart)
        cart.setOnClickListener {
            var str = "Check Items: \n"
            val cnt: Int = list.count()

            for (i in 0 until cnt) {
                var a = CustomListViewAdapter(this, R.layout.custom_list_view, list)
                if (a.isChecked(i)) {
                    str += """$i
                    """.trimIndent()
                }
            }
            Toast.makeText(this, str, Toast.LENGTH_LONG).show()
        }
    }
}