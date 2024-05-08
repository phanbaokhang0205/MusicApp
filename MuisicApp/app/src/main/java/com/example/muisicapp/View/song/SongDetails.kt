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
import androidx.compose.material3.Text
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.muisicapp.Model.data.Singer
import com.example.muisicapp.Model.data.Song
import com.example.muisicapp.Model.relations.SongWithSingers
import com.example.muisicapp.View.navigation.NavigationDestination
import com.example.muisicapp.View.scaffold.TopBarOption
import com.example.muisicapp.View.seekbar.SeekBar
import com.example.muisicapp.ViewModel.AppViewModelProvider
import com.example.muisicapp.ViewModel.SongDetailsViewModel
import com.example.muisicapp.ViewModel.toSong
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

object SongDetailsDestination : NavigationDestination {
    override val route: String = "song_details"
    const val songIdAgr = "songId"
    val routeWithArgs = "$route/{$songIdAgr}"
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SongDetailsScreen(
    viewModel: SongDetailsViewModel = viewModel(factory = AppViewModelProvider.Factory),
    goBackEvent: () -> Unit,
    goShareEvent: () -> Unit,
    goOptionEvent: () -> Unit,
) {
    var progress by rememberSaveable { mutableStateOf(0f) }
    var isPlaying by rememberSaveable { mutableStateOf(false) }

    var isFavourite by rememberSaveable {
        mutableStateOf(false)
    }

    val uiState = viewModel.uiState.collectAsState()
    val coroutineScope = rememberCoroutineScope()
    val context: Context = LocalContext.current

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
            Text(text = if (uiState.value.songDetails.song.songLink == "") "Rongg" else uiState.value.songDetails.song.songLink)

        }
    ) {
        Column(modifier = Modifier.padding(it)) {
            SongDetailsBody(
                songDetails = uiState.value.songDetails.toSong(),
                progress = progress,
                onProgressChange = { progress = it },
                isPlaying = isPlaying,
                playingEvent = {
                    isPlaying = !isPlaying
                    coroutineScope.launch {
                        while (isPlaying && progress < 60f) {
                            delay(1000)
                            progress += 1f
                        }
                    }
                    if (isPlaying) {
                        viewModel.playSong(
                            uiState.value.songDetails.song.songLink,
                            context
                        )
                    } else {
                        viewModel.pauseSong()
                    }
                },
                isFavourite = isFavourite,

                ) { isFavourite = !isFavourite }


        }
    }
}

@Composable
fun SongDetailsBody(
    songDetails: SongWithSingers,
    modifier: Modifier = Modifier,
    progress: Float,
    onProgressChange: (Float) -> Unit,
    isPlaying: Boolean,
    playingEvent: () -> Unit,
    isFavourite: Boolean,
    favouriteEvent: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        SongDetails(
            song = songDetails.song,
            singers = songDetails.singers,
            progress = progress,
            onProgressChange = onProgressChange,
            isPlaying = isPlaying,
            playingEvent = playingEvent,
            isFavourite = isFavourite,
            favouriteEvent = favouriteEvent,
        )
    }
}

@Composable
fun SongDetails(
    song: Song,
    singers: List<Singer>,
    progress: Float,
    onProgressChange: (Float) -> Unit,
    isPlaying: Boolean,
    playingEvent: () -> Unit,
    isFavourite: Boolean,
    favouriteEvent: () -> Unit,
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
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(350.dp)
                        .clip(CircleShape)
                        .graphicsLayer {
                            rotationZ = progress
                        }
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
                onProgressChange = { onProgressChange(it) },
                isPlaying = isPlaying,
                playingEvent = {
                    playingEvent()

                },
                isFavourite = isFavourite,
                favouriteEvent = { favouriteEvent() },
                songName = song.songName,
                singerName = stringBuilder(singers)
            )

        }
    }
}

@Composable
private fun stringBuilder(singers: List<Singer>): String {
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