package com.example.tmdbclient.data.Repository.Repository.TVShow.datasource

import com.example.tmdbclient.data.Model.Movie.Movie
import com.example.tmdbclient.data.Model.Person.Person
import com.example.tmdbclient.data.Model.TVShow.TVShow
import com.example.tmdbclient.data.db.PersonDao

interface TVShowCacheDataSource {
    suspend fun saveTvShowToCache(tvShow : List<TVShow>)
    suspend fun getTvShowFromCache() : List<TVShow>
}