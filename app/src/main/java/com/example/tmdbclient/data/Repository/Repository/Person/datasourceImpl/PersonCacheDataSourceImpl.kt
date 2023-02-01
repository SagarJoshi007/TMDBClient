package com.example.tmdbclient.data.Repository.Repository.Person.datasourceImpl

import android.app.Person
import com.example.tmdbclient.data.Model.Movie.Movie
import com.example.tmdbclient.data.Repository.Repository.Movie.datasource.MovieCacheDataSource
import com.example.tmdbclient.data.Repository.Repository.Person.datasource.PersonCacheDataSource

class PersonCacheDataSourceImpl() : PersonCacheDataSource {

    private var personList = ArrayList<com.example.tmdbclient.data.Model.Person.Person>()

    override suspend fun savePersonToCache(person: List<com.example.tmdbclient.data.Model.Person.Person>) {
        personList.clear()
        personList = ArrayList(person)
    }

    override suspend fun getPersonFromCache(): List<com.example.tmdbclient.data.Model.Person.Person> {
        return personList
    }

}