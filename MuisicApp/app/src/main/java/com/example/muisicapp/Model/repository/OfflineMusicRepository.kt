package com.example.muisicapp.Model.repository

import com.example.muisicapp.Model.data.MusicDao
import com.example.muisicapp.Model.data.Singer
import com.example.muisicapp.Model.data.Song
import com.example.muisicapp.Model.data.User
import com.example.muisicapp.Model.relations.AlbumWithSongsAndSingers
import com.example.muisicapp.Model.relations.PlaylistWithSongsAndSingers
import com.example.muisicapp.Model.relations.SingerWithAlbums
import com.example.muisicapp.Model.relations.SingerWithSongs
import com.example.muisicapp.Model.relations.SongOfUsers
import com.example.muisicapp.Model.relations.SongUserCrossRef
import com.example.muisicapp.Model.relations.SongWithSingers
import com.example.muisicapp.Model.relations.UserWithSongs
import kotlinx.coroutines.flow.Flow

class OfflineMusicRepository(private val musicDao: MusicDao) : MusicRepository {

    /**
     * User
     */

    override suspend fun insert(user: User) {
        return musicDao.insert(user)
    }

    override suspend fun update(user: User) {
        TODO("Not yet implemented")
    }

    override fun delete(user: User) {
        TODO("Not yet implemented")
    }

    override fun getUserById(id: Int): Flow<User> {
        return musicDao.getUserById(id)
    }


    override fun getAllUsers(): List<User> {
        return musicDao.getAllUsers()
    }
    override fun getUser(username: String, password: String): User {
        return musicDao.getUser(username,password)
    }



    override fun getAllSongsStream(): Flow<List<Song>> {
        return musicDao.getAllSongs()
    }

    override fun getAllSingersStream(): Flow<List<Singer>> {
        return musicDao.getAllSingers()
    }

    override fun getUserWithSongsById(userID: Int): Flow<List<SongOfUsers>> {
        return musicDao.getUserWithSongsById(userID)
    }

    /**
     * Album
     */
    override fun getAllAlbums(): Flow<List<AlbumWithSongsAndSingers>> {
        return musicDao.getAllAlbums()
    }

    override fun getAlbumById(albumId: Int): Flow<AlbumWithSongsAndSingers> {
        return musicDao.getAlbumById(albumId)
    }

    override fun getAlbumsWithSingerId(singerId: Int): Flow<SingerWithAlbums> {
        return musicDao.getAlbumsWithSingerId(singerId)
    }

    /**
     * Playlist
     */
    override fun getAllPlayLists(): Flow<List<PlaylistWithSongsAndSingers>> {
        return musicDao.getAllPlayLists()
    }

    override fun getPlayListById(playListId: Int): Flow<PlaylistWithSongsAndSingers> {
        return musicDao.getPlayListById(playListId)
    }


    /**
     * Song
     */
    override fun getSongWithSingersById(songId: Int): Flow<SongWithSingers> {
        return musicDao.getSongWithSingersById(songId)
    }


    override fun getSongWithSingers(): Flow<List<SongWithSingers>> {
        return musicDao.getSongWithSingers()
    }

    /**
     * Singer
     */

    override fun getSingerWithSongsById(singerId: Int): Flow<SingerWithSongs> {
        return musicDao.getSingerWithSongsById(singerId)
    }

    override fun getSingerWithSongs(): Flow<List<SingerWithSongs>> {
        return musicDao.getSingerWithSongs()
    }

    override fun getSingerWithAlbumID(albumId: Int): Flow<SingerWithAlbums> {
        return musicDao.getSingerWithAlbumID(albumId)
    }

    /**
     * Search
     */

    override fun getSearchResult(
        name: String,
    ): Flow<List<SongWithSingers>> {
        return musicDao.getSearchResult(name)
    }

    /**
     * CRUD
     */

    override suspend fun insertSong(song: Song) {
        return musicDao.insertSong(song)
    }

    override suspend fun updateSong(song: Song) {
        return musicDao.update(song)
    }

    override suspend fun deleteSong(song: Song) {
        return musicDao.delete(song)
    }

    override suspend fun insertSongUserCrossRef(crossRef: SongUserCrossRef) {
        return musicDao.insertSongUserCrossRef(crossRef)
    }
}