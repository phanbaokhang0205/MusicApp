package com.example.muisicapp.Model.repository

import com.example.muisicapp.Model.data.MusicDao
import com.example.muisicapp.Model.data.Singer
import com.example.muisicapp.Model.data.Song
import kotlinx.coroutines.flow.Flow

class OfflineMusicRepository(private val musicDao: MusicDao) : MusicRepository {
    override fun getAllSongsStream(): Flow<List<Song>> {
        return musicDao.getAllSongs()
    }

    override fun getAllSingersStream(): Flow<List<Singer>> {
        return musicDao.getAllSingers()
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