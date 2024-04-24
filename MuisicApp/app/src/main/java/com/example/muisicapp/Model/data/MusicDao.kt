package com.example.muisicapp.Model.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.muisicapp.Model.relations.AlbumWithSongs
import com.example.muisicapp.Model.relations.PlaylistWithSongs
import com.example.muisicapp.Model.relations.SingerWithAlbums
import com.example.muisicapp.Model.relations.SingerWithSongs
import com.example.muisicapp.Model.relations.SongPlaylistCrossRef
import com.example.muisicapp.Model.relations.SongSingerCrossRef
import com.example.muisicapp.Model.relations.SongTypeCrossRef
import com.example.muisicapp.Model.relations.SongWithPlaylists
import com.example.muisicapp.Model.relations.SongWithSingers
import kotlinx.coroutines.flow.Flow

@Dao
interface MusicDao {

    @Query("SELECT * FROM Song ORDER BY songName ASC")
    fun getAllSongs(): Flow<List<Song>>

    @Query("SELECT * FROM Singer ORDER BY singerName ASC")
    fun getAllSingers(): Flow<List<Singer>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSong(song: Song)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSinger(singer: Singer)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertType(type: Type)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAlbum(album: Album)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlaylist(playlist: Playlist)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSongPlaylistCrossRef(crossRef: SongPlaylistCrossRef)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSongSingerCrossRef(crossRef: SongSingerCrossRef)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSongTypeCrossRef(crossRef: SongTypeCrossRef)

    @Transaction
    @Query("SELECT * FROM album WHERE albumId = :albumId")
    suspend fun getAlbumWithSongs(albumId: Int): List<AlbumWithSongs>

    @Transaction
    @Query("SELECT * FROM singer WHERE singerId = :singerId")
    suspend fun getSingerWithAlbums(singerId: Int): List<SingerWithAlbums>

    @Transaction
    @Query("SELECT * FROM playlist WHERE playlistId = :playlistId")
    suspend fun getSongsOfPlaylist(playlistId: Int): List<PlaylistWithSongs>

    @Transaction
    @Query("SELECT * FROM song WHERE songId = :songId")
    suspend fun getPlaylistOfSong(songId: Int): List<SongWithPlaylists>

    @Transaction
    @Query("SELECT * FROM singer WHERE singerId = :singerId")
    suspend fun getSongsOfSinger(singerId: Int): List<SingerWithSongs>

    @Transaction
    @Query("SELECT * FROM song WHERE songId = :songId")
    suspend fun getSingersOfSong(songId: Int): List<SongWithSingers>





    @Update
    suspend fun update(song: Song)

    @Delete
    suspend fun delete(song: Song)
}