package com.example.tmdbclient.data.Model.Person


import com.example.tmdbclient.data.Model.Person.Person
import com.google.gson.annotations.SerializedName

data class PersonList(
    @SerializedName("results")
    val persons: List<Person>
)