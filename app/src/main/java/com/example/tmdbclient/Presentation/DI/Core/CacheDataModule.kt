package com.example.tmdbclient.Presentation.DI.Core

import com.example.tmdbclient.data.Repository.Repository.Movie.datasource.MovieCacheDataSource
import com.example.tmdbclient.data.Repository.Repository.Movie.datasourceImpl.MovieCacheDataSourceImpl
import com.example.tmdbclient.data.Repository.Repository.Person.datasource.PersonCacheDataSource
import com.example.tmdbclient.data.Repository.Repository.Person.datasourceImpl.PersonCacheDataSourceImpl
import com.example.tmdbclient.data.Repository.Repository.TVShow.datasource.TVShowCacheDataSource
import com.example.tmdbclient.data.Repository.Repository.TVShow.datasourceImpl.TVShowCacheDataSourceImpl
import com.example.tmdbclient.data.Repository.Repository.TVShow.datasourceImpl.TVShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource() : MovieCacheDataSource
    {
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTVShowCacheDataSource() : TVShowCacheDataSource
    {
        return TVShowCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun providePersonCacheDataSource() : PersonCacheDataSource
    {
        return PersonCacheDataSourceImpl()
    }
}