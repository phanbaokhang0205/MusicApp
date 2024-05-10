package com.example.muisicapp.ViewModel

import android.media.MediaPlayer
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.muisicapp.Model.data.Singer
import com.example.muisicapp.Model.data.Song
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


    val singerUiState: StateFlow<SingerSongsUiState> =
        musicRepository.getSingerWithSongs().map { SingerSongsUiState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = SingerSongsUiState()
            )

    val songWithSingersUiState: StateFlow<SongSingersUiState> =
        musicRepository.getSongWithSingers().map { SongSingersUiState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = SongSingersUiState()
            )


    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}

data class SongSingersUiState(val songSingerList: List<SongWithSingers> = listOf())
data class SingerSongsUiState(val singerSongList: List<SingerWithSongs> = listOf())
