package com.example.tmdbclient.Presentation.DI.TVShow

import com.example.tmdbclient.Domain.UseCase.GetPersonUseCase
import com.example.tmdbclient.Domain.UseCase.GetTVShowUseCase
import com.example.tmdbclient.Domain.UseCase.UpdatePersonUseCase
import com.example.tmdbclient.Domain.UseCase.UpdateTVShowUSeCase
import com.example.tmdbclient.Presentation.persons.PersonViewModelFactory
import com.example.tmdbclient.Presentation.tvshow.TVShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TVShowModule {

    @TVShowScope
    @Provides
    fun provideTVShowViewModelFactory(
        getTVShowUseCase: GetTVShowUseCase,
        updateTVShowUSeCase: UpdateTVShowUSeCase) : TVShowViewModelFactory
    {
        return TVShowViewModelFactory(getTVShowUseCase, updateTVShowUSeCase)
    }
}