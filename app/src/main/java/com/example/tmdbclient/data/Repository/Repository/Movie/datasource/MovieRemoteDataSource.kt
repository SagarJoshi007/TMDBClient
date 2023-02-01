package com.example.tmdbclient.data.Repository.Repository.Movie.datasource

import com.example.tmdbclient.data.Model.Movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {

    suspend fun getMovies() : Response<MovieList>
}