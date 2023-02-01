package com.example.tmdbclient.data.Repository.Repository.Person.datasource

import com.example.tmdbclient.data.Model.Movie.Movie
import com.example.tmdbclient.data.Model.Person.Person
import com.example.tmdbclient.data.db.PersonDao

interface PersonCacheDataSource {
    suspend fun savePersonToCache(person : List<Person>)
    suspend fun getPersonFromCache() : List<Person>
}