package com.example.muisicapp.Model.data

import kotlinx.coroutines.flow.Flow

class OfflineSongsRepository(private val songDao: SongDao) : SongsRepository {
    override fun getAllSongsStream(): Flow<List<Song>> {
        return songDao.getAllSongs()
    }

    override suspend fun insertSong(song: Song) {
        return songDao.insert(song)
    }

    override suspend fun updateSong(song: Song) {
        return songDao.update(song)
    }

    override suspend fun deleteSong(song: Song) {
        return songDao.delete(song)
    }
}