package com.example.tmdbclient.data.Repository.Repository.TVShow.datasourceImpl

import android.app.Person
import com.example.tmdbclient.data.Model.Movie.Movie
import com.example.tmdbclient.data.Model.TVShow.TVShow
import com.example.tmdbclient.data.Repository.Repository.Movie.datasource.MovieCacheDataSource
import com.example.tmdbclient.data.Repository.Repository.Person.datasource.PersonCacheDataSource
import com.example.tmdbclient.data.Repository.Repository.TVShow.datasource.TVShowCacheDataSource

class TVShowCacheDataSourceImpl() : TVShowCacheDataSource {

    private var tvShowList = ArrayList<TVShow>()

    override suspend fun saveTvShowToCache(tvShow: List<TVShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvShow)
    }

    override suspend fun getTvShowFromCache(): List<TVShow>{
        return tvShowList
    }

}