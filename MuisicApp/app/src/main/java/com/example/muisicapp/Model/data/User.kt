package com.example.muisicapp.Model.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "User")
data class User(
    @PrimaryKey(autoGenerate = true) val userID: Int? = 0,
    @ColumnInfo val fullName:String,
    @ColumnInfo val userName:String,
    @ColumnInfo val password:String,
)