package com.example.muisicapp.Model.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = true) val userID: Int = 0,
    val fullName: String,
    val userName: String,
    val password: String
)
