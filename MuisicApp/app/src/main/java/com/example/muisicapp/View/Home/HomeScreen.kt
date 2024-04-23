package com.example.muisicapp.View.Home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.NavigateNext
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.muisicapp.Model.data.Song
import com.example.muisicapp.ViewModel.AppViewModelProvider
import com.example.muisicapp.ViewModel.HomeViewModel
import com.example.muisicapp.ui.theme.MuisicAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {

    val homeUiState by viewModel.homeUiState.collectAsState()


    var isFavourite by rememberSaveable {
        mutableStateOf(false)
    }

    var isPlay by rememberSaveable {
        mutableStateOf(false)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Black,
                    titleContentColor = Color.White,
                ),
                title = {
                    ContentTopAppBar()
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                onClickFavourite = {
                    isFavourite = !isFavourite
                },
                onClickPlaying = {
                    isPlay = !isPlay
                },
                isFavourite = isFavourite,
                isPlaying = isPlay
            )
        },

        ) { innerPadding ->

        NavigationTitle("Songs for you", {})

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

    Column(
        modifier = Modifier.background(Color.Black)
    ) {


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
    LazyRow(
        modifier = modifier,
        contentPadding = contentPadding,
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        items(items = songList, key = { it.songId!! }) { song ->
            SongItem(song = song)
        }
    }
}

@Composable
private fun SongItem(
    song: Song,
) {
    Column(
        modifier = Modifier
            .background(Color.Black)
            .width(130.dp)
    ) {

        Box(
            modifier = Modifier
                .size(130.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color.Black)
        ) {
            AsyncImage(
                model = song.songImage,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.background(Color.Black)
            )
        }
        Spacer(modifier = Modifier.height(12.dp))
        Text(text = song.songName, fontSize = 12.sp, color = Color.White)

        Text(text = song.songName, fontSize = 10.sp, color = Color(0xff808080))
    }
}

@Composable
fun NavigationTitle(
    navTitle: String,
    onClickNavigation: () -> Unit,
) {
    Row(
        modifier = Modifier
            .background(Color.Black)
            .fillMaxWidth()
    ) {
        TextButton(onClick = {
            onClickNavigation()
        }) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = navTitle,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Icon(
                    imageVector = Icons.Filled.NavigateNext,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TextButtonPreview() {
    MuisicAppTheme {
//        NavigationTitle()
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
                    "",
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