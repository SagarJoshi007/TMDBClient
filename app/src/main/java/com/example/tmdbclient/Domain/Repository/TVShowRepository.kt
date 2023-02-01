package com.example.tmdbclient.Domain.Repository

import com.example.tmdbclient.data.Model.TVShow.TVShow

interface TVShowRepository {

    suspend fun getTvshow() : List<TVShow>?
    suspend fun updaetTvshow() : List<TVShow>?
}