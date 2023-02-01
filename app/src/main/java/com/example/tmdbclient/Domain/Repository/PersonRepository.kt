package com.example.tmdbclient.Domain.Repository

import com.example.tmdbclient.data.Model.Person.Person

interface PersonRepository {

    suspend fun getPerson() : List<Person>?
    suspend fun updatePerson() : List<Person>?
}