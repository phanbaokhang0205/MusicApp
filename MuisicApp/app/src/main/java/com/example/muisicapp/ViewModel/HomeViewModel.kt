package com.example.muisicapp.ViewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.muisicapp.Model.data.Singer
import com.example.muisicapp.Model.data.Song
import com.example.muisicapp.Model.relations.SongWithSingers
import com.example.muisicapp.Model.repository.MusicRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn


class HomeViewModel(
    private val savedStateHandle: SavedStateHandle,
    musicRepository: MusicRepository
) : ViewModel() {

    val songUiState: StateFlow<SongUiState> =
        musicRepository.getAllSongsStream().map { SongUiState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = SongUiState()
            )

    val singerUiState: StateFlow<SingerUiState> =
        musicRepository.getAllSingersStream().map { SingerUiState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = SingerUiState()
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
data class SongUiState(val songList: List<Song> = listOf())
data class SingerUiState(val singerList: List<Singer> = listOf())
