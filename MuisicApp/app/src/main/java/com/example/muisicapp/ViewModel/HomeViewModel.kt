package com.example.muisicapp.ViewModel

import android.media.MediaPlayer
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.muisicapp.Model.data.Album
import com.example.muisicapp.Model.data.Playlist
import com.example.muisicapp.Model.data.Singer
import com.example.muisicapp.Model.data.Song
import com.example.muisicapp.Model.relations.AlbumWithSongs
import com.example.muisicapp.Model.relations.AlbumWithSongsAndSingers
import com.example.muisicapp.Model.relations.PlaylistWithSongs
import com.example.muisicapp.Model.relations.PlaylistWithSongsAndSingers
import com.example.muisicapp.Model.relations.SingerWithSongs
import com.example.muisicapp.Model.relations.SongWithSingers
import com.example.muisicapp.Model.repository.MusicRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class HomeViewModel(
    private val savedStateHandle: SavedStateHandle,
    musicRepository: MusicRepository,


) : ViewModel() {

    /**
     * Lấy danh sách ca sĩ
     */
    val singerUiState: StateFlow<SingerSongsUiState> =
        musicRepository.getSingerWithSongs().map { SingerSongsUiState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = SingerSongsUiState()
            )

    /**
     * Lấy danh sách bài hát
     */
    val songWithSingersUiState: StateFlow<SongSingersUiState> =
        musicRepository.getSongWithSingers().map { SongSingersUiState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = SongSingersUiState()
            )

    /**
     * Lấy danh sách playList
     */
    val playListUiState: StateFlow<PlayListUiState> =
        musicRepository.getAllPlayLists().map { PlayListUiState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = PlayListUiState()
            )

    /**
     * Lấy danh sách album
     */
    val albumUiState: StateFlow<AlbumUiState> =
        musicRepository.getAllAlbums().map { AlbumUiState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = AlbumUiState()
            )




    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}

data class SongSingersUiState(val songSingerList: List<SongWithSingers> = listOf())
data class SingerSongsUiState(val singerSongList: List<SingerWithSongs> = listOf())
data class PlayListUiState(val playList: List<PlaylistWithSongsAndSingers> = listOf())
data class AlbumUiState(val albumList: List<AlbumWithSongsAndSingers> = listOf())
