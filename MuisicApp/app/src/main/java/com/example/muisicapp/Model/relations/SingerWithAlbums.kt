package com.example.muisicapp.Model.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.muisicapp.Model.data.Album
import com.example.muisicapp.Model.data.Singer

data class SingerWithAlbums(
    @Embedded val singer: Singer,
    @Relation(
        parentColumn = "singerId",
        entityColumn = "singerId",
    )
    val albums: List<Album>,
)
