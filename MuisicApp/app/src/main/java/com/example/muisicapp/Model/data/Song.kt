package com.example.muisicapp.Model.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Song")
data class Song(
    @PrimaryKey(autoGenerate = true) val idSong: Int? = 0,
    @ColumnInfo val nameSong: String,
    @ColumnInfo val imageSong: String,
//    @ColumnInfo val Singer: String,
    @ColumnInfo val linkSong: String,
)