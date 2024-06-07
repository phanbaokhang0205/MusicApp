@file:Suppress("UNUSED_EXPRESSION")

package com.example.muisicapp.View.user

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.muisicapp.Model.data.Singer
import com.example.muisicapp.Model.data.Song
import com.example.muisicapp.R
import com.example.muisicapp.View.navigation.NavigationDestination
import com.example.muisicapp.View.scaffold.BottomAppBar
import com.example.muisicapp.View.song.stringBuilder
import com.example.muisicapp.ViewModel.AppViewModelProvider
import com.example.muisicapp.ViewModel.HomeViewModel

object AccountDestination : NavigationDestination {
    override val route: String = "account_screen"
    const val userID = "userID"
    val routeWithArgs = "${route}/{$userID}"

}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun UserDetail(
    userViewModel: HomeViewModel = viewModel(factory = AppViewModelProvider.Factory),
    goToHomeScreen: (Int) -> Unit,
    goToSearchScreen: () -> Unit,
    goToPlaylistScreen: () -> Unit,
    goBack: () -> Unit,
    goToSongDetails: (Int) -> Unit
) {

    val userUiState by userViewModel.userUiState.collectAsState()
    val loveList by userViewModel.loveUiState.collectAsState()


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
                    containerColor = Color.Transparent,
                    titleContentColor = Color.White,
                ),
                title = {
                    IconButton(onClick = { goBack() }) {
                        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                onClickFavourite = { isFavourite = !isFavourite },
                isFavourite = isFavourite,
                goToHomeScreen = { goToHomeScreen(userUiState.user.userID) },
                goToSearchScreen = { goToSearchScreen() },
                goToPlaylistScreen = { goToPlaylistScreen() },
                goToAccountScreen = {}
            )
        },
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding()
        ) {
            Column(
                modifier = Modifier
                    .weight(0.3f)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center
            ) {
                Box {
                    Image(
                        painter = painterResource(R.drawable.chungtacuatuonglai_mtp),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxSize(),
                        contentScale = ContentScale.Crop,
                    )
                    Row(
                        modifier = Modifier.padding(top = 60.dp, start = 12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Image(
                            painter = painterResource(R.drawable.chungtacuatuonglai_mtp),
                            contentDescription = null,
                            modifier = Modifier
                                .size(150.dp)
                                .clip(RoundedCornerShape(100)),
                            contentScale = ContentScale.Crop,
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Column {
                            Text(
                                text = userUiState.user.fullName,
                                fontSize = 32.sp,
                                fontWeight = FontWeight.Bold,
                            )
                            Text(
                                text = "0 người theo dõi - Đang theo dõi 5 ",
                                color = Color(0xff808080)
                            )
                        }

                    }
                }
            }
            Column(
                modifier = Modifier
                    .weight(0.7f)
                    .fillMaxSize()
                    .background(Color.Black),
            ) {
                Column(
                    modifier = Modifier.padding(12.dp)
                ) {
                    Text(
                        text = "Danh sach yêu thích",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(12.dp))

//                    Lazy Column
                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        items(
                            items = loveList.songList,
                            key = { it.song.song.songId!! }
                        ) { song ->
                            LoveSongItem(
                                song = song.song.song,
                                singers = song.song.singers,
                                goToSongDetails = { goToSongDetails(song.song.song.songId!!) }
                            )
                        }
                    }
                }
            }

        }
    }
}

@Composable
fun LoveSongItem(
    song: Song,
    singers: List<Singer>,
    goToSongDetails: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                goToSongDetails()
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = song.songImage,
            error = painterResource(id = R.drawable.ic_broken_image),
            placeholder = painterResource(R.drawable.loading_image),
            contentDescription = null,
            modifier = Modifier
                .size(55.dp)
                .clip(
                    RoundedCornerShape(5.dp)
                ),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(12.dp))
        Column {
            Text(text = song.songName, color = Color.White)
            Text(text = stringBuilder(singers = singers), color = Color(0xff808080))
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun Preview() {
//    UserDetail({},{},{},{})
//}