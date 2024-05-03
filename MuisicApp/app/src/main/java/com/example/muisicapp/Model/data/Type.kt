package com.example.muisicapp.Model.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "typeOfSong")
data class Type (
    @PrimaryKey(autoGenerate = true) val typeId: Int? = 0,
    @ColumnInfo val typeName: String,
    @ColumnInfo val typeImage: String,
)