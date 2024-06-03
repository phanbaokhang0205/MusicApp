package com.example.muisicapp.Model.repository

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.muisicapp.Model.data.Album
import com.example.muisicapp.Model.data.Playlist
import com.example.muisicapp.Model.data.Singer
import com.example.muisicapp.Model.data.Song
import com.example.muisicapp.Model.data.User
import com.example.muisicapp.Model.relations.AlbumWithSongs
import com.example.muisicapp.Model.relations.AlbumWithSongsAndSingers
import com.example.muisicapp.Model.relations.PlaylistWithSongs
import com.example.muisicapp.Model.relations.PlaylistWithSongsAndSingers
import com.example.muisicapp.Model.relations.SingerWithAlbums
import com.example.muisicapp.Model.relations.SingerWithSongs
import com.example.muisicapp.Model.relations.SongWithSingers
import kotlinx.coroutines.flow.Flow

interface MusicRepository {

    /**
     * user
     */
    suspend fun insert(user: User)

    suspend fun update(user: User)

    fun delete(user: User)

    fun getUserById(id: Int): User

    fun getAllUsers(): List<User>

    fun getUser(username: String, password: String): User
    fun getAllSongsStream(): Flow<List<Song>>

    fun getAllSingersStream(): Flow<List<Singer>>

    /**
     * Song
     */

    fun getSongWithSingersById(songId: Int): Flow<SongWithSingers>

    fun getSongWithSingers(): Flow<List<SongWithSingers>>

    /**
     * Singer
     */

    fun getSingerWithSongsById(singerId: Int): Flow<SingerWithSongs>
    fun getSingerWithSongs(): Flow<List<SingerWithSongs>>
    fun getSingerWithAlbumID(albumId: Int): Flow<SingerWithAlbums>


    /**
     * Album
     */
    fun getAllAlbums(): Flow<List<AlbumWithSongsAndSingers>>
    fun getAlbumById(albumId: Int): Flow<AlbumWithSongsAndSingers>
    fun getAlbumsWithSingerId(singerId: Int): Flow<SingerWithAlbums>

    /**
     * PlayList
     */
    fun getAllPlayLists(): Flow<List<PlaylistWithSongsAndSingers>>

    fun getPlayListById(playListId: Int): Flow<PlaylistWithSongsAndSingers>

    /**
     * search
     */

    fun getSearchResult(songName: String): Flow<List<SongWithSingers>>


    /**
     * CRUD
     */

    suspend fun insertSong(song: Song)

    suspend fun updateSong(song: Song)

    suspend fun deleteSong(song: Song)


}