package com.example.cse226_notes.unit_4

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQLiteDatabaseHelper(context: Context, factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {

    companion object {

        // variables for database version

        //database name
        private const val DATABASE_NAME = "CSE226"

        //database version
        private const val DATABASE_VERSION = 1

        //table name
        private const val TABLE_NAME = "my_Table1"

        //column id
        const val ID_COL = "id"

        //column name
        const val NAME_COL = "name"

        //column age
        const val AGE_COL = "age"

        //column salary
        const val SALARY_COL = "salary"
    }

    override fun onCreate(db: SQLiteDatabase) {

        // SQLITE query with column names and its data type
        val query = ("CREATE TABLE $TABLE_NAME " +
                "($ID_COL TEXT, $NAME_COL TEXT, $AGE_COL TEXT, $SALARY_COL TEXT)")

        //method for executing query
        db.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

        //method to check if table already exists
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    //function to add data to table
    fun addData(id: String, name: String, age: String, salary: String) {

        val values = ContentValues()

        //inserting the values in key value pair
        values.put(ID_COL, id)
        values.put(NAME_COL, name)
        values.put(AGE_COL, age)
        values.put(SALARY_COL, salary)

        //creating a writable variable of database as we want to insert value in our database
        val db = this.writableDatabase
        //values inserted into database
        db.insert(TABLE_NAME, null, values)

        //closing the database
        db.close()
    }

    fun updateData(id: String, name: String, age: String, salary: String) {

        val db = this.writableDatabase
        val values = ContentValues()

        values.put(NAME_COL, name)
        values.put(AGE_COL, age)
        values.put(SALARY_COL, salary)
        db.update(TABLE_NAME, values, "ID=?", arrayOf(id))

        //closing the database
        db.close()
    }

    fun getData(): Cursor? {

        val db = this.readableDatabase

        //returning a cursor to read data from the database
        return db.rawQuery("SELECT * FROM $TABLE_NAME ORDER BY $ID_COL", null)
    }

    fun deleteData(id: String) {

        val db = this.writableDatabase
        db.delete(TABLE_NAME, "ID=?", arrayOf(id))
        db.close()
    }
}