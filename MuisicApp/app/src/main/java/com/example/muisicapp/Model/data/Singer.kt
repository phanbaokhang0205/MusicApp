package com.example.muisicapp.Model.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "Singer")
data class Singer(
    @PrimaryKey(autoGenerate = true) val singerId: Int? = 0,
    @ColumnInfo val singerName: String,
    @ColumnInfo val singerImage: String,
    @ColumnInfo val singerInfo: String,
    @ColumnInfo val singerAge: String,
    @ColumnInfo val singerDOB: String,
)