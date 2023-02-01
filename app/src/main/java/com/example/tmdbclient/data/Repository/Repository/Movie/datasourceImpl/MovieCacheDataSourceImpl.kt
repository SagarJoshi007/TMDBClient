package com.example.tmdbclient.data.Repository.Repository.Movie.datasourceImpl

import com.example.tmdbclient.data.Model.Movie.Movie
import com.example.tmdbclient.data.Repository.Repository.Movie.datasource.MovieCacheDataSource

class MovieCacheDataSourceImpl() : MovieCacheDataSource {

    private var movieList = ArrayList<Movie>()

    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMovieToCache(movies: List<Movie>) {

        movieList.clear()
        movieList = ArrayList(movies)
    }

}