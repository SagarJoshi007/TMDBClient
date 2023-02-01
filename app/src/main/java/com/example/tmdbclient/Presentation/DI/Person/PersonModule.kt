package com.example.tmdbclient.Presentation.DI.Person

import com.example.tmdbclient.Domain.UseCase.GetPersonUseCase
import com.example.tmdbclient.Domain.UseCase.UpdatePersonUseCase
import com.example.tmdbclient.Presentation.persons.PersonViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class PersonModule {

    @PersonScope
    @Provides
    fun providePersonViewModelFactory(
        getPersonUseCase: GetPersonUseCase,
        updatePersonUseCase: UpdatePersonUseCase) : PersonViewModelFactory
    {
        return PersonViewModelFactory(getPersonUseCase, updatePersonUseCase)
    }
}