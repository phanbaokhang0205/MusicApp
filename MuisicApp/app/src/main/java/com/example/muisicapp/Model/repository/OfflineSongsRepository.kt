package com.example.muisicapp.Model.repository

import com.example.muisicapp.Model.data.MusicDao
import com.example.muisicapp.Model.data.Song
import kotlinx.coroutines.flow.Flow

class OfflineSongsRepository(private val musicDao: MusicDao) : SongsRepository {
    override fun getAllSongsStream(): Flow<List<Song>> {
        return musicDao.getAllSongs()
    }

    override suspend fun insertSong(song: Song) {
        return musicDao.insertSong(song)
    }

    override suspend fun updateSong(song: Song) {
        return musicDao.update(song)
    }

    override suspend fun deleteSong(song: Song) {
        return musicDao.delete(song)
    }
}