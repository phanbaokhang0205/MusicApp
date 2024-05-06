package com.example.muisicapp.View.Home

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.muisicapp.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailSingerScreen() {
    Scaffold(topBar = { TopBar() }) {
        Column {
            Box(
                modifier = Modifier
                    .height(365.dp)
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(R.drawable.img_1),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 15.dp),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Row {
                        singerName(name = "SƠN TÙNG MTP", care = "2.4M")
                    }
                    Row(horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 15.dp)) {
                        Button(onClick = { /*TODO*/ },border = BorderStroke(1.dp, Color.White),
                            modifier = Modifier
                                .padding(8.dp)
                                .width(155.dp) ) {
                            Text(text = "Quan Tâm")
                        }
                        Button(onClick = { /*TODO*/ },modifier = Modifier
                            .padding(8.dp)
                            .width(155.dp)) {
                            Text(text = "Phát Nhạc")
                        }
                    }
                }
            }
            popularSong()
        }
    }
}
@Composable
fun popularSong(){
    Box(modifier = Modifier.padding(top = 20.dp, start = 15.dp)) {
        Column {
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Bài Hát Nổi Bật", fontSize = 18.sp, fontWeight = FontWeight.Bold,)
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.ArrowForwardIos , contentDescription = null, modifier = Modifier.height(20.dp))
                }
            }
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(top = 10.dp)) {
                popularSongList(popularSongItems.popularSongs)
            }
        }
    }
}

@Composable
fun popularSongList(songs:List<Song>){
    LazyColumn {
        items(songs){
                song -> val image = painterResource(song.image)
            val title = song.title
            val artist = song.artist
//            val likes = song.likes
//            val duration = song.duration
            Column(modifier = Modifier
                .fillMaxSize()) {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp)){
                    Row(verticalAlignment = Alignment.CenterVertically){
                        Image(
                            painter = image, contentDescription = null,
                            modifier = Modifier
                                .size(64.dp)
                                .clip(CircleShape),
                        )
                        Spacer(modifier = Modifier.width(15.dp))
                        Column {
                            Text(text = title, modifier = Modifier.padding(bottom = 10.dp))
                            Text(text = artist)
                        }
                    }
                    Row(modifier = Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.End) {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(imageVector = Icons.Filled.FavoriteBorder, contentDescription =null )
                        }
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(imageVector = Icons.Filled.MoreHoriz, contentDescription =null )
                        }
                    }

                }
            }
        }

    }
}

object popularSongItems{
    val artist:String = "Sơn Tùng MTP"
    val popularSongs = listOf(
        Song(
            image = R.drawable.img,
            title = "Nơi Này Có Anh",
            artist = artist,
            likes = 53453235,
            duration = "2:35"
        ),
        Song(
            image = R.drawable.img_1,
            title = "Âm Thầm Bên Em",
            artist = artist,
            likes = 4353453,
            duration = "3:45"
        ),
        Song(
            image = R.drawable.img,
            title = "Chúng Ta Của Hiện Tại",
            artist = artist,
            likes = 3453453,
            duration = "4:00"
        ),
        Song(
            image = R.drawable.img_1,
            title = "Khuôn Mặt Đáng Thương",
            artist = artist,
            likes = 2345345,
            duration = "3:30"
        ),
        Song(
            image = R.drawable.img_1,
            title = "Lạc Trôi",
            artist = artist,
            likes = 1234534,
            duration = "3:00"
        ),
        Song(
            image = R.drawable.img,
            title = "Chạy Ngay Đi",
            artist = artist,
            likes = 987654,
            duration = "2:45"
        ),
        Song(
            image = R.drawable.img_1,
            title = "Đừng Về Trễ",
            artist = artist,
            likes = 654321,
            duration = "3:15"
        )
    )
}

@Composable
fun singerName(name:String,care:String) {
    Column {
        Text(text = name, fontSize = 25.sp, fontFamily = FontFamily.SansSerif, color = Color.White)
        Text(text = care + " quan tâm", fontFamily = FontFamily.SansSerif, color = Color.LightGray)
    }
}

@Preview(showBackground = true)
@Composable
fun DtSingerPreview(){
    DetailSingerScreen()
}