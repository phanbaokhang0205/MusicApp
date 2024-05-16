package com.example.muisicapp.Model.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.muisicapp.Model.data.Album
import com.example.muisicapp.Model.data.Song

data class AlbumWithSongsAndSingers(
    @Embedded val album: Album,
    @Relation(
        entity = Song::class,
        parentColumn = "albumId",
        entityColumn = "albumId"
    )
    val songsWithSingers: List<SongWithSingers>
)

