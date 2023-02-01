package com.example.tmdbclient.data.Repository.Repository.Person.datasourceImpl

import com.example.tmdbclient.data.Model.Movie.Movie
import com.example.tmdbclient.data.Model.Person.Person
import com.example.tmdbclient.data.Repository.Repository.Movie.datasource.MovieLocalDataSource
import com.example.tmdbclient.data.Repository.Repository.Person.datasource.PersonLocalDataSource
import com.example.tmdbclient.data.db.MovieDao
import com.example.tmdbclient.data.db.PersonDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PersonLocalDataSourceImpl(private val personDao: PersonDao) : PersonLocalDataSource {

    override suspend fun getPersonFromDB(): List<Person> = personDao.getPersonList()

    override suspend fun savePersonToDB(person: List<Person>) {
        CoroutineScope(Dispatchers.IO).launch {
            personDao.savePerson(person)
        }
    }

    override suspend fun clearAll(){
        CoroutineScope(Dispatchers.IO).launch {
            personDao.deleteAllPerson()
        }
    }
}