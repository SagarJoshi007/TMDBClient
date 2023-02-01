package com.example.tmdbclient.Domain.UseCase

import com.example.tmdbclient.Domain.Repository.MovieRposirtory
import com.example.tmdbclient.data.Model.Movie.Movie

class UpdateMovieUseCase(private val movieRepository  : MovieRposirtory) {

    suspend fun execute() : List<Movie>? = movieRepository.updateMovies()
}