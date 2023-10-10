package com.example.cse226_notes.unit_4

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contact")
data class RoomDatabaseContact(

    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String,
    val phone: String,
    val address: String,
)
