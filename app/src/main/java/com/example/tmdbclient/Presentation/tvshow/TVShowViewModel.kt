package com.example.tmdbclient.Presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdbclient.Domain.UseCase.GetTVShowUseCase
import com.example.tmdbclient.Domain.UseCase.UpdateTVShowUSeCase

class TVShowViewModel(
    private val getTVShowUseCase: GetTVShowUseCase,
    private val updateTVShowUSeCase: UpdateTVShowUSeCase
) : ViewModel(){

    fun getTVShow() = liveData {
        val tvShowList = getTVShowUseCase.execute()
        emit(tvShowList)
    }

    fun updateTVShow() = liveData {

        val tvShowList = updateTVShowUSeCase.execute()
        emit(tvShowList)
    }
}