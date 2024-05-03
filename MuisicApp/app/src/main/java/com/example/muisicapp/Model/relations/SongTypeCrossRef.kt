package com.example.muisicapp.Model.relations

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Junction
import androidx.room.Relation
import com.example.muisicapp.Model.data.Song
import com.example.muisicapp.Model.data.Type

@Entity(primaryKeys = ["songId", "typeId"])
data class SongTypeCrossRef(
    val songId: Int,
    val typeId: Int,
)

data class TypeWithSongs(
    @Embedded val type: Type,
    @Relation(
        parentColumn = "typeId",
        entityColumn = "songId",
        associateBy = Junction(SongTypeCrossRef::class)
    )
    val songs: List<Song>
)
