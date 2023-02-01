package com.example.tmdbclient.Presentation.DI.Core

import com.example.tmdbclient.data.Repository.Repository.Movie.datasource.MovieLocalDataSource
import com.example.tmdbclient.data.Repository.Repository.Movie.datasourceImpl.MovieLocalDataSourceImpl
import com.example.tmdbclient.data.Repository.Repository.Person.datasource.PersonLocalDataSource
import com.example.tmdbclient.data.Repository.Repository.Person.datasourceImpl.PersonLocalDataSourceImpl
import com.example.tmdbclient.data.Repository.Repository.TVShow.datasource.TVShowLocalDataSource
import com.example.tmdbclient.data.Repository.Repository.TVShow.datasourceImpl.TVShowLocalDataSourceImpl
import com.example.tmdbclient.data.db.MovieDao
import com.example.tmdbclient.data.db.PersonDao
import com.example.tmdbclient.data.db.TVShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource (movieDao: MovieDao) : MovieLocalDataSource
    {
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTVShowLocalDataSource (tvShowDao : TVShowDao) : TVShowLocalDataSource
    {
        return TVShowLocalDataSourceImpl(tvShowDao)
    }

    @Singleton
    @Provides
    fun providePersonLocalDataSource (personDao: PersonDao) : PersonLocalDataSource
    {
        return PersonLocalDataSourceImpl(personDao)
    }

}