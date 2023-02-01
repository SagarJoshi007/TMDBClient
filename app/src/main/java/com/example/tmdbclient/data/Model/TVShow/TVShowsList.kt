package com.example.tmdbclient.data.Model.TVShow


import com.example.tmdbclient.data.Model.TVShow.TVShow
import com.google.gson.annotations.SerializedName

data class TVShowsList(

    @SerializedName("results")
    val tvShows: List<TVShow>)