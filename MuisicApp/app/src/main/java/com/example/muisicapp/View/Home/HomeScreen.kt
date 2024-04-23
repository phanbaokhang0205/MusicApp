package com.example.muisicapp.View.Home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.example.muisicapp.Model.data.Song
import com.example.muisicapp.ViewModel.AppViewModelProvider
import com.example.muisicapp.ViewModel.HomeViewModel
import com.example.muisicapp.ui.theme.MuisicAppTheme

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {

    val homeUiState by viewModel.homeUiState.collectAsState()

    Scaffold(

    ) { innerPadding ->
        HomeBody(
            songList = homeUiState.songList,
            contentPadding = innerPadding
        )
    }


}

@Composable
private fun HomeBody(
    songList: List<Song>,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    Column {
        if (songList.isEmpty()) {
            Text(text = "The list is empty")
        } else {
            SongList(
                songList,
                modifier = Modifier,
                contentPadding = contentPadding,
            )
        }

    }
}

@Composable
private fun SongList(
    songList: List<Song>,
    contentPadding: PaddingValues,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = contentPadding
    ) {
        items(items = songList, key = { it.songId!! }) { song ->
            SongItem(song = song)
        }
    }
}

@Composable
private fun SongItem(
    song: Song
) {

    Column(
        modifier = Modifier
    ) {
        AsyncImage(
            model = song.songImage,
            contentDescription = null,
            modifier = Modifier.size(300.dp)
        )
        Text(text = song.songName)
    }
}

@Preview(showBackground = true)
@Composable
fun HomeBodyPreview() {
    MuisicAppTheme {
        HomeBody(
            listOf(
                Song(
                    1,
                    "Yêu anh hơn chính em",
                    "image",
                    "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.last.fm%2Fmusic%2FSon%2BTung%2BM-TP%2F%2Bimages&psig=AOvVaw2iLQ7Ex40A4KyftUAhAJee&ust=1713946154654000&source=images&cd=vfe&opi=89978449&ved=0CBIQjRxqFwoTCIiZqJDx14UDFQAAAAAdAAAAABAK",
                    3
                ),
                Song(2, "Chúng ta của hiện tại", "image", "link", 1),
                Song(3, "Khu tao sống", "image", "link", 1),
                Song(4, "Tại vì sao", "image", "link", 1),
                Song(5, "Không còn nợ nhau", "image", "link", 3),
                Song(6, "Ai nhớ chăng ai", "image", "link", 5),
                Song(7, "Xót xa", "image", "link", 5),
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SongItemPreview() {
    MuisicAppTheme {
        SongItem(
            Song(1, "Yêu anh hơn chính em", "image", "link", 3),
        )
    }
}