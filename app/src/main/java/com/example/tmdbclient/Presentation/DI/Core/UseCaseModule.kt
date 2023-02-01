package com.example.tmdbclient.Presentation.DI.Core

import com.example.tmdbclient.Domain.Repository.MovieRposirtory
import com.example.tmdbclient.Domain.Repository.PersonRepository
import com.example.tmdbclient.Domain.Repository.TVShowRepository
import com.example.tmdbclient.Domain.UseCase.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Provides
    fun provideGetMovieUseCase(movieRposirtory: MovieRposirtory) : GetMoviesUseCase
    {
        return GetMoviesUseCase(movieRposirtory)
    }

    @Provides
    fun provideUpdateMovieUseCase(movieRposirtory: MovieRposirtory) : UpdateMovieUseCase
    {
        return UpdateMovieUseCase(movieRposirtory)
    }

    @Provides
    fun provideGetTVShowUseCase(tvShowRepository: TVShowRepository) : GetTVShowUseCase
    {
        return GetTVShowUseCase(tvShowRepository)
    }

    @Provides
    fun provideUpdateTVShowUseCase(tvShowRepository: TVShowRepository) : UpdateTVShowUSeCase
    {
        return UpdateTVShowUSeCase(tvShowRepository)
    }

    @Provides
    fun provideGetPersonUseCase(personRepository: PersonRepository) : GetPersonUseCase
    {
        return GetPersonUseCase(personRepository)
    }

    @Provides
    fun provideUpdatePersonUseCase(personRepository: PersonRepository) : UpdatePersonUseCase
    {
        return UpdatePersonUseCase(personRepository)
    }
}