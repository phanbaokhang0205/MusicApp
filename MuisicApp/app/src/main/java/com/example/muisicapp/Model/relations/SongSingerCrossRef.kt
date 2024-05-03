package com.example.muisicapp.Model.relations

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Junction
import androidx.room.Relation
import com.example.muisicapp.Model.data.Singer
import com.example.muisicapp.Model.data.Song

@Entity(primaryKeys = ["songId", "singerId"])
data class SongSingerCrossRef(
    val songId: Int,
    val singerId: Int,
)

data class SongWithSingers(
    @Embedded val song: Song,
    @Relation(
        parentColumn = "songId",
        entityColumn = "singerId",
        associateBy = Junction(SongSingerCrossRef::class)
    )
    val singers: List<Singer>
)

data class SingerWithSongs(
    @Embedded val singer: Singer,
    @Relation(
        parentColumn = "singerId",
        entityColumn = "songId",
        associateBy = Junction(SongSingerCrossRef::class)
    )
    val songs: List<Song>
)
