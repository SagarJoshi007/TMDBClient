package com.example.tmdbclient.Presentation.persons

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tmdbclient.Domain.UseCase.GetPersonUseCase
import com.example.tmdbclient.Domain.UseCase.UpdatePersonUseCase

class PersonViewModelFactory(
    private val getPersonUseCase: GetPersonUseCase,
    private val updatePersonUseCase: UpdatePersonUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PersonViewModel(getPersonUseCase, updatePersonUseCase) as T
    }
}