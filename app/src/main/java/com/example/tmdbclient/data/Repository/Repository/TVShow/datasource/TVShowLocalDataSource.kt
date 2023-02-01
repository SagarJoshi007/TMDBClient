package com.example.tmdbclient.data.Repository.Repository.TVShow.datasource

import com.example.tmdbclient.data.Model.Movie.Movie
import com.example.tmdbclient.data.Model.Person.Person
import com.example.tmdbclient.data.Model.TVShow.TVShow

interface TVShowLocalDataSource {
    suspend fun getTvShowFromDB() : List<TVShow>
    suspend fun saveTvShowToDB(tvShow : List<TVShow>)
    suspend fun clearAll()
}