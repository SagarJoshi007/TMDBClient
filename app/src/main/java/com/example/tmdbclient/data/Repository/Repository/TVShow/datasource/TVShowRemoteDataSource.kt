package com.example.tmdbclient.data.Repository.Repository.TVShow.datasource

import com.example.tmdbclient.data.Model.Movie.MovieList
import com.example.tmdbclient.data.Model.Person.PersonList
import com.example.tmdbclient.data.Model.TVShow.TVShowsList
import retrofit2.Response

interface TVShowRemoteDataSource {

    suspend fun getTvShows() : Response<TVShowsList>
}