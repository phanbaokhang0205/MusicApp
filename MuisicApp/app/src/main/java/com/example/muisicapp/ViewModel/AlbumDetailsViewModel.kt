package com.example.muisicapp.ViewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.muisicapp.Model.data.Album
import com.example.muisicapp.Model.data.Singer
import com.example.muisicapp.Model.data.Song
import com.example.muisicapp.Model.relations.AlbumWithSongs
import com.example.muisicapp.Model.relations.AlbumWithSongsAndSingers
import com.example.muisicapp.Model.relations.SingerWithAlbums
import com.example.muisicapp.Model.relations.SingerWithSongs
import com.example.muisicapp.Model.relations.SongWithSingers
import com.example.muisicapp.Model.repository.MusicRepository
import com.example.muisicapp.View.Album.AlbumDestination
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class AlbumDetailsViewModel(
    savedStateHandle: SavedStateHandle,
    albumRepository: MusicRepository,
) : ViewModel() {

    private val albumId: Int = checkNotNull(savedStateHandle[AlbumDestination.albumIdAgr])


    val uiState: StateFlow<AlbumDetailsUIState> =
        albumRepository.getAlbumById(albumId)
            .filterNotNull()
            .map {
                AlbumDetailsUIState(albumDetails = it.toAlbumDetails())
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000L),
                initialValue = AlbumDetailsUIState()
            )

    val singerUiState: StateFlow<SingerUIState> =
        albumRepository.getSingerWithAlbumID(albumId)
            .filterNotNull()
            .map {
                SingerUIState(singerDetails = it.toSingerDetails())
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000L),
                initialValue = SingerUIState()
            )

}


/**
 * Tạo lớp chứa trạng thái của AlbumDetails.
 */
data class AlbumDetailsUIState(
    val albumDetails: AlbumDetails = AlbumDetails()
)
data class SingerUIState(
    val singerDetails: SingerDetail = SingerDetail()
)

/**
 * Tạo lớp chứa các thông tin của AlbumDetails để hiển thị ra UI.
 */
data class AlbumDetails(
    val album: Album = Album(0, "", "", 0),
    val songList: List<SongWithSingers> = listOf()
)
fun AlbumDetails.toAlbum(): AlbumWithSongsAndSingers = AlbumWithSongsAndSingers(
    album = album,
    songsWithSingers = songList
)
fun AlbumWithSongsAndSingers.toAlbumDetails(): AlbumDetails = AlbumDetails(
    album = album,
    songList = songsWithSingers
)

data class SingerDetail(
    val singer: Singer = Singer(0,"","","","",""),
    val albums: List<Album> = listOf()
)
fun SingerDetail.toSinger(): SingerWithAlbums = SingerWithAlbums(
    singer, albums
)
fun SingerWithAlbums.toSingerDetails(): SingerDetail = SingerDetail(
    singer = singer,
    albums = albums
)
