package com.example.cse226_notes.unit_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.cse226_notes.R

class SQLiteDatabaseExample : AppCompatActivity() {

    private lateinit var name: EditText
    private lateinit var age: EditText
    private lateinit var addName: Button
    private lateinit var addAge: Button
    private lateinit var getName: TextView
    private lateinit var getAge: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sqlite_database_example)

        name = findViewById(R.id.EtName)
        age = findViewById(R.id.EtAge)
        addName = findViewById(R.id.submitName)
        addAge = findViewById(R.id.submitAge)
        getName = findViewById(R.id.displayName)
        getAge = findViewById(R.id.displayAge)

        addName.setOnClickListener {

            val db = SQLiteDatabaseHelper(this, null)

            val dataName = name.text.toString()
            val dataAge = age.text.toString()

            db.addData(dataName, dataAge)
            Toast.makeText(this, "$dataName added to database", Toast.LENGTH_SHORT).show()

            name.text.clear()
            age.text.clear()
        }

        addAge.setOnClickListener {


        }
    }
}