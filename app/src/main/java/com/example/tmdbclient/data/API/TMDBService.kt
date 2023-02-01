package com.example.tmdbclient.data.API

import com.example.tmdbclient.data.Model.Movie.MovieList
import com.example.tmdbclient.data.Model.Person.PersonList
import com.example.tmdbclient.data.Model.TVShow.TVShowsList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key")apikey : String) : Response<MovieList>

    @GET("TV/popular")
    suspend fun getPopularTVShows(@Query("api_key")apikey : String) : Response<TVShowsList>

    @GET("person/popular")
    suspend fun getPopularPerson(@Query("api_key")apikey : String) : Response<PersonList>

}