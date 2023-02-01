package com.example.tmdbclient.Presentation.DI.Movie

import com.example.tmdbclient.Domain.UseCase.GetMoviesUseCase
import com.example.tmdbclient.Domain.UseCase.GetPersonUseCase
import com.example.tmdbclient.Domain.UseCase.UpdateMovieUseCase
import com.example.tmdbclient.Domain.UseCase.UpdatePersonUseCase
import com.example.tmdbclient.Presentation.movie.MovieViewModelFactory
import com.example.tmdbclient.Presentation.persons.PersonViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMovieUseCase: UpdateMovieUseCase) : MovieViewModelFactory
    {
        return MovieViewModelFactory(getMoviesUseCase, updateMovieUseCase)
    }
}