package com.example.tmdbclient.data.Repository.Repository.Movie.datasource

import com.example.tmdbclient.data.Model.Movie.Movie

interface MovieLocalDataSource {
    suspend fun getMoviesFromDB() : List<Movie>
    suspend fun saveMoviesToDB(movies : List<Movie>)
    suspend fun clearAll()
}