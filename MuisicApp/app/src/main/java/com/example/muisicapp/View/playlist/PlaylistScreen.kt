package com.example.muisicapp.View.playlist

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.Share
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.muisicapp.R
import androidx.compose.foundation.layout.Column as Column

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PlaylistScreen(){
        Scaffold(topBar = { TopBar() }) {
            Column {
                Box(
                    modifier = Modifier
                        .width(395.dp)
                        .height(365.dp)
                        .fillMaxSize()
                ) {
                    Image(
                        painter = painterResource(R.drawable.img_1),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop,
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(bottom = 20.dp, start = 15.dp),
                        verticalArrangement = Arrangement.Bottom
                    ) {
                        Text(text = "Your Top Songs", fontSize = 20.sp, color = Color.White)
                        Text(text = "2024", fontSize = 30.sp, color = Color.White)
                    }
                }
                Box(modifier = Modifier
                    .height(467.dp)
                    .width(467.dp)
                    .fillMaxSize()
                    .background(Color.LightGray)) {
                    Column {
                        Row(modifier = Modifier
                            .padding(top = 10.dp)
                            .fillMaxWidth()) {
                            Column {
                                Row(modifier = Modifier.padding(start = 15.dp)) {
                                    Icon(
                                        imageVector = Icons.Filled.Favorite,
                                        contentDescription = null,
                                        modifier = Modifier.padding(end = 5.dp)
                                    )
                                    Text(text = "53,946,923 likes")
                                }
                            }
                            Column {
                                Row(modifier = Modifier.padding(start = 15.dp)) {
                                    Icon(
                                        imageVector = Icons.Filled.Schedule,
                                        contentDescription = null,
                                        modifier = Modifier.padding(end = 5.dp)
                                    )
                                    Text(text = "2h 35min")
                                }
                            }

                        }
                        Row(modifier = Modifier.fillMaxWidth()){
                            Text(text = "Featuring", modifier = Modifier.padding(start = 15.dp, top = 15.dp), fontSize = 20.sp, color = Color.White)
                        }
                        Row {
                            songList(songItems.songs)
                        }
                    }

                }
            }
        }
}

@Composable
fun songList(songs:List<Song>){
    LazyColumn {
        items(songs){
            song -> val image = painterResource(song.image)
            val title = song.title
            val artist = song.artist
//            val likes = song.likes
//            val duration = song.duration
            Column(modifier = Modifier
                .padding(start = 15.dp, top = 15.dp)
                .fillMaxSize()) {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween){
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

object songItems {
    val songs = listOf(
        Song(
            image = R.drawable.img,
            title = "Pilihan yang terbaik",
            artist = "Ziva Magnolya",
            likes = 53453235,
            duration = "2:35"
        ),
        Song(
            image = R.drawable.img_1,
            title = "Hati-hati di jalan",
            artist = "Tulus",
            likes = 4353453,
            duration = "3:45"
        ),
        Song(
            image = R.drawable.img,
            title = "Seperti Kisah",
            artist = "Rizky Febian",
            likes = 3453453,
            duration = "4:00"
        ),
        Song(
            image = R.drawable.img_1,
            title = "Gemintang Hatiku",
            artist = "Lyodra",
            likes = 2345345,
            duration = "3:30"
        ),
        Song(
            image = R.drawable.img_1,
            title = "Easy On Me",
            artist = "Adele",
            likes = 1234534,
            duration = "3:00"
        ),
        Song(
            image = R.drawable.img,
            title = "Bertahan Terluka",
            artist = "Fabio Asher",
            likes = 987654,
            duration = "2:45"
        ),
        Song(
            image = R.drawable.img_1,
            title = "Menjadi Dia",
            artist = "Fabio Asher",
            likes = 654321,
            duration = "3:15"
        )
    )
}

@Composable
fun TopBar(){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp)
    ) {
        IconButton(
            onClick = { /*TODO*/ },
            modifier = Modifier.padding(start = 10.dp)

            ) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription =null )
        }
        Row(Modifier.padding(end = 15.dp)) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Share, contentDescription =null, modifier = Modifier.padding() )
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.MoreHoriz, contentDescription =null )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview(){
    PlaylistScreen()
}
