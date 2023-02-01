package com.example.tmdbclient.Presentation.DI.TVShow

import com.example.tmdbclient.Presentation.tvshow.TvShowActivity
import dagger.Subcomponent

@TVShowScope
@Subcomponent(modules = [TVShowModule::class])
interface TVShowSubComponent {

    fun inject (tvShowActivity: TvShowActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create() : TVShowSubComponent
    }
}