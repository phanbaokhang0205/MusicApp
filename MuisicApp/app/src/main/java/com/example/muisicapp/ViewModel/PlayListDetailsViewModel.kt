package com.example.muisicapp.ViewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.muisicapp.Model.data.Playlist
import com.example.muisicapp.Model.data.Singer
import com.example.muisicapp.Model.data.Song
import com.example.muisicapp.Model.relations.PlaylistWithSongsAndSingers
import com.example.muisicapp.Model.relations.SingerWithSongs
import com.example.muisicapp.Model.relations.SongWithSingers
import com.example.muisicapp.Model.repository.MusicRepository
import com.example.muisicapp.View.Singer.SingerDetailsDestination
import com.example.muisicapp.View.playlist.PlayListDestination
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class PlayListDetailsViewModel(
    savedStateHandle: SavedStateHandle,
    private val playListRepository: MusicRepository,
) : ViewModel() {

    private val playListId: Int = checkNotNull(savedStateHandle[PlayListDestination.playListIdAgr])

    val uiState: StateFlow<PlayListDetailUiState> =
        playListRepository.getPlayListById(playListId)
            .filterNotNull()
            .map {
                PlayListDetailUiState(playListDetails = it.toPlayListDetails())
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000L),
                initialValue = PlayListDetailUiState()
            )



}



data class PlayListDetailUiState(
    val playListDetails: PlayListDetails = PlayListDetails()
)

data class PlayListDetails(
    val playList: Playlist = Playlist(0, "", ""),
    val songWithSingers: List<SongWithSingers> = listOf()
)

fun PlayListDetails.toPlayList(): PlaylistWithSongsAndSingers = PlaylistWithSongsAndSingers(
    playlist = playList,
    songsWithSingers = songWithSingers
)

fun PlaylistWithSongsAndSingers.toPlayListDetails(): PlayListDetails = PlayListDetails(
    playList = playlist,
    songWithSingers = songsWithSingers
)

fun PlaylistWithSongsAndSingers.toPlayListUiState(): PlayListDetailUiState = PlayListDetailUiState(
    playListDetails = this.toPlayListDetails()
)