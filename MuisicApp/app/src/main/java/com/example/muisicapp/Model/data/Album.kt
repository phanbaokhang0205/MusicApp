package com.example.muisicapp.Model.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Album")
data class Album(
    @PrimaryKey(autoGenerate = true) val idAlbum: Int? = 0,
    @ColumnInfo val nameAlbum: String

)