package com.example.tmdbclient.data.Repository.Repository.Person.datasource

import com.example.tmdbclient.data.Model.Movie.Movie
import com.example.tmdbclient.data.Model.Person.Person

interface PersonLocalDataSource {
    suspend fun getPersonFromDB() : List<Person>
    suspend fun savePersonToDB(person : List<Person>)
    suspend fun clearAll()
}