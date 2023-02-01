package com.example.tmdbclient.Presentation.persons

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdbclient.Domain.UseCase.GetPersonUseCase
import com.example.tmdbclient.Domain.UseCase.UpdatePersonUseCase

class PersonViewModel(
    private val getPersonUseCase: GetPersonUseCase,
    private val updatePersonUseCase: UpdatePersonUseCase
) : ViewModel() {

    fun getPerson() = liveData {
        val personList = getPersonUseCase.execute()
        emit(personList)
    }

    fun updatePerson() = liveData {

        val personList = updatePersonUseCase.execute()
        emit(personList)
    }
}