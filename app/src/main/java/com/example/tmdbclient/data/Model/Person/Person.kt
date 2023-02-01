package com.example.tmdbclient.data.Model.Person


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "popular_person")
data class Person(

    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    //@ColumnInfo(name = "person_name")
    @SerializedName("name")
    val name: String?,
    @SerializedName("popularity")
    val popularity: Double,
    @SerializedName("profile_path")
    val profilePath: String?
)