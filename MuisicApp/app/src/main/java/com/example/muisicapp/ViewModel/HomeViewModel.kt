package com.example.muisicapp.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.muisicapp.Model.data.Song
import com.example.muisicapp.Model.data.SongsRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn


class HomeViewModel(
    songsRepository: SongsRepository
) : ViewModel() {

    val homeUiState: StateFlow<HomeUiState> =
        songsRepository.getAllSongsStream().map { HomeUiState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = HomeUiState()
            )

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}

data class HomeUiState(val songList: List<Song> = listOf())