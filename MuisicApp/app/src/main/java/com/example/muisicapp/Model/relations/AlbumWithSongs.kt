package com.example.muisicapp.Model.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.muisicapp.Model.data.Album
import com.example.muisicapp.Model.data.Song

data class AlbumWithSongs(
    @Embedded val album: Album,
    @Relation(
        parentColumn = "albumId",
        entityColumn = "albumId",
    )
    val song: List<Song>,
)
