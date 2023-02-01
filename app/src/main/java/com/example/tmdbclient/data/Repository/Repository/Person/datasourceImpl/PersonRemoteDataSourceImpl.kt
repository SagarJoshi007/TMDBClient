package com.example.tmdbclient.data.Repository.Repository.Person.datasourceImpl

import com.example.tmdbclient.data.API.TMDBService
import com.example.tmdbclient.data.Model.Movie.MovieList
import com.example.tmdbclient.data.Model.Person.PersonList
import com.example.tmdbclient.data.Repository.Repository.Movie.datasource.MovieRemoteDataSource
import com.example.tmdbclient.data.Repository.Repository.Person.datasource.PersonRemoteDataSource
import retrofit2.Response

class PersonRemoteDataSourceImpl(
    private val tmdbService : TMDBService,
    private val apiKey : String) : PersonRemoteDataSource {

    override suspend fun getPerson(): Response<PersonList> = tmdbService.getPopularPerson(apiKey)
}