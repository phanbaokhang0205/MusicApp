package com.example.muisicapp.View.Home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.muisicapp.ViewModel.HomeViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.muisicapp.Model.data.Song
import com.example.muisicapp.ViewModel.AppViewModelProvider

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {

    val homeUiState by viewModel.homeUiState.collectAsState()

    HomeBody(songList = homeUiState.songList)

}

@Composable
private fun HomeBody(
    songList: List<Song>
) {
    Column {
        if (songList.isEmpty()) {
            Text(text = "The list is empty")
        } else {
            SongList(songList)
        }

    }
}

@Composable
private fun SongList(
    songList: List<Song>,
) {
    LazyColumn {
        items(items = songList, key = { it.songId!! }) {
            song -> SongItem(song = song)
        }
    }
}

@Composable
private fun SongItem(
    song: Song
) {
    Text(text = song.songName)
    Text(text = song.songImage)
    Text(text = song.songLink)
}