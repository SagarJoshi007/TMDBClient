package com.example.tmdbclient.Presentation.DI.Core

import com.example.tmdbclient.data.API.TMDBService
import com.example.tmdbclient.data.Repository.Repository.Movie.datasource.MovieRemoteDataSource
import com.example.tmdbclient.data.Repository.Repository.Movie.datasourceImpl.MovieRemoteDataSourceImpl
import com.example.tmdbclient.data.Repository.Repository.Person.datasource.PersonRemoteDataSource
import com.example.tmdbclient.data.Repository.Repository.Person.datasourceImpl.PersonRemoteDataSourceImpl
import com.example.tmdbclient.data.Repository.Repository.TVShow.datasource.TVShowRemoteDataSource
import com.example.tmdbclient.data.Repository.Repository.TVShow.datasourceImpl.TVShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey : String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService) : MovieRemoteDataSource
    {
        return MovieRemoteDataSourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun provideTVShowRemoteDataSource(tmdbService: TMDBService) : TVShowRemoteDataSource
    {
        return TVShowRemoteDataSourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun providePersonRemoteDataSource(tmdbService: TMDBService) : PersonRemoteDataSource
    {
        return PersonRemoteDataSourceImpl(tmdbService, apiKey)
    }
}