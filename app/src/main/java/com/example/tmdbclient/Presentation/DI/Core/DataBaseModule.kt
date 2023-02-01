package com.example.tmdbclient.Presentation.DI.Core

import android.content.Context
import androidx.room.Room
import com.example.tmdbclient.data.db.MovieDao
import com.example.tmdbclient.data.db.PersonDao
import com.example.tmdbclient.data.db.TMDBDatabase
import com.example.tmdbclient.data.db.TVShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Singleton
    @Provides
    fun provideMovieDataBase(context: Context) : TMDBDatabase
    {
        return Room.databaseBuilder(context, TMDBDatabase::class.java, "tmdbclient")
            .build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase) : MovieDao
    {
        return tmdbDatabase.movieDao()
    }

    @Singleton
    @Provides
    fun provideTVDao(tmdbDatabase: TMDBDatabase) : TVShowDao
    {
        return tmdbDatabase.tvShowDao()
    }

    @Singleton
    @Provides
    fun providePersonDao(tmdbDatabase: TMDBDatabase) : PersonDao
    {
        return tmdbDatabase.personDao()
    }
}