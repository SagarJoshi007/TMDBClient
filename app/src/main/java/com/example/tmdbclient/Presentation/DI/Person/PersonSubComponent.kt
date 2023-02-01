package com.example.tmdbclient.Presentation.DI.Person

import com.example.tmdbclient.Presentation.persons.PersonsActivity
import dagger.Subcomponent

@PersonScope
@Subcomponent(modules = [PersonModule::class])
interface PersonSubComponent {

    fun inject (personsActivity: PersonsActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create() : PersonSubComponent
    }
}