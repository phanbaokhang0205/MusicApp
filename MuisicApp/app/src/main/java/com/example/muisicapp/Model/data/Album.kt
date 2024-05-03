package com.example.muisicapp.Model.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Album")
data class Album(
    @PrimaryKey(autoGenerate = true) val albumId: Int? = 0,
    @ColumnInfo val albumName: String,
    @ColumnInfo val albumImage: String? = null,
    @ColumnInfo val singerId: Int,
)