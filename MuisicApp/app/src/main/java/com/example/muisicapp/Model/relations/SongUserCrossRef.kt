package com.example.muisicapp.Model.relations

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Junction
import androidx.room.Relation
import com.example.muisicapp.Model.data.Song
import com.example.muisicapp.Model.data.User

@Entity(primaryKeys = ["songId", "userID"])
data class SongUserCrossRef(
    val songId: Int,
    val userID: Int,
)

data class SongOfUsers(
    @Embedded val song: SongWithSingers,
    @Relation(
        parentColumn = "songId",
        entityColumn = "userID",
        associateBy = Junction(SongUserCrossRef::class)
    )
    val users: List<User>
)

data class UserWithSongs(
    @Embedded val user: User,
    @Relation(
        parentColumn = "userID",
        entityColumn = "songId",
        associateBy = Junction(SongUserCrossRef::class)
    )
    val songs: List<SongWithSingers>
)