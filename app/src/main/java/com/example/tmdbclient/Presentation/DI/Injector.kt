package com.example.tmdbclient.Presentation.DI

import com.example.tmdbclient.Presentation.DI.Movie.MovieSubComponent
import com.example.tmdbclient.Presentation.DI.Person.PersonSubComponent
import com.example.tmdbclient.Presentation.DI.TVShow.TVShowSubComponent

interface Injector {

    fun createMovieSubComponent() : MovieSubComponent
    fun createTVShowSubComponent() : TVShowSubComponent
    fun createPersonSubComponent() : PersonSubComponent
}