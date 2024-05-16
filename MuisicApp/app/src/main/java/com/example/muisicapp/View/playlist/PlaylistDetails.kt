package com.example.muisicapp.View.playlist

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.PlayCircle
import androidx.compose.material.icons.filled.PlayCircleOutline
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.muisicapp.Model.data.Playlist
import com.example.muisicapp.Model.data.Singer
import com.example.muisicapp.Model.data.Song
import com.example.muisicapp.Model.relations.PlaylistWithSongsAndSingers
import com.example.muisicapp.Model.relations.SongWithSingers
import com.example.muisicapp.R
import com.example.muisicapp.View.navigation.NavigationDestination
import com.example.muisicapp.View.scaffold.TopBarOption
import com.example.muisicapp.View.song.stringBuilder
import com.example.muisicapp.ViewModel.AppViewModelProvider
import com.example.muisicapp.ViewModel.PlayListDetailsViewModel
import com.example.muisicapp.ViewModel.toPlayList

object PlayListDestination : NavigationDestination {
    override val route: String = "playlist_screen"
    const val playListIdAgr = "playlistId"
    val routeWithArgs = "${route}/{$playListIdAgr}"
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PlaylistScreen(
    goBackEvent: () -> Unit,
    goShareEvent: () -> Unit,
    goOptionEvent: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: PlayListDetailsViewModel = viewModel(factory = AppViewModelProvider.Factory),

    ) {

    val uiState = viewModel.uiState.collectAsState()

    Scaffold(
        topBar = { TopBarOption(goBackEvent, goOptionEvent, goShareEvent) }
    ) {
        LazyColumn(
            modifier = Modifier
                .background(Color.Black)
                .fillMaxSize()
        ) {
            item {
                imgPlaylist(
                    uiState.value.playListDetails.toPlayList()
                )
                middle()
                topSongList(
                    uiState.value.playListDetails.toPlayList()
                )
            }
        }
    }
}

@Composable
fun imgPlaylist(
    playList: PlaylistWithSongsAndSingers
) {
    Box(modifier = Modifier.height(400.dp)) {
        Image(
            painter = painterResource(R.drawable.img_1),
            modifier = Modifier.fillMaxSize(),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        AsyncImage(
            model = playList.playlist.playlistImage,
            contentDescription = null,
            error = painterResource(id = R.drawable.ic_broken_image),
            placeholder = painterResource(R.drawable.loading_image),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .background(Color.Black)
                .fillMaxSize()
                .align(Alignment.Center),
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 15.dp),
            verticalArrangement = Arrangement.Bottom,
        ) {
            Column {
                Text(
                    text = "YOUR TOP SONGS",
                    fontSize = 25.sp,
                    color = Color.White,
                    fontFamily = FontFamily.SansSerif
                )
                Text(
                    text = "2024",
                    fontSize = 40.sp,
                    fontFamily = FontFamily.SansSerif,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun middle() {
    Row(
        modifier = Modifier.padding(vertical = 15.dp, horizontal = 15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row {
            Column {
                Row {
                    Icon(
                        imageVector = Icons.Filled.Favorite,
                        tint = Color.Gray,
                        contentDescription = null
                    )
                    Text(
                        text = "53,483,231 likes",
                        color = Color.Gray,
                        modifier = Modifier.padding(start = 5.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.width(20.dp))

            Column {
                Row {
                    Icon(
                        imageVector = Icons.Filled.Schedule,
                        tint = Color.Gray,
                        contentDescription = null
                    )
                    Text(
                        text = "2h 35mins",
                        color = Color.Gray,
                        modifier = Modifier.padding(start = 5.dp)
                    )
                }
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Column {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.PlayCircle,
                    tint = Color.Green,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}

@Composable
fun topSongList(
    songList: PlaylistWithSongsAndSingers
) {
    Column(modifier = Modifier.padding(horizontal = 15.dp)) {
        Text(
            text = "Featuring",
            color = Color.White,
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 10.dp)
        )
        songList.songsWithSingers.forEach {
            topSongItems(song = it.song, singers = it.singers)
            Spacer(modifier = Modifier.height(15.dp))
        }
        
    }
}

@Composable
fun topSongItems(
    song: Song,
    singers: List<Singer>
) {
    Column {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxSize()) {
            AsyncImage(
                model = song.songImage,
                contentDescription = null,
                error = painterResource(id = R.drawable.ic_broken_image),
                placeholder = painterResource(R.drawable.loading_image),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(68.dp)
                    .clip(
                        RoundedCornerShape(10.dp)
                    )
            )
            Spacer(modifier = Modifier.width(15.dp))
            Column {
                Text(
                    text = song.songName,
                    color = Color.White,
                    modifier = Modifier.padding(bottom = 10.dp),
                    fontSize = 15.sp
                )
                Text(text = stringBuilder(singers), color = Color.Gray, fontSize = 12.sp)
            }
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = Icons.Filled.PlayCircleOutline,
                tint = Color.Gray,
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(10.dp))
            Icon(
                imageVector = Icons.Filled.FavoriteBorder,
                tint = Color.Gray,
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(10.dp))
            Icon(
                imageVector = Icons.Filled.MoreHoriz,
                tint = Color.White,
                contentDescription = null
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun Preview() {
    PlaylistScreen(
        goBackEvent = { /*TODO*/ },
        goShareEvent = { /*TODO*/ },
        goOptionEvent = { /*TODO*/ })
}
