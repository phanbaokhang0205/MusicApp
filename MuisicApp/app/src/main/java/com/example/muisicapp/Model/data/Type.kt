package com.example.muisicapp.Model.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "typeOfSong")
data class Type (
    @PrimaryKey(autoGenerate = true) val idType: Int? = 0,
    @ColumnInfo val nameType: String,
    @ColumnInfo val imageType: String,
)