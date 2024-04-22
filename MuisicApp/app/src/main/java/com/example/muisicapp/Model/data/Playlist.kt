package com.example.muisicapp.Model.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Playlist")
data class Playlist(
    @PrimaryKey(autoGenerate = true) val idPlaylist: Int? = 0,
    @ColumnInfo val namePlaylist: String,
    @ColumnInfo val imagePlaylist: String,
)