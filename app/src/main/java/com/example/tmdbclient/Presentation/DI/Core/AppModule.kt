package com.example.tmdbclient.Presentation.DI.Core

import android.content.Context
import com.example.tmdbclient.Presentation.DI.Movie.MovieSubComponent
import com.example.tmdbclient.Presentation.DI.Person.PersonSubComponent
import com.example.tmdbclient.Presentation.DI.TVShow.TVShowSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [MovieSubComponent::class,
PersonSubComponent::class,
TVShowSubComponent::class])
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideApplicationContext() : Context{
        return context.applicationContext
    }
}