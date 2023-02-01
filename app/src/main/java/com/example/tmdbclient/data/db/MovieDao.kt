package com.example.tmdbclient.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tmdbclient.data.Model.Movie.Movie

@Dao
interface MovieDao {

    @Query("SELECT * FROM popular_movies")
    suspend fun getMovieList() : List<Movie>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movies : List<Movie>)

    @Query("DELETE FROM popular_movies")
    suspend fun deleteAllMovies()
}