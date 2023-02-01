package com.example.tmdbclient.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tmdbclient.data.Model.TVShow.TVShow

@Dao
interface TVShowDao {

    @Query("SELECT * FROM popular_tvshow")
    suspend fun getTvShowList() : List<TVShow>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShow(tvShow : List<TVShow>)

    @Query("DELETE FROM popular_tvshow")
    suspend fun deleteAllTvSHow()
}