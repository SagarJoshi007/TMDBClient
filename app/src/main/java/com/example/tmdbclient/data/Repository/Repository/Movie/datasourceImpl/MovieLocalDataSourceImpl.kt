package com.example.tmdbclient.data.Repository.Repository.Movie.datasourceImpl

import com.example.tmdbclient.data.Model.Movie.Movie
import com.example.tmdbclient.data.Repository.Repository.Movie.datasource.MovieLocalDataSource
import com.example.tmdbclient.data.db.MovieDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSourceImpl(private val movieDao: MovieDao) : MovieLocalDataSource {

    override suspend fun getMoviesFromDB(): List<Movie> = movieDao.getMovieList()

    override suspend fun saveMoviesToDB(movies: List<Movie>){
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.saveMovies(movies)
        }
    }

    override suspend fun clearAll(){
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.deleteAllMovies()
        }
    }
}