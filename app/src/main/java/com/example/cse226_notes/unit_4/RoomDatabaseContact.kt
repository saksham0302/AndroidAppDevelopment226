package com.example.cse226_notes.unit_4

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contact")
data class RoomDatabaseContact(

    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val phone: Long,
)
