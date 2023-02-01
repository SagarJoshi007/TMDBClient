package com.example.tmdbclient.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tmdbclient.data.Model.Movie.Movie
import com.example.tmdbclient.data.Model.Person.Person
import com.example.tmdbclient.data.Model.TVShow.TVShow

@Database(entities = [Movie::class, TVShow::class, Person::class], version = 1, exportSchema = false)
abstract class TMDBDatabase : RoomDatabase() {

    abstract fun movieDao() : MovieDao

    abstract fun tvShowDao() : TVShowDao

    abstract fun personDao() : PersonDao
}