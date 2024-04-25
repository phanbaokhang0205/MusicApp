package com.example.muisicapp.View.Home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.NavigateNext
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.muisicapp.ViewModel.AppViewModelProvider
import com.example.muisicapp.ViewModel.HomeViewModel
import com.example.muisicapp.ui.theme.MuisicAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {

    val songUiState by viewModel.songUiState.collectAsState()
    val singerUiState by viewModel.singerUiState.collectAsState()
    val songWithSingers by viewModel.songWithSingersUiState.collectAsState()

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
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .padding(innerPadding),
        ) {
            item {

                NavigationTitle(navTitle = "Ca sĩ nổi bật") {
                    //Chuyển sang trang ca sĩ
                }
                SingerBody(singerList = singerUiState.singerList)

                Spacer(modifier = Modifier.height(20.dp))

                NavigationTitle(navTitle = "Bài hát dành cho bạn") {
                    //Chuyển qua trang bài hát
                }
                SongBody(
                    songList = songWithSingers.songSingerList,
                )

                Spacer(modifier = Modifier.height(20.dp))

                NavigationTitle(navTitle = "Ca sĩ nổi bật") {
                    //Chuyển sang trang ca sĩ
                }
                SingerBody(singerList = singerUiState.singerList)

                Spacer(modifier = Modifier.height(20.dp))

                NavigationTitle(navTitle = "Bài hát dành cho bạn") {
                    //Chuyển qua trang bài hát
                }
                SongBody(
                    songList = songWithSingers.songSingerList
                )
            }
        }
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
            .padding(start = 18.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = navTitle,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            IconButton(onClick = onClickNavigation) {
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
        NavigationTitle("") {}
    }
}

