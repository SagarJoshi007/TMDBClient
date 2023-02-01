package com.example.tmdbclient.data.Repository.Repository.TVShow.datasourceImpl

import com.example.tmdbclient.data.API.TMDBService
import com.example.tmdbclient.data.Model.Movie.MovieList
import com.example.tmdbclient.data.Model.Person.PersonList
import com.example.tmdbclient.data.Model.TVShow.TVShowsList
import com.example.tmdbclient.data.Repository.Repository.Movie.datasource.MovieRemoteDataSource
import com.example.tmdbclient.data.Repository.Repository.Person.datasource.PersonRemoteDataSource
import com.example.tmdbclient.data.Repository.Repository.TVShow.datasource.TVShowRemoteDataSource
import retrofit2.Response

class TVShowRemoteDataSourceImpl(
    private val tmdbService : TMDBService,
    private val apiKey : String) : TVShowRemoteDataSource {

    override suspend fun getTvShows(): Response<TVShowsList> = tmdbService.getPopularTVShows(apiKey)
}