package com.example.cse226_notes.unit_4

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.get
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.cse226_notes.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RoomDatabaseExample : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var database: RoomDatabaseDemo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_database_example)

        database = Room.databaseBuilder(
            applicationContext,
            RoomDatabaseDemo::class.java, "contact"
        ).build()

        listView = findViewById(R.id.listView1)
        listView.setOnItemLongClickListener { parent, view, position, id ->

            val view = parent[position]
            val id = view.findViewById<TextView>(R.id.idListItem).text.toString().toLong()
            val name = view.findViewById<TextView>(R.id.nameListItem).text.toString()
            val phone = view.findViewById<TextView>(R.id.noListItem).text.toString()
            val address = view.findViewById<TextView>(R.id.addressListItem).text.toString()

            val builder = AlertDialog.Builder(this)
            builder.setTitle("Edit")

            val linearLayout = LinearLayout(this)
            linearLayout.orientation = LinearLayout.VERTICAL
            val idView = EditText(this)
            idView.setText(id.toString())
            linearLayout.addView(idView)
            val nameView = EditText(this)
            nameView.setText(name)
            linearLayout.addView(nameView)
            val phoneView = EditText(this)
            phoneView.setText(phone)
            phoneView.maxWidth = 10
            linearLayout.addView(phoneView)
            val addressView = EditText(this)
            addressView.setText(address)
            linearLayout.addView(addressView)

            builder.setView(linearLayout)
            builder.setPositiveButton("Update", DialogInterface.OnClickListener {

                    dialog, which ->

                val updateName = nameView.text.toString()
                val updatePhone = phoneView.text.toString()
                val updateAddress = addressView.text.toString()
                GlobalScope.launch {
                    database.RoomDatabaseDao()
                        .update(RoomDatabaseContact(id, updateName, updatePhone, updateAddress))
                }

                Toast.makeText(this, "Updated $updateName $updatePhone", Toast.LENGTH_SHORT).show()
            })

            builder.setNeutralButton("Delete", DialogInterface.OnClickListener {

                    dialog, which ->

                val updateName = nameView.text.toString()
                val updatePhone = phoneView.text.toString()
                val updateAddress = addressView.text.toString()
                GlobalScope.launch {
                    database.RoomDatabaseDao()
                        .delete(RoomDatabaseContact(id, updateName, updatePhone, updateAddress))
                }
            })

            builder.setNegativeButton("Cancel", DialogInterface.OnClickListener {

                    dialog, which ->
                dialog.cancel()
            })
            builder.show()

            return@setOnItemLongClickListener true
        }

        val display = findViewById<Button>(R.id.display)
        display.setOnClickListener {

            getData(it)
        }

        val add = findViewById<Button>(R.id.add)
        add.setOnClickListener {

            val id = findViewById<EditText>(R.id.id)
            val name = findViewById<EditText>(R.id.name)
            val contact = findViewById<EditText>(R.id.contact)
            val address = findViewById<EditText>(R.id.address)
            GlobalScope.launch {
                database.RoomDatabaseDao().insert(
                    RoomDatabaseContact(
                        id.text.toString().toLong(),
                        name.text.toString(),
                        contact.text.toString(),
                        address.text.toString()
                    )
                )
            }

            id.text.clear()
            name.text.clear()
            contact.text.clear()
            address.text.clear()
        }
    }

    private fun getData(view: View) {

        database.RoomDatabaseDao().getContact().observe(this) {

            val adapter = RoomDatabaseAdapter(
                this,
                R.layout.custom_list_view_room_database, it
            )
            listView.adapter = adapter
        }
    }
}