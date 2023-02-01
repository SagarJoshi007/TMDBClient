package com.example.tmdbclient.data.Repository.Repository.TVShow

import android.util.Log
import com.example.tmdbclient.Domain.Repository.MovieRposirtory
import com.example.tmdbclient.Domain.Repository.PersonRepository
import com.example.tmdbclient.Domain.Repository.TVShowRepository
import com.example.tmdbclient.data.Model.Movie.Movie
import com.example.tmdbclient.data.Model.Movie.MovieList
import com.example.tmdbclient.data.Model.Person.Person
import com.example.tmdbclient.data.Model.Person.PersonList
import com.example.tmdbclient.data.Model.TVShow.TVShow
import com.example.tmdbclient.data.Model.TVShow.TVShowsList
import com.example.tmdbclient.data.Repository.Repository.Movie.datasource.MovieCacheDataSource
import com.example.tmdbclient.data.Repository.Repository.Movie.datasource.MovieLocalDataSource
import com.example.tmdbclient.data.Repository.Repository.Movie.datasource.MovieRemoteDataSource
import com.example.tmdbclient.data.Repository.Repository.Person.datasource.PersonCacheDataSource
import com.example.tmdbclient.data.Repository.Repository.Person.datasource.PersonLocalDataSource
import com.example.tmdbclient.data.Repository.Repository.Person.datasource.PersonRemoteDataSource
import com.example.tmdbclient.data.Repository.Repository.TVShow.datasource.TVShowCacheDataSource
import com.example.tmdbclient.data.Repository.Repository.TVShow.datasource.TVShowLocalDataSource
import com.example.tmdbclient.data.Repository.Repository.TVShow.datasource.TVShowRemoteDataSource
import retrofit2.Response
import java.lang.Exception

class TVShowRepositoryImpl(
    private val tvShowRemoteDataSource: TVShowRemoteDataSource,
    private val tvShowLocalDataSource: TVShowLocalDataSource,
    private val tvShowCacheDataSource: TVShowCacheDataSource
) : TVShowRepository {

    suspend fun getTvShowFromAPI() : List<TVShow>{
        lateinit var tvShowList: List<TVShow>
        try {
            val response : Response<TVShowsList>  = tvShowRemoteDataSource.getTvShows()
            val body : TVShowsList? = response.body()
            if (body != null)
            {
                tvShowList = body.tvShows
            }

        }catch (exception : Exception)
        {
            Log.i("MyTag", exception.message.toString())
        }
        return tvShowList
    }

    suspend fun getTvShowFromDB() : List<TVShow>{
        lateinit var tvShowList: List<TVShow>
        try {
            tvShowList = tvShowLocalDataSource.getTvShowFromDB()

        }catch (exception : Exception)
        {
            Log.i("MyTag", exception.message.toString())
        }
        if(tvShowList.size > 0)
        {
            return tvShowList
        }
        else
        {
            tvShowList = getTvShowFromAPI()
            tvShowLocalDataSource.saveTvShowToDB(tvShowList)
        }
        return tvShowList
    }

    suspend fun getTvShowFromCache() : List<TVShow>{
        lateinit var tvShowList: List<TVShow>
        try {
            tvShowList = tvShowCacheDataSource.getTvShowFromCache()

        }catch (exception : Exception)
        {
            Log.i("MyTag", exception.message.toString())
        }
        if(tvShowList.size > 0)
        {
            return tvShowList
        }
        else
        {
            tvShowList = getTvShowFromDB()
            tvShowCacheDataSource.saveTvShowToCache(tvShowList)
        }
        return tvShowList
    }

    override suspend fun getTvshow(): List<TVShow>? {
        return getTvShowFromCache()
    }

    override suspend fun updaetTvshow(): List<TVShow>? {
        val newListOfTvShow = getTvShowFromAPI()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShowToDB(newListOfTvShow)
        tvShowCacheDataSource.saveTvShowToCache(newListOfTvShow)
        return newListOfTvShow
    }
}