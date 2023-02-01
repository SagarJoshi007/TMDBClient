package com.example.tmdbclient.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tmdbclient.data.Model.Person.Person

@Dao
interface PersonDao {

    @Query("SELECT * FROM popular_person")
    suspend fun getPersonList() : List<Person>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun savePerson(person : List<Person>)

    @Query("DELETE FROM popular_person")
    suspend fun deleteAllPerson()
}