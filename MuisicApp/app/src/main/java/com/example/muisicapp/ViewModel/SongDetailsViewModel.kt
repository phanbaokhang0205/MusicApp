package com.example.muisicapp.ViewModel

import android.annotation.SuppressLint
import android.content.Context
import android.net.Uri
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import com.example.muisicapp.Model.data.Singer
import com.example.muisicapp.Model.data.Song
import com.example.muisicapp.Model.relations.SongUserCrossRef
import com.example.muisicapp.Model.repository.MusicRepository
import com.example.muisicapp.View.song.SongDetailsDestination
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

@SuppressLint("StaticFieldLeak")
class SongDetailsViewModel(
    private val savedStateHandle: SavedStateHandle,
    private val songsRepository: MusicRepository,
) : ViewModel() {

    private val songId: Int = checkNotNull(savedStateHandle[SongDetailsDestination.songIdAgr])

    private var exoPlayer: ExoPlayer? = null

    private val _isPlaying = MutableStateFlow(false)
    var isPlaying: StateFlow<Boolean> = _isPlaying.asStateFlow()

    private val _progress = MutableStateFlow(0f)
    var progress: StateFlow<Float> = _progress.asStateFlow()

    private val _loading = MutableStateFlow(false)
    var loading: StateFlow<Boolean> = _loading.asStateFlow()

    private val _duration = MutableStateFlow(0L)
    val duration: StateFlow<Long> = _duration.asStateFlow()


    val uiState: StateFlow<SongDetailUiState> =
        songsRepository.getSongWithSingersById(songId)
            .filterNotNull()
            .map {
                SongDetailUiState(
                    songDetails = SongDetails(
                        song = it.song,
                        singers = it.singers
                    )
                )
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000L),
                initialValue = SongDetailUiState()
            )


    fun playBackChange(): Boolean {
        exoPlayer?.addListener(object : Player.Listener {
            override fun onPlaybackStateChanged(playbackState: Int) {
                _loading.value = playbackState == Player.STATE_BUFFERING
            }
        })

        return _loading.value
    }


    fun isPlayingChange() {
        _isPlaying.value = !_isPlaying.value
    }

    fun pauseSong() {
        exoPlayer?.pause()

    }

    fun play(song: String, context: Context) {
        if (exoPlayer == null) {
            exoPlayer = ExoPlayer.Builder(context).build()
        }
        val mediaItem = MediaItem.fromUri(Uri.parse(song))
        exoPlayer?.addMediaItem(mediaItem)
        exoPlayer?.prepare()
        exoPlayer?.play()

    }

    fun resume() {
        _isPlaying.value = true
        exoPlayer?.play()
    }

    fun stopSong() {
        exoPlayer?.stop()
        _isPlaying.value = false
    }

    //    Dừng nhạc đang phát khi thoát khỏi màn hình SongDetails
    override fun onCleared() {
        super.onCleared()
        exoPlayer?.release()
    }

    fun formatDuration(duration: Long): String {
        val minutes = duration / 60
        val remainingSeconds = duration % 60
        return String.format("%02d:%02d", minutes, remainingSeconds)
    }


}

data class SongDetailUiState(
    val songDetails: SongDetails = SongDetails()
)


data class SongDetails(
    val song: Song = Song(0, "", "", "", 0, 0L, false),
    val singers: List<Singer> = listOf()
)


