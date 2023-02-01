package com.example.tmdbclient.Presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tmdbclient.Domain.UseCase.GetTVShowUseCase
import com.example.tmdbclient.Domain.UseCase.UpdateTVShowUSeCase

class TVShowViewModelFactory(
    private val getTVShowUseCase: GetTVShowUseCase,
    private val updateTVShowUSeCase: UpdateTVShowUSeCase
) : ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TVShowViewModel(getTVShowUseCase, updateTVShowUSeCase) as T
    }
}