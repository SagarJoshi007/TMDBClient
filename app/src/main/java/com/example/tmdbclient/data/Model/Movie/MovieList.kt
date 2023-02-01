package com.example.tmdbclient.data.Model.Movie


import com.example.tmdbclient.data.Model.Movie.Movie
import com.google.gson.annotations.SerializedName

data class MovieList(
    @SerializedName("results")
    val movies: List<Movie>
)