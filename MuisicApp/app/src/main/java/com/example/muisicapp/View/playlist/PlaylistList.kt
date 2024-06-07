package com.example.muisicapp.View.playlist

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
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
import com.example.muisicapp.Model.relations.PlaylistWithSongsAndSingers
import com.example.muisicapp.R
import com.example.muisicapp.View.Album.heading1
import com.example.muisicapp.View.navigation.NavigationDestination
import com.example.muisicapp.ViewModel.AppViewModelProvider
import com.example.muisicapp.ViewModel.HomeViewModel
import com.example.muisicapp.ViewModel.ListViewModel

object PlaylistListDestination : NavigationDestination {
    override val route: String = "playlist_list"
}
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PlaylistListScreen(
    viewModel: ListViewModel = viewModel(factory = AppViewModelProvider.Factory),
    goToPlaylistDetails: (Int) -> Unit,
    goBack:()-> Unit,
) {

    val playList by viewModel.playListUiState.collectAsState()

    val gradient = Brush.verticalGradient(
        colors = listOf(Color(0xFF068D36), Color(0xff000000))
    )
    Box(modifier = Modifier.background(gradient)) {
        Scaffold(containerColor = Color.Transparent, topBar = {
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
            playlistList(

                playList.playList,
                it,
                goToPlaylistDetails
            )
        }
    }
}

@Composable
fun playlistList(
    playlists: List<PlaylistWithSongsAndSingers>,
    valuePaddingValues: PaddingValues,
    goToPlaylistDetails: (Int) -> Unit,
) {
    Column {
        Row(
            modifier = Modifier
                .padding(valuePaddingValues)
                .padding(horizontal = 15.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "YOUR PLAYLIST",
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                fontSize = 20.sp,
                color = Color.White
            )
        }
        LazyColumn(
            modifier = Modifier.padding(top = 15.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp),
        ) {
            items(playlists, { it.playlist.playlistId!! }) {
                playlistItem(
                    playList = it,
                    goToPlaylistDetails = { goToPlaylistDetails(it.playlist.playlistId!!) })
            }
        }
    }
}

@Composable
fun playlistItem(
    playList: PlaylistWithSongsAndSingers,
    goToPlaylistDetails: () -> Unit,
) {
    Column(modifier = Modifier.padding(horizontal = 15.dp)) {
        Row(
            modifier = Modifier.clickable { goToPlaylistDetails() },
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = playList.playlist.playlistImage,
                contentDescription = null,
                error = painterResource(id = R.drawable.ic_broken_image),
                placeholder = painterResource(R.drawable.loading_image),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(12.dp))
            )
            Spacer(modifier = Modifier.width(20.dp))
            Column {
                heading1(playList.playlist.playlistName)
                Text(
                    text = "6.7M likes",
                    fontSize = 15.sp,
                    color = Color.LightGray,
                    modifier = Modifier.padding(top = 5.dp)
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = { goToPlaylistDetails() }) {
                Icon(
                    imageVector = Icons.Filled.ArrowForwardIos,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Previews() {
//    PlaylistListScreen({})
}