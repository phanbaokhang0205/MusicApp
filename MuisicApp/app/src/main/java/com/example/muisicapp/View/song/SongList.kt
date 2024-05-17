package com.example.muisicapp.View.song

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.PlayCircleFilled
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.muisicapp.Model.data.Singer
import com.example.muisicapp.Model.data.Song
import com.example.muisicapp.Model.relations.SongWithSingers
import com.example.muisicapp.R
import com.example.muisicapp.View.Album.heading1
import com.example.muisicapp.View.Album.heading2
import com.example.muisicapp.View.Album.heading3
import com.example.muisicapp.View.navigation.NavigationDestination
import com.example.muisicapp.ViewModel.AppViewModelProvider
import com.example.muisicapp.ViewModel.HomeViewModel

object SongListDestination : NavigationDestination {
    override val route: String = "song_list"
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SongListScreen(
    viewModel: HomeViewModel = viewModel(factory = AppViewModelProvider.Factory),
    goToSongDetails: (Int) -> Unit,
    goBack: () -> Unit,
) {

    val songWithSingers by viewModel.songWithSingersUiState.collectAsState()

    val gradient = Brush.verticalGradient(
        colors = listOf(Color(0xCCC02820), Color(0xff000000))
    )
    Box(
        modifier = Modifier
            .background(gradient)
            .fillMaxSize()
    ) {
        Scaffold(
            containerColor = Color.Transparent,
            topBar = {

                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(Color.Transparent),
                    title = {
                        IconButton(onClick = { goBack() }) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                tint = Color.White,
                                contentDescription = null
                            )
                        }
                    })
            }) {
            Column {
                songList(
                    values = it,
                    songList = songWithSingers.songSingerList,
                    goToSongDetails = goToSongDetails
                )
            }
        }
    }
}

@Composable
fun songList(
    values: PaddingValues,
    songList: List<SongWithSingers>,
    goToSongDetails: (Int) -> Unit
) {
    Row(
        modifier = Modifier
            .padding(values)
            .padding(horizontal = 15.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        heading1(content = "BÀI HÁT NỔI BẬT")
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Filled.PlayCircleFilled,
                tint = Color(0xff1ED760),
                contentDescription = null,
                modifier = Modifier.size(60.dp)
            )
        }
    }
    LazyColumn(
        modifier = Modifier.padding(top = 15.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp),
    ) {
        items(songList, { it.song.songId!! }) { song ->
            songItem(
                song = song.song,
                singers = song.singers,
                goToSongDetails = { goToSongDetails(song.song.songId!!) })
        }
    }
}

@Composable
fun songItem(
    song: Song,
    singers: List<Singer>,
    goToSongDetails: () -> Unit
) {
    Column(modifier = Modifier.padding(horizontal = 15.dp)) {
        Row(modifier = Modifier.clickable { goToSongDetails() }) {
            AsyncImage(
                model = song.songImage,
                error = painterResource(id = R.drawable.ic_broken_image),
                placeholder = painterResource(R.drawable.loading_image),
                contentDescription = null,
                modifier = Modifier.size(80.dp)
            )

            Spacer(modifier = Modifier.width(20.dp))
            Column {
                heading2(content = song.songName)
                heading3(content = stringBuilder(singers))
            }
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.MoreVert,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
//    SongListScreen()
}