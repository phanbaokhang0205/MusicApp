package com.example.muisicapp.Model.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "Song")
data class Song(
    @PrimaryKey(autoGenerate = true) val songId: Int? = 0,
    @ColumnInfo val songName: String,
    @ColumnInfo val songImage: String,
    @ColumnInfo val songLink: String,
    @ColumnInfo val albumId: Int,
)

