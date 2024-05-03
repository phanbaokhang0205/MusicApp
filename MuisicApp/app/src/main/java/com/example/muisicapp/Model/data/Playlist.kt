package com.example.muisicapp.Model.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Playlist")
data class Playlist(
    @PrimaryKey(autoGenerate = true) val playlistId: Int? = 0,
    @ColumnInfo val playlistName: String,
    @ColumnInfo val playlistImage: String,

)