package com.example.tmdbclient.Presentation.DI.Core

import com.example.tmdbclient.Domain.Repository.MovieRposirtory
import com.example.tmdbclient.Domain.Repository.PersonRepository
import com.example.tmdbclient.Domain.Repository.TVShowRepository
import com.example.tmdbclient.data.Repository.Repository.Movie.MovieRepositoryImpl
import com.example.tmdbclient.data.Repository.Repository.Movie.datasource.MovieCacheDataSource
import com.example.tmdbclient.data.Repository.Repository.Movie.datasource.MovieLocalDataSource
import com.example.tmdbclient.data.Repository.Repository.Movie.datasource.MovieRemoteDataSource
import com.example.tmdbclient.data.Repository.Repository.Person.PersonRepositoryImpl
import com.example.tmdbclient.data.Repository.Repository.Person.datasource.PersonCacheDataSource
import com.example.tmdbclient.data.Repository.Repository.Person.datasource.PersonLocalDataSource
import com.example.tmdbclient.data.Repository.Repository.Person.datasource.PersonRemoteDataSource
import com.example.tmdbclient.data.Repository.Repository.TVShow.TVShowRepositoryImpl
import com.example.tmdbclient.data.Repository.Repository.TVShow.datasource.TVShowCacheDataSource
import com.example.tmdbclient.data.Repository.Repository.TVShow.datasource.TVShowLocalDataSource
import com.example.tmdbclient.data.Repository.Repository.TVShow.datasource.TVShowRemoteDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ) : MovieRposirtory
    {
        return MovieRepositoryImpl(movieRemoteDataSource, movieLocalDataSource, movieCacheDataSource)
    }

    @Singleton
    @Provides
    fun provideTVShowRepository(
        tvShowRemoteDataSource: TVShowRemoteDataSource,
        tvShowLocalDataSource: TVShowLocalDataSource,
        tvShowCacheDataSource: TVShowCacheDataSource
    ) : TVShowRepository
    {
        return TVShowRepositoryImpl(tvShowRemoteDataSource, tvShowLocalDataSource, tvShowCacheDataSource)
    }

    @Singleton
    @Provides
    fun providePersonRepository(
        personRemoteDataSource: PersonRemoteDataSource,
        personLocalDataSource: PersonLocalDataSource,
        personCacheDataSource: PersonCacheDataSource
    ) : PersonRepository
    {
        return PersonRepositoryImpl(personRemoteDataSource, personLocalDataSource, personCacheDataSource)
    }
}