package com.example.muisicapp.Model.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.muisicapp.Model.data.Playlist
import com.example.muisicapp.Model.data.Song

data class PlaylistWithSongsAndSingers(
    @Embedded val playlist: Playlist,
    @Relation(
        entity = Song::class,
        parentColumn = "playlistId",
        entityColumn = "songId",
        associateBy = Junction(SongPlaylistCrossRef::class)
    )
    val songsWithSingers: List<SongWithSingers>,

)
