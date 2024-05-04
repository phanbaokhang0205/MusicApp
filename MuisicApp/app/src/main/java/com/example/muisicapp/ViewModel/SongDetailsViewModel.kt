package com.example.muisicapp.ViewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.muisicapp.Model.data.Song
import com.example.muisicapp.Model.relations.SongWithSingers
import com.example.muisicapp.Model.repository.MusicRepository
import com.example.muisicapp.View.song.SongDetailsDestination
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class SongDetailsViewModel(
    savedStateHandle: SavedStateHandle,
    private val songsRepository: MusicRepository,
) : ViewModel() {

    private val songId: Int = checkNotNull(savedStateHandle[SongDetailsDestination.songIdAgr])

    val uiState: StateFlow<SongDetailUiState> =
        songsRepository.getSongWithSingersById(songId)
            .filterNotNull()
            .map {
                SongDetailUiState(it)
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000L),
                initialValue = SongDetailUiState()
            )

}

data class SongDetailUiState(
    val songSingerList: List<SongWithSingers> = listOf()
)
data class SongDetails(
    val songId: Int = 0,
    val songName: String = "",
    val songImage: String = "",
    val songLink: String = "",
    val albumId: Int = 0
)

fun SongDetails.toSong(): Song = Song(
    songId = songId,
    songName = songName,
    songImage = songImage,
    songLink = songLink,
    albumId = albumId
)