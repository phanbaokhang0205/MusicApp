package com.example.muisicapp.ViewModel

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.media3.exoplayer.ExoPlayer
import com.example.muisicapp.Model.data.Singer
import com.example.muisicapp.Model.data.Song
import com.example.muisicapp.Model.relations.SongWithSingers
import com.example.muisicapp.Model.repository.MusicRepository
import com.example.muisicapp.View.song.SongDetailsDestination
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

@SuppressLint("StaticFieldLeak")
class SongDetailsViewModel(
    savedStateHandle: SavedStateHandle,
    private val songsRepository: MusicRepository,
) : ViewModel() {


    private val songId: Int = checkNotNull(savedStateHandle[SongDetailsDestination.songIdAgr])

    val uiState: StateFlow<SongDetailUiState> =
        songsRepository.getSongWithSingersById(songId)
            .filterNotNull()
            .map {
                SongDetailUiState(songDetails = it.toSongDetails())
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000L),
                initialValue = SongDetailUiState()
            )

    private var exoPlayer: ExoPlayer? = null

//    init {
//        val songUri = uiState.value.songDetails.song.songLink
//        val context =
//        prepareSong(songUri,context)
//
//    }
    fun playSong(song: String, context: Context) {
        if (exoPlayer == null) {
            exoPlayer = ExoPlayer.Builder(context).build()
        }
        val mediaItem = androidx.media3.common.MediaItem.fromUri(song)
        exoPlayer?.setMediaItem(mediaItem)
        exoPlayer?.prepare()
        exoPlayer?.play()
    }
//    fun playSong() {
//        exoPlayer?.playWhenReady = true
//    }

    fun pauseSong() {
        exoPlayer?.playWhenReady = false
        exoPlayer?.pause()
//        val player = ExoPlayer.Builder(context).build()
//        val mediaItem = androidx.media3.common.MediaItem.fromUri(song)
//        player.release()
//        player = null
    }
}

data class SongDetailUiState(
    val songDetails: SongDetails = SongDetails()
)

data class SongDetails(
    val song: Song = Song(0, "", "", "", 0),
    val singers: List<Singer> = listOf()
)

fun SongDetails.toSong(): SongWithSingers = SongWithSingers(
    song = song,
    singers = singers
)

fun SongWithSingers.toSongUiState(): SongDetailUiState = SongDetailUiState(
    songDetails = this.toSongDetails(),
)

fun SongWithSingers.toSongDetails(): SongDetails = SongDetails(
    song = song,
    singers = singers
)