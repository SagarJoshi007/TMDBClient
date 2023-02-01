package com.example.tmdbclient.Domain.UseCase

import com.example.tmdbclient.Domain.Repository.PersonRepository
import com.example.tmdbclient.data.Model.Person.Person

class GetPersonUseCase(private val personRepository : PersonRepository) {

    suspend fun execute() : List<Person>? = personRepository.getPerson()
}