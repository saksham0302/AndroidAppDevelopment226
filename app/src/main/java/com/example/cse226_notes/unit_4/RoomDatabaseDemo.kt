package com.example.cse226_notes.unit_4

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [RoomDatabaseContact::class], version = 1)
abstract class RoomDatabaseDemo : RoomDatabase() {

    abstract fun RoomDatabaseDao(): RoomDatabaseDao
}