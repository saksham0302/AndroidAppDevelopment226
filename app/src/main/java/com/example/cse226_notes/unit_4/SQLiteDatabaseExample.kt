package com.example.cse226_notes.unit_4

import android.annotation.SuppressLint
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
    private lateinit var submitData: Button
    private lateinit var retrieveData: Button
    private lateinit var updateData: Button
    private lateinit var getName: TextView
    private lateinit var getAge: TextView

    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sqlite_database_example)

        name = findViewById(R.id.EtName)
        age = findViewById(R.id.EtAge)
        submitData = findViewById(R.id.submitData)
        retrieveData = findViewById(R.id.retrieveData)
        updateData = findViewById(R.id.updateData)
        getName = findViewById(R.id.displayName)
        getAge = findViewById(R.id.displayAge)

        submitData.setOnClickListener {

            val db = SQLiteDatabaseHelper(this, null)

            val dataName = name.text.toString()
            val dataAge = age.text.toString()

            db.addData(dataName, dataAge)
            Toast.makeText(this, "$dataName added to database", Toast.LENGTH_SHORT).show()

            name.text.clear()
            age.text.clear()
        }

        retrieveData.setOnClickListener {

            val db = SQLiteDatabaseHelper(this, null)

            // below is the variable for cursor
            // we have called method to get
            // all names from our database
            // and add to name text view
            val cursor = db.getData()
            getName.text = "Name\n\n"
            getAge.text = "Age\n\n"

            // moving the cursor to first position and
            // appending value in the text view
            cursor!!.moveToFirst()
            getName.append(
                cursor.getString(cursor.getColumnIndex(SQLiteDatabaseHelper.NAME_COL))
                        + "\n"
            )
            getAge.append(
                cursor.getString(cursor.getColumnIndex(SQLiteDatabaseHelper.AGE_COL))
                        + "\n"
            )

            // moving our cursor to next
            // position and appending values
            while (cursor.moveToNext()) {
                getName.append(
                    cursor.getString(
                        cursor.getColumnIndex
                            (SQLiteDatabaseHelper.NAME_COL)
                    ) + "\n"
                )
                getAge.append(
                    cursor.getString
                        (cursor.getColumnIndex(SQLiteDatabaseHelper.AGE_COL)) + "\n"
                )
            }

            // at last we close our cursor
            cursor.close()
        }

        updateData.setOnClickListener {

            val db = SQLiteDatabaseHelper(this, null)

            val dataName = name.text.toString()
            val dataAge = age.text.toString()

            db.updateData(dataName, dataAge)
            Toast.makeText(this, "$dataName updated to database", Toast.LENGTH_SHORT).show()

            name.text.clear()
            age.text.clear()
        }
    }
}