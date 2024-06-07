package com.example.muisicapp.ViewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.muisicapp.Model.data.Album
import com.example.muisicapp.Model.data.Singer
import com.example.muisicapp.Model.data.Song
import com.example.muisicapp.Model.repository.MusicRepository
import com.example.muisicapp.View.Singer.SingerDetailsDestination
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class SingerDetailsViewModel(
    savedStateHandle: SavedStateHandle,
    private val songsRepository: MusicRepository,
) : ViewModel() {

    private val singerId: Int = checkNotNull(savedStateHandle[SingerDetailsDestination.singerIdAgr])

    val uiState: StateFlow<SingerDetailUiState> =
        songsRepository.getSingerWithSongsById(singerId)
            .filterNotNull()
            .map {
                SingerDetailUiState(
                    singeDetails = SingerDetails(
                        singer = it.singer,
                        songs = it.songs
                    )
                )
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000L),
                initialValue = SingerDetailUiState()
            )


    val singerWithAlbums: StateFlow<SingerAlbumUiState> =
        songsRepository.getAlbumsWithSingerId(singerId)
            .filterNotNull()
            .map {
                SingerAlbumUiState(
                    singerAlbum = SingerWithAlbum(
                        singer = it.singer,
                        album = it.albums
                    )
                )
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000L),
                initialValue = SingerAlbumUiState()
            )
}

data class SingerDetailUiState(
    val singeDetails: SingerDetails = SingerDetails(),
)

data class SingerAlbumUiState(
    val singerAlbum: SingerWithAlbum = SingerWithAlbum()
)

data class SingerDetails(
    val singer: Singer = Singer(0, "", "", "", "", ""),
    val songs: List<Song> = listOf()
)

data class SingerWithAlbum(
    val singer: Singer = Singer(0, "", "", "", "", ""),
    val album: List<Album> = listOf()
)
//fun SingerDetails.toSinger(): SingerWithSongs = SingerWithSongs(
//    singer = singer,
//    songs = songs
//)
//fun SingerWithAlbum.toSingerAlbum(): SingerWithAlbums = SingerWithAlbums(
//    singer = singer,
//    albums = album
//)

//fun SingerWithSongs.toSingerUiState(): SingerDetailUiState = SingerDetailUiState(
//    singeDetails = this.toSingerDetails()
//)

//fun SingerWithSongs.toSingerDetails(): SingerDetails = SingerDetails(
//    singer = singer,
//    songs = songs
//)
//
//fun SingerWithAlbums.toSingerAlbum(): SingerWithAlbum = SingerWithAlbum(
//    singer = singer,
//    album = albums
//)

