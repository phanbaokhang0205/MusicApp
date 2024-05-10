package com.example.muisicapp.Model.repository

import androidx.room.Query
import com.example.muisicapp.Model.data.Singer
import com.example.muisicapp.Model.data.Song
import com.example.muisicapp.Model.relations.SingerWithSongs
import com.example.muisicapp.Model.relations.SongWithSingers
import kotlinx.coroutines.flow.Flow

interface MusicRepository {
    fun getAllSongsStream(): Flow<List<Song>>

    fun getAllSingersStream(): Flow<List<Singer>>

    fun getSongWithSingersById(songId: Int): Flow<SongWithSingers>

    fun getSongWithSingers(): Flow<List<SongWithSingers>>

    fun getSingerWithSongsById(singerId: Int): Flow<SingerWithSongs>

    fun getSingerWithSongs(): Flow<List<SingerWithSongs>>

    suspend fun insertSong(song: Song)

    suspend fun updateSong(song: Song)

    suspend fun deleteSong(song: Song)


}