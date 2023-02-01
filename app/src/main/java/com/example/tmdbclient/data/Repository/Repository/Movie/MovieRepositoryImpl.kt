package com.example.tmdbclient.data.Repository.Repository.Movie

import android.util.Log
import com.example.tmdbclient.Domain.Repository.MovieRposirtory
import com.example.tmdbclient.data.Model.Movie.Movie
import com.example.tmdbclient.data.Model.Movie.MovieList
import com.example.tmdbclient.data.Repository.Repository.Movie.datasource.MovieCacheDataSource
import com.example.tmdbclient.data.Repository.Repository.Movie.datasource.MovieLocalDataSource
import com.example.tmdbclient.data.Repository.Repository.Movie.datasource.MovieRemoteDataSource
import retrofit2.Response
import java.lang.Exception

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRposirtory {
    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies = getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newListOfMovies)
        movieCacheDataSource.saveMovieToCache(newListOfMovies)
        return newListOfMovies
    }

    suspend fun getMoviesFromAPI() : List<Movie>{
        lateinit var movieList: List<Movie>
        try {
            val response : Response<MovieList>  = movieRemoteDataSource.getMovies()
            val body : MovieList? = response.body()
            if (body != null)
            {
                movieList = body.movies
            }

        }catch (exception : Exception)
        {
            Log.i("MyTag", exception.message.toString())
        }
        return movieList
    }

    suspend fun getMoviesFromDB() : List<Movie>
    {
        lateinit var movieList: List<Movie>
        try {
            movieList = movieLocalDataSource.getMoviesFromDB()

        }catch (exception : Exception)
        {
            Log.i("MyTag", exception.message.toString())
        }
        if(movieList.size > 0)
        {
            return movieList
        }
        else
        {
            movieList = getMoviesFromAPI()
            movieLocalDataSource.saveMoviesToDB(movieList)
        }
        return movieList
    }

    suspend fun getMoviesFromCache() : List<Movie>
    {
        lateinit var movieList: List<Movie>
        try {
            movieList = movieCacheDataSource.getMoviesFromCache()

        }catch (exception : Exception)
        {
            Log.i("MyTag", exception.message.toString())
        }
        if(movieList.size > 0)
        {
            return movieList
        }
        else
        {
            movieList = getMoviesFromDB()
            movieCacheDataSource.saveMovieToCache(movieList)
        }
        return movieList
    }
}