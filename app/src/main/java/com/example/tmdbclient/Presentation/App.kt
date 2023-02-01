package com.example.tmdbclient.Presentation

import android.app.Application
import com.example.tmdbclient.BuildConfig
import com.example.tmdbclient.Presentation.DI.Core.*
import com.example.tmdbclient.Presentation.DI.Injector
import com.example.tmdbclient.Presentation.DI.Movie.MovieSubComponent
import com.example.tmdbclient.Presentation.DI.Person.PersonSubComponent
import com.example.tmdbclient.Presentation.DI.TVShow.TVShowSubComponent

class App : Application(), Injector {

    private lateinit var appComponent : AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule("https://api.themoviedb.org/3/"))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTVShowSubComponent(): TVShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }

    override fun createPersonSubComponent(): PersonSubComponent {
        return appComponent.personSubComponent().create()
    }
}