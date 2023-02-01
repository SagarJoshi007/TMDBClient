package com.example.tmdbclient.data.Repository.Repository.Person.datasource

import com.example.tmdbclient.data.Model.Movie.MovieList
import com.example.tmdbclient.data.Model.Person.PersonList
import retrofit2.Response

interface PersonRemoteDataSource {

    suspend fun getPerson() : Response<PersonList>
}