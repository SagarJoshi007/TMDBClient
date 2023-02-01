package com.example.tmdbclient.data.Repository.Repository.TVShow.datasourceImpl

import com.example.tmdbclient.data.Model.Movie.Movie
import com.example.tmdbclient.data.Model.Person.Person
import com.example.tmdbclient.data.Model.TVShow.TVShow
import com.example.tmdbclient.data.Repository.Repository.Movie.datasource.MovieLocalDataSource
import com.example.tmdbclient.data.Repository.Repository.Person.datasource.PersonLocalDataSource
import com.example.tmdbclient.data.Repository.Repository.TVShow.datasource.TVShowLocalDataSource
import com.example.tmdbclient.data.db.MovieDao
import com.example.tmdbclient.data.db.PersonDao
import com.example.tmdbclient.data.db.TVShowDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TVShowLocalDataSourceImpl(private val tvShowDao: TVShowDao) : TVShowLocalDataSource {

    override suspend fun getTvShowFromDB(): List<TVShow> = tvShowDao.getTvShowList()

    override suspend fun saveTvShowToDB(tvShow: List<TVShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.saveTvShow(tvShow)
        }
    }

    override suspend fun clearAll(){
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.deleteAllTvSHow()
        }
    }
}