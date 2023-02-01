package com.example.tmdbclient.data.Repository.Repository.Movie.datasource

import com.example.tmdbclient.data.Model.Movie.Movie

interface MovieCacheDataSource {
    suspend fun saveMovieToCache(movies : List<Movie>)
    suspend fun getMoviesFromCache() : List<Movie>
}