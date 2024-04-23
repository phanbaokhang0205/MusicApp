package com.example.muisicapp.Model.relations

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Junction
import androidx.room.Relation
import com.example.muisicapp.Model.data.Playlist
import com.example.muisicapp.Model.data.Song

@Entity(primaryKeys = ["songId", "playlistId"])
data class SongPlaylistCrossRef(
    val songId: Int,
    val playlistId: Int
)

data class PlaylistWithSongs(
    @Embedded val playlist: Playlist,
    @Relation(
        parentColumn = "playlistId",
        entityColumn = "songId",
        associateBy = Junction(SongPlaylistCrossRef::class)
    )
    val songs: List<Song>

)

data class SongWithPlaylists(
    @Embedded val song: Song,
    @Relation(
        parentColumn = "songId",
        entityColumn = "playlistId",
        associateBy = Junction(SongPlaylistCrossRef::class)
    )
    val playlists: List<Playlist>

)
