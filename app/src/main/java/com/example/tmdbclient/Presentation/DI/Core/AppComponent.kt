package com.example.tmdbclient.Presentation.DI.Core

import com.example.tmdbclient.Presentation.DI.Movie.MovieSubComponent
import com.example.tmdbclient.Presentation.DI.Person.PersonSubComponent
import com.example.tmdbclient.Presentation.DI.TVShow.TVShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    CacheDataModule::class,
    DataBaseModule::class,
    LocalDataModule::class,
    NetModule::class,
    RemoteDataModule::class,
    RepositoryModule::class,
    UseCaseModule::class
])
interface AppComponent {

    fun movieSubComponent() : MovieSubComponent.Factory
    fun tvShowSubComponent() : TVShowSubComponent.Factory
    fun personSubComponent() : PersonSubComponent.Factory
}