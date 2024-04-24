package com.example.muisicapp.Model.repository

import com.example.muisicapp.Model.data.Singer
import com.example.muisicapp.Model.data.Song
import kotlinx.coroutines.flow.Flow

interface MusicRepository {
    fun getAllSongsStream(): Flow<List<Song>>
    fun getAllSingersStream(): Flow<List<Singer>>

    suspend fun insertSong(song: Song)

    suspend fun updateSong(song: Song)

    suspend fun deleteSong(song: Song)

}