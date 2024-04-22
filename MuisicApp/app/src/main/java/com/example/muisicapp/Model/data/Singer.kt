package com.example.muisicapp.Model.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Singer")
data class Singer(
    @PrimaryKey(autoGenerate = true) val idSinger: Int? = 0,
    @ColumnInfo val nameSinger: String,
)