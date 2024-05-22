package com.example.muisicapp.View.Singer

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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.NavigateNext
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.muisicapp.Model.data.Album
import com.example.muisicapp.Model.data.Singer
import com.example.muisicapp.Model.data.Song
import com.example.muisicapp.Model.relations.SingerWithAlbums
import com.example.muisicapp.Model.relations.SingerWithSongs
import com.example.muisicapp.R
import com.example.muisicapp.View.Album.heading2
import com.example.muisicapp.View.Album.heading3
import com.example.muisicapp.View.navigation.NavigationDestination
import com.example.muisicapp.View.scaffold.TopBarOption
import com.example.muisicapp.ViewModel.AppViewModelProvider
import com.example.muisicapp.ViewModel.SingerDetailsViewModel
import com.example.muisicapp.ViewModel.toSinger
import com.example.muisicapp.ViewModel.toSingerAlbum

object SingerDetailsDestination : NavigationDestination {
    override val route: String = "singer_details"
    const val singerIdAgr = "singerId"
    val routeWithArgs = "$route/{$singerIdAgr}"
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailSingerScreen(
    viewModel: SingerDetailsViewModel = viewModel(factory = AppViewModelProvider.Factory),
    goBackEvent: () -> Unit,
    goShareEvent: () -> Unit,
    goOptionEvent: () -> Unit,
) {

    val uiState = viewModel.uiState.collectAsState()

    val singerAlbum = viewModel.singerWithAlbums.collectAsState()

    Scaffold(topBar = { TopBarOption(goBackEvent, goShareEvent, goOptionEvent) }) {

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
        ) {
            item {
                imgSinger(
                    uiState.value.singeDetails.toSinger()
                )
                popularSong(
                    uiState.value.singeDetails.toSinger()
                )
                singerAlbum(
                    singerAlbum.value.singerAlbum.toSingerAlbum()
                )
                popularSinger(

                )
                singerInfor(uiState.value.singeDetails.singer)
            }
        }
    }
}

@Composable
fun imgSinger(
    singerWithSongs: SingerWithSongs
) {
    Box(modifier = Modifier.height(400.dp)) {

        AsyncImage(
            model = singerWithSongs.singer.singerImage,
            error = painterResource(id = R.drawable.ic_broken_image),
            placeholder = painterResource(R.drawable.loading_image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 15.dp),
            verticalArrangement = Arrangement.Bottom,
        ) {
            Column() {
                Text(
                    text = singerWithSongs.singer.singerName,
                    fontSize = 25.sp,
                    color = Color.White,
                    fontFamily = FontFamily.SansSerif
                )
                Text(
                    text = "999 luot",
                    fontSize = 17.sp,
                    fontFamily = FontFamily.SansSerif,
                    color = Color.LightGray
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 20.dp), horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.width(150.dp),
                    colors = ButtonDefaults.buttonColors(Color.Gray)
                ) {
                    Text(text = "QUAN TÂM")
                }
                Button(onClick = { /*TODO*/ }, modifier = Modifier.width(150.dp)) {
                    Text(text = "PHÁT NHẠC")
                }
            }
        }
    }
}

@Composable
fun popularSong(
    singerWithSongs: SingerWithSongs
) {
    Column {
        NavigationTitle(navTitle = "Bài Hát Nổi Bật") {

        }
        singerWithSongs.songs.forEach {
            popularSongItems(
                song = it,
                singer = singerWithSongs.singer
            )
        }
    }
}

@Composable
fun popularSongItems(
    song: Song,
    singer: Singer
) {
    Column(
        verticalArrangement = Arrangement.Center, modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 15.dp, horizontal = 20.dp)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(vertical = 15.dp), verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = song.songImage,
                contentDescription = null,
                error = painterResource(id = R.drawable.ic_broken_image),
                placeholder = painterResource(R.drawable.loading_image),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(
                        RoundedCornerShape(10.dp)
                    )
                    .background(Color.Black)
                    .size(68.dp)
            )
            Spacer(modifier = Modifier.width(15.dp))
            Column {
                heading2(content = song.songName)
                heading3(content = singer.singerName)
            }
            Spacer(modifier = Modifier.weight(1f))
            Icon(imageVector = Icons.Filled.MoreHoriz, contentDescription = null)
        }
    }
}

@Composable
fun singerAlbum(
    singerWithAlbums: SingerWithAlbums
) {
    NavigationTitle(navTitle = "Album") {

    }
    Row {
        singerWithAlbums.albums.forEach {
            albumItems(
                it
            )
        }
    }
}

@Composable
fun albumItems(
    album: Album
) {
    Column(modifier = Modifier.padding(vertical = 15.dp, horizontal = 15.dp)) {
        AsyncImage(
            model = album.albumImage,
            contentDescription = null,
            error = painterResource(id = R.drawable.ic_broken_image),
            placeholder = painterResource(R.drawable.loading_image),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .background(Color.Black)
                .width(120.dp)
                .clip(
                    RoundedCornerShape(16.dp)
                )
        )
        Text(
            text = album.albumName,
            modifier = Modifier
                .width(120.dp)
                .padding(vertical = 5.dp),
            color = Color.White,
            fontSize = 15.sp,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Black,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
        Text(text = "12/06/2020", color = Color.White)
    }
}

@Composable
fun popularSinger() {
    NavigationTitle(navTitle = "Các ca sĩ liên quan") {

    }
    LazyRow {
        item { popularSingerItems() }
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
                fontSize = 16.sp,
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


@Composable
fun popularSingerItems() {
    Column(
        modifier = Modifier
            .padding(vertical = 15.dp, horizontal = 15.dp)
            .width(150.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.img),
            contentDescription = null,
            modifier = Modifier
                .clip(
                    CircleShape
                )
        )
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Sơn Tùng MTP",
                color = Color.White,
                fontFamily = FontFamily.SansSerif,
                fontSize = 14.sp,
                modifier = Modifier.padding(vertical = 6.dp)
            )
            Text(text = "7.4M quan tâm", color = Color.Gray)
        }
    }
    Column(
        modifier = Modifier
            .padding(vertical = 15.dp, horizontal = 15.dp)
            .width(150.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.mck),
            contentDescription = null,
            modifier = Modifier
                .clip(
                    CircleShape
                )
        )
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "MCK",
                color = Color.White,
                fontFamily = FontFamily.SansSerif,
                fontSize = 14.sp,
                modifier = Modifier.padding(vertical = 6.dp)
            )
            Text(text = "3.4M quan tâm", color = Color.Gray)
        }
    }
    Column(
        modifier = Modifier
            .padding(vertical = 15.dp, horizontal = 15.dp)
            .width(150.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.mck99),
            contentDescription = null,
            modifier = Modifier
                .clip(
                    CircleShape
                )
        )
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Karik",
                color = Color.White,
                fontFamily = FontFamily.SansSerif,
                fontSize = 14.sp,
                modifier = Modifier.padding(vertical = 6.dp)
            )
            Text(text = "1.1M quan tâm", color = Color.Gray)
        }
    }
}

@Composable
fun singerInfor(
    singer: Singer
) {
    var click by rememberSaveable {
        mutableStateOf(false)
    }
    var maxLine by rememberSaveable {
        mutableStateOf(3)
    }
    Column(modifier = Modifier.padding(vertical = 15.dp, horizontal = 15.dp)) {
        Text(
            text = "Thông tin",
            fontFamily = FontFamily.SansSerif,
            color = Color.White,
            fontSize = 16.sp
        )
        Text(
            text = singer.singerInfo,
            maxLines = maxLine,
            overflow = TextOverflow.Ellipsis,
            color = Color.White,
            modifier = Modifier
                .padding(vertical = 10.dp)
                .clickable {
                    click = !click
                    if (click) {
                        maxLine = 30
                    } else maxLine = 3
                }
        )
        Row {
            Text(text = "Tên thật", color = Color.Gray)
            Spacer(modifier = Modifier.width(40.dp))
            Text(text = "Vũ Lệ Quyên", color = Color.White)
        }
        Row {
            Text(text = "Ngày sinh", color = Color.Gray)
            Spacer(modifier = Modifier.width(40.dp))
            Text(text = "02/03/1981", color = Color.White)
        }
        Row {
            Text(text = "Quốc gia", color = Color.Gray)
            Spacer(modifier = Modifier.width(40.dp))
            Text(text = "Việt Nam", color = Color.White)
        }
        Row {
            Text(text = "Thể loại", color = Color.Gray)
            Spacer(modifier = Modifier.width(40.dp))
            Text(text = "Bollero, trữ tình", color = Color.White)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun preview() {
    DetailSingerScreen(goBackEvent = { /*TODO*/ }, goShareEvent = { /*TODO*/ }) {

    }
}