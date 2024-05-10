package com.example.muisicapp.Model.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.muisicapp.Model.data.Playlist
import com.example.muisicapp.Model.data.User

data class UserWithPlaylists(
    @Embedded val user: User,
    @Relation(
        parentColumn = "userID",
        entityColumn = "userID",
    )
    val playlists: List <Playlist>
)
