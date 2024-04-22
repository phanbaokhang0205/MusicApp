package com.example.muisicapp.Model.data

import kotlinx.coroutines.flow.Flow

interface SongsRepository {
    fun getAllSongsStream(): Flow<List<Song>>

    suspend fun insertSong(song: Song)

    suspend fun updateSong(song: Song)

    suspend fun deleteSong(song: Song)

}