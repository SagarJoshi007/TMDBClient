package com.example.tmdbclient.Domain.Repository

import com.example.tmdbclient.data.Model.Movie.Movie

interface MovieRposirtory {

    suspend fun getMovies() : List<Movie>?
    suspend fun updateMovies() : List<Movie>?

}