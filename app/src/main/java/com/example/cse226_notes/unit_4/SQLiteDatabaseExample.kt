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

    private lateinit var id: EditText
    private lateinit var name: EditText
    private lateinit var age: EditText
    private lateinit var salary: EditText
    private lateinit var submitData: Button
    private lateinit var retrieveData: Button
    private lateinit var updateData: Button
    private lateinit var deleteData: Button
    private lateinit var getId: TextView
    private lateinit var getName: TextView
    private lateinit var getAge: TextView
    private lateinit var getSalary: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sqlite_database_example)

        id = findViewById(R.id.EtId)
        name = findViewById(R.id.EtName)
        age = findViewById(R.id.EtAge)
        salary = findViewById(R.id.EtSalary)

        submitData = findViewById(R.id.submitData)
        retrieveData = findViewById(R.id.retrieveData)
        updateData = findViewById(R.id.updateData)
        deleteData = findViewById(R.id.deleteData)

        getId = findViewById(R.id.displayId)
        getName = findViewById(R.id.displayName)
        getAge = findViewById(R.id.displayAge)
        getSalary = findViewById(R.id.displaySalary)

        submitData.setOnClickListener {

            val db = SQLiteDatabaseHelper(this, null)

            val dataId = id.text.toString()
            val dataName = name.text.toString()
            val dataAge = age.text.toString()
            val dataSalary = salary.text.toString()

            db.addData(dataId, dataName, dataAge, dataSalary)
            Toast.makeText(this, "$dataName added to database", Toast.LENGTH_SHORT).show()

            id.text.clear()
            name.text.clear()
            age.text.clear()
            salary.text.clear()
            displayData(getId, getName, getAge, getSalary)
        }

        retrieveData.setOnClickListener {

            displayData(getId, getName, getAge, getSalary)
        }

        updateData.setOnClickListener {

            val db = SQLiteDatabaseHelper(this, null)

            val dataId = id.text.toString()
            val dataName = name.text.toString()
            val dataAge = age.text.toString()
            val dataSalary = salary.text.toString()

            db.updateData(dataId, dataName, dataAge, dataSalary)
            Toast.makeText(this, "$dataName updated to database", Toast.LENGTH_SHORT).show()

            name.text.clear()
            age.text.clear()
            displayData(getId, getName, getAge, getSalary)
        }

        deleteData.setOnClickListener {

            val db = SQLiteDatabaseHelper(this, null)

            val dataId = id.text.toString()

            db.deleteData(dataId)
            Toast.makeText(this, "$dataId deleted from database", Toast.LENGTH_SHORT).show()

            age.text.clear()
            displayData(getId, getName, getAge, getSalary)
        }
    }

    @SuppressLint("Range")
    fun displayData(getId: TextView, getName: TextView, getAge: TextView, getSalary: TextView) {

        val db = SQLiteDatabaseHelper(this, null)

        // below is the variable for cursor
        // we have called method to get
        // all names from our database
        // and add to name text view
        val cursor = db.getData()
        getId.text = "Id\n\n"
        getName.text = "Name\n\n"
        getAge.text = "Age\n\n"
        getSalary.text = "Salary\n\n"

        // moving the cursor to first position and
        // appending value in the text view
        cursor!!.moveToFirst()
        getId.append(
            cursor.getString(cursor.getColumnIndex(SQLiteDatabaseHelper.ID_COL))
                    + "\n"
        )
        getName.append(
            cursor.getString(cursor.getColumnIndex(SQLiteDatabaseHelper.NAME_COL))
                    + "\n"
        )
        getAge.append(
            cursor.getString(cursor.getColumnIndex(SQLiteDatabaseHelper.AGE_COL))
                    + "\n"
        )
        getSalary.append(
            cursor.getString(cursor.getColumnIndex(SQLiteDatabaseHelper.SALARY_COL))
                    + "\n"
        )

        // moving our cursor to next
        // position and appending values
        while (cursor.moveToNext()) {

            getId.append(
                cursor.getString(cursor.getColumnIndex(SQLiteDatabaseHelper.ID_COL))
                        + "\n"
            )
            getName.append(
                cursor.getString(cursor.getColumnIndex(SQLiteDatabaseHelper.NAME_COL))
                        + "\n"
            )
            getAge.append(
                cursor.getString(cursor.getColumnIndex(SQLiteDatabaseHelper.AGE_COL))
                        + "\n"
            )
            getSalary.append(
                cursor.getString(cursor.getColumnIndex(SQLiteDatabaseHelper.SALARY_COL))
                        + "\n"
            )
        }

        // at last we close our cursor
        cursor.close()
    }
}