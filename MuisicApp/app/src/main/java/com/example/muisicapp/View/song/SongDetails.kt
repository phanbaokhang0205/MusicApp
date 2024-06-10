package com.example.muisicapp.View.song

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FiberManualRecord
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.muisicapp.Model.data.Singer
import com.example.muisicapp.Model.data.Song
import com.example.muisicapp.R
import com.example.muisicapp.View.navigation.NavigationDestination
import com.example.muisicapp.View.scaffold.TopBarOption
import com.example.muisicapp.View.seekbar.SeekBar
import com.example.muisicapp.ViewModel.AppViewModelProvider
import com.example.muisicapp.ViewModel.SongDetailsViewModel


object SongDetailsDestination : NavigationDestination {
    override val route: String = "song_details"
    const val songIdAgr = "songId"
    val routeWithArgs = "$route/{$songIdAgr}"
}


@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun SongDetailsScreen(
    viewModel: SongDetailsViewModel = viewModel(factory = AppViewModelProvider.Factory),
    goBackEvent: () -> Unit,
    goShareEvent: () -> Unit,
    goOptionEvent: () -> Unit,
) {
//
    var isFavourite by rememberSaveable {
        mutableStateOf(false)
    }

    val uiState = viewModel.uiState.collectAsState()

    val isPlaying = viewModel.isPlaying.collectAsState()

    val coroutineScope = rememberCoroutineScope()

    val context: Context = LocalContext.current

//    val duration = viewModel.duration.collectAsState()
//    val durationFormat = viewModel.formatDuration(uiState.value.songDetails.song.duration)

    val minutes = uiState.value.songDetails.song.duration / 60
    val remainingSeconds = uiState.value.songDetails.song.duration % 60


    val progress = viewModel.progress.collectAsState()

    val onLoading = viewModel.playBackChange()


    Scaffold(
        topBar = {
            TopBarOption(
                goBackEvent = goBackEvent,
                goShareEvent = goShareEvent,
                goOptionEvent = goOptionEvent,
                Modifier
                    .background(Color(0x66000000))
                    .fillMaxWidth()
            )

        }
    ) { valuePadding ->
        Column(modifier = Modifier.padding(valuePadding)) {

            SongDetailsBody(
                songDetails = uiState.value.songDetails.song,
                singers = uiState.value.songDetails.singers,
                progress = progress.value,
                onProgressChange = { },

                isPlaying = isPlaying.value,
                playingEvent = {
                    viewModel.isPlayingChange()
                    viewModel.play(uiState.value.songDetails.song.songLink, context)
//                    coroutineScope.launch {
//                        while (isPlaying.value && progress < 600f
//                        /**600f = duration **/
//                        ) {
//                            delay(1000)
//                            progress.value += 0.3f
//                        }
//                    }
                    if (!isPlaying.value) {
                        viewModel.resume()
                    } else {
                        viewModel.pauseSong()
                    }
                },
                isFavourite = isFavourite,
                favouriteEvent = {
//                    coroutineScope.launch {
//                        userViewModel.addSongToFavorite(
//                            uiState.value.songDetails.song.songId !!
//                        )
//                    }
                },
                duration = "$minutes",
                onLoading = onLoading,
                goTo10s = {
                    viewModel.nextTo10s()
                },
                previousTo10s = {
                    viewModel.previousTo10s()
                },
                skipNext = {
                    viewModel.skipNext()
                }
            )


        }

    }
}

@Composable
fun SongDetailsBody(
    songDetails: Song,
    singers: List<Singer>,
    modifier: Modifier = Modifier,
    progress: Float,
    onProgressChange: () -> Unit,
    isPlaying: Boolean,
    playingEvent: () -> Unit,
    isFavourite: Boolean,
    favouriteEvent: () -> Unit,
    duration: String,
    goTo10s:() -> Unit,
    previousTo10s:() -> Unit,
    onLoading: Boolean,
    skipNext: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        SongDetails(
            song = songDetails,
            singers = singers,
            progress = progress,
            onProgressChange = onProgressChange,
            isPlaying = isPlaying,
            playingEvent = playingEvent,
            isFavourite = isFavourite,
            favouriteEvent = favouriteEvent,
            duration = duration,
            onLoading = onLoading,
            goTo10s = goTo10s,
            previousTo10s = previousTo10s,
            skipNext = skipNext
        )
    }
}

@Composable
fun SongDetails(
    song: Song,
    singers: List<Singer>,
    progress: Float,
    onProgressChange: () -> Unit,
    isPlaying: Boolean,
    playingEvent: () -> Unit,
    isFavourite: Boolean,
    favouriteEvent: () -> Unit,
    duration: String,
    onLoading: Boolean,
    goTo10s:() -> Unit,
    skipNext:() -> Unit,
    previousTo10s:() -> Unit,
) {


    Box(modifier = Modifier) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Box(modifier = Modifier, contentAlignment = Alignment.Center) {
                AsyncImage(
                    model = song.songImage,
                    error = painterResource(id = R.drawable.ic_broken_image),
                    placeholder = painterResource(R.drawable.loading_image),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(350.dp)
                        .clip(CircleShape)
                        .graphicsLayer {
                            rotationZ = progress
                        },
                )
                Icon(
                    imageVector = Icons.Filled.FiberManualRecord,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(60.dp)
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0x6A454545))
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(0.dp),
            verticalArrangement = Arrangement.Bottom
        ) {
            SeekBar(
                progress = progress,
                onProgressChange = { onProgressChange() },
                isPlaying = isPlaying,
                playingEvent = {
                    playingEvent()

                },
                isFavourite = isFavourite,
                favouriteEvent = { favouriteEvent() },
                songName = song.songName,
                singerName = stringBuilder(singers),
                duration = duration,
                onValueChangeFinished = {},
                onLoading = onLoading,
                goTo10s = goTo10s,
                previousTo10s = previousTo10s,
                skipNext = skipNext

            )

        }
    }
}


@Composable
fun stringBuilder(singers: List<Singer>): String {
    val builder = StringBuilder()

    singers.forEachIndexed { index, singer ->
        builder.append(singer.singerName)
        if (index < singers.size - 1) {
            builder.append(", ")
        }
    }

    return builder.toString()

}

@Preview(showBackground = true)
@Composable
fun SeekBarPreview() {
//    SongDetailsScreen()
}