package com.example.tmdbclient.Presentation.DI.Movie

import com.example.tmdbclient.Presentation.movie.MovieActivity
import com.example.tmdbclient.Presentation.persons.PersonsActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {

    fun inject (movieActivity: MovieActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create() : MovieSubComponent
    }
}