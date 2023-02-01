package com.example.tmdbclient.data.Repository.Repository.Movie.datasourceImpl

import com.example.tmdbclient.data.API.TMDBService
import com.example.tmdbclient.data.Model.Movie.MovieList
import com.example.tmdbclient.data.Repository.Repository.Movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val tmdbService : TMDBService,
    private val apiKey : String) : MovieRemoteDataSource {

    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)
}