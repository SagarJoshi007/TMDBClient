package com.example.tmdbclient.Domain.UseCase

import com.example.tmdbclient.Domain.Repository.TVShowRepository
import com.example.tmdbclient.data.Model.TVShow.TVShow

class UpdateTVShowUSeCase(private val tvShowRepository : TVShowRepository) {

    suspend fun execute() : List<TVShow>? = tvShowRepository.updaetTvshow()
}