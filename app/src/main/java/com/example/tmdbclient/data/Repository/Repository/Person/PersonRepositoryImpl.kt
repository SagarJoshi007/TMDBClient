package com.example.tmdbclient.data.Repository.Repository.Person

import android.util.Log
import com.example.tmdbclient.Domain.Repository.MovieRposirtory
import com.example.tmdbclient.Domain.Repository.PersonRepository
import com.example.tmdbclient.data.Model.Movie.Movie
import com.example.tmdbclient.data.Model.Movie.MovieList
import com.example.tmdbclient.data.Model.Person.Person
import com.example.tmdbclient.data.Model.Person.PersonList
import com.example.tmdbclient.data.Repository.Repository.Movie.datasource.MovieCacheDataSource
import com.example.tmdbclient.data.Repository.Repository.Movie.datasource.MovieLocalDataSource
import com.example.tmdbclient.data.Repository.Repository.Movie.datasource.MovieRemoteDataSource
import com.example.tmdbclient.data.Repository.Repository.Person.datasource.PersonCacheDataSource
import com.example.tmdbclient.data.Repository.Repository.Person.datasource.PersonLocalDataSource
import com.example.tmdbclient.data.Repository.Repository.Person.datasource.PersonRemoteDataSource
import retrofit2.Response
import java.lang.Exception

class PersonRepositoryImpl(
   private val personRemoteDataSource: PersonRemoteDataSource,
   private val personLocalDataSource: PersonLocalDataSource,
   private val personCacheDataSource: PersonCacheDataSource
) : PersonRepository {

    suspend fun getPersonFromAPI() : List<Person>{
        lateinit var personList: List<Person>
        try {
            val response : Response<PersonList>  = personRemoteDataSource.getPerson()
            val body : PersonList? = response.body()
            if (body != null)
            {
                personList = body.persons
            }

        }catch (exception : Exception)
        {
            Log.i("MyTag", exception.message.toString())
        }
        return personList
    }

    suspend fun getPersonFromDB() : List<Person>{
        lateinit var personList: List<Person>
        try {
            personList = personLocalDataSource.getPersonFromDB()

        }catch (exception : Exception)
        {
            Log.i("MyTag", exception.message.toString())
        }
        if(personList.size > 0)
        {
            return personList
        }
        else
        {
            personList = getPersonFromAPI()
            personLocalDataSource.savePersonToDB(personList)
        }
        return personList
    }

    suspend fun getPersonFromCache() : List<Person>{
        lateinit var personList: List<Person>
        try {
            personList = personCacheDataSource.getPersonFromCache()

        }catch (exception : Exception)
        {
            Log.i("MyTag", exception.message.toString())
        }
        if(personList.size > 0)
        {
            return personList
        }
        else
        {
            personList = getPersonFromDB()
            personCacheDataSource.savePersonToCache(personList)
        }
        return personList
    }

    override suspend fun getPerson(): List<Person>? {
       return getPersonFromCache()
    }

    override suspend fun updatePerson(): List<Person>? {
        val newListOfPerson = getPersonFromAPI()
        personLocalDataSource.clearAll()
        personLocalDataSource.savePersonToDB(newListOfPerson)
        personCacheDataSource.savePersonToCache(newListOfPerson)
        return newListOfPerson
    }
}