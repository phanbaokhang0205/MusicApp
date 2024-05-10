package com.example.muisicapp.View.Home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LibraryBooks
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.NavigateNext
import androidx.compose.material.icons.filled.Timelapse
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.muisicapp.Model.relations.SongWithSingers
import com.example.muisicapp.R
import com.example.muisicapp.View.navigation.NavigationDestination
import com.example.muisicapp.View.scaffold.BottomAppBar
import com.example.muisicapp.View.scaffold.ContentTopAppBar
import com.example.muisicapp.ViewModel.AppViewModelProvider
import com.example.muisicapp.ViewModel.HomeViewModel
import com.example.muisicapp.ui.theme.Gray1
import com.example.muisicapp.ui.theme.MuisicAppTheme

object HomeDestination : NavigationDestination {
    override val route: String = "home_screen"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = viewModel(factory = AppViewModelProvider.Factory),
    goToSearchScreen: () -> Unit,
    goToAccountScreen: () -> Unit,
    goToPlaylistScreen: () -> Unit,
    goToSongDetails: (Int) -> Unit,
    goToDetailSinger: (Int) -> Unit,
) {

    val singerWithSongs by viewModel.singerUiState.collectAsState()
    val songWithSingers by viewModel.songWithSingersUiState.collectAsState()

    var isFavourite by rememberSaveable {
        mutableStateOf(false)
    }

    var isPlay by rememberSaveable {
        mutableStateOf(false)
    }

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    var selectedSong by remember { mutableStateOf<SongWithSingers?>(null) }


    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                drawerContainerColor = Color.Black,
                drawerContentColor = Color.White
            ) {
                Row(
                    modifier = Modifier
                        .padding(12.dp)
                        .fillMaxWidth()
                        .clickable { /*TODO()*/ },
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.chungtacuatuonglai_mtp),
                        contentDescription = null,
                        modifier = Modifier
                            .size(50.dp)
                            .clip(shape = RoundedCornerShape(100))
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
//                        User name
                        Text(
                            text = "Khang Phan",
                            modifier = Modifier,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                        Text(
                            text = "Xem hồ sơ",
                            modifier = Modifier,
                            fontSize = 12.sp,
                            color = Gray1
                        )
                    }
                }
                Divider()
                Spacer(modifier = Modifier.height(18.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { /*TODO()*/ }
                        .padding(horizontal = 12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        imageVector = Icons.Filled.LibraryBooks,
                        contentDescription = null,
                        modifier = Modifier.size(28.dp)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        text = "Playlist của bạn", modifier = Modifier,
                        fontSize = 18.sp
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { /*TODO()*/ }
                        .padding(horizontal = 12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        imageVector = Icons.Filled.Timelapse,
                        contentDescription = null,
                        modifier = Modifier.size(28.dp)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        text = "Nội dung gần đây", modifier = Modifier,
                        fontSize = 18.sp
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { /*TODO()*/ }
                        .padding(horizontal = 12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        imageVector = Icons.Filled.Logout,
                        contentDescription = null,
                        modifier = Modifier.size(28.dp)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        text = "Đăng xuất", modifier = Modifier,
                        fontSize = 18.sp
                    )
                }
            }
        },
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.Black,
                        titleContentColor = Color.White,
                    ),
                    title = {
                        ContentTopAppBar(
                            scope,
                            drawerState
                        )
                    }
                )
            },
            bottomBar = {
                BottomAppBar(
                    onClickFavourite = { isFavourite = !isFavourite },
                    isFavourite = isFavourite,
                    goToHomeScreen = { },
                    goToSearchScreen = { goToSearchScreen() },
                    goToAccountScreen = { goToAccountScreen() },
                    goToPlaylistScreen = { goToPlaylistScreen() },
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

                        /**
                         * TODO: Mở danh sách các ca sĩ.
                         */
                    }
                    SingerBody(
                        singerList = singerWithSongs.singerSongList,
                        /**
                         * TODO: Mở chi tiết ca sĩ
                         */
                        goToDetailSinger = goToDetailSinger
                    )



                    Spacer(modifier = Modifier.height(20.dp))

                    NavigationTitle(navTitle = "Bài hát dành cho bạn") {
                        /**
                         * TODO: Mở danh sách các bài hát.
                         */
                    }
                    SongBody(
                        songList = songWithSingers.songSingerList,
                        /**
                         * TODO: Mở chi tiết bài hát
                         */
                        goToSongDetails = goToSongDetails
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    NavigationTitle(navTitle = "Ca sĩ nổi bật") {
                        /**
                         * TODO: Mở danh sách các ca sĩ.
                         */
                    }
                    SingerBody(singerList = singerWithSongs.singerSongList) {
                        /**
                         * TODO: Mở chi tiết ca sĩ
                         */
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    NavigationTitle(navTitle = "Bài hát dành cho bạn") {
                        /**
                         * TODO: Mở danh sách các bài hát.
                         */
                    }
                    SongBody(
                        songList = songWithSingers.songSingerList,
                        /**
                         * TODO: Mở chi tiết bài hát
                         */
                        goToSongDetails = goToSongDetails
                    )
                }
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


