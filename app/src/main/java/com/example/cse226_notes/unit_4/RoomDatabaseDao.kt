package com.example.cse226_notes.unit_4

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface RoomDatabaseDao {

    @Insert
    suspend fun insert(contact: RoomDatabaseContact)

    @Update
    suspend fun update(contact: RoomDatabaseContact)

    @Delete
    suspend fun delete(contact: RoomDatabaseContact)

    @Query("SELECT * FROM contact")
    fun getContact(): LiveData<List<RoomDatabaseContact>>
}