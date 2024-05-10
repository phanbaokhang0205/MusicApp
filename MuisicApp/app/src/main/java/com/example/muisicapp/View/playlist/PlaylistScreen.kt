package com.example.muisicapp.View.playlist

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.PlayCircle
import androidx.compose.material.icons.filled.PlayCircleOutline
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.muisicapp.R
import com.example.muisicapp.View.scaffold.TopBarOption
import androidx.compose.foundation.layout.Column as Column

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PlaylistScreen() {
    Scaffold(
        topBar = { TopBarOption({},{},{}) }
    ) {
        LazyColumn(
            modifier = Modifier
                .background(Color.Black)
                .fillMaxSize()
        ) {
            item {
                imgPlaylist()
                middle()
                topSongList()
            }
        }
    }
}

@Composable
fun imgPlaylist() {
    Box(modifier = Modifier.height(400.dp)) {
        Image(
            painter = painterResource(R.drawable.img_1),
            modifier = Modifier.fillMaxSize(),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 15.dp),
            verticalArrangement = Arrangement.Bottom,
        ) {
            Column() {
                Text(
                    text = "YOUR TOP SONGS",
                    fontSize = 25.sp,
                    color = Color.White,
                    fontFamily = FontFamily.SansSerif
                )
                Text(
                    text = "2024",
                    fontSize = 40.sp,
                    fontFamily = FontFamily.SansSerif,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun middle(){
    Row(modifier = Modifier.padding(vertical = 15.dp, horizontal = 15.dp), verticalAlignment = Alignment.CenterVertically) {
        Row {
            Column {
                Row {
                    Icon(
                        imageVector = Icons.Filled.Favorite,
                        tint = Color.Gray,
                        contentDescription = null
                    )
                    Text(text = "53,483,231 likes", color = Color.Gray, modifier = Modifier.padding(start = 5.dp))
                }
            }

            Spacer(modifier = Modifier.width(20.dp))

            Column {
                Row {
                    Icon(
                        imageVector = Icons.Filled.Schedule,
                        tint = Color.Gray,
                        contentDescription = null
                    )
                    Text(text = "2h 35mins", color = Color.Gray, modifier = Modifier.padding(start = 5.dp))
                }
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Column{
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.PlayCircle,tint = Color.Green, contentDescription = null, modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
fun topSongList(){
    Column(modifier = Modifier.padding(horizontal = 15.dp)) {
        Text(text = "Featuring", color = Color.White, fontSize = 18.sp, modifier = Modifier.padding(bottom = 10.dp))
        topSongItems()
    }
}
@Composable
fun topSongItems(){
    Column {
        Row (verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxSize()){
            Image(painter = painterResource(R.drawable.img), contentDescription =null, modifier = Modifier
                .size(68.dp)
                .clip(
                    RoundedCornerShape(10.dp)
                )
            )
            Spacer(modifier = Modifier.width(15.dp))
            Column {
                Text(text = "Nơi này có anh",color = Color.White, modifier = Modifier.padding(bottom = 10.dp), fontSize = 15.sp)
                Text(text = "Sơn Tùng MTP", color = Color.Gray, fontSize = 12.sp)
            }
            Spacer(modifier = Modifier.weight(1f))
            Icon(imageVector = Icons.Filled.PlayCircleOutline, tint = Color.Gray, contentDescription = null)
            Spacer(modifier = Modifier.width(10.dp))
            Icon(imageVector = Icons.Filled.FavoriteBorder, tint = Color.Gray, contentDescription = null)
            Spacer(modifier = Modifier.width(10.dp))
            Icon(imageVector = Icons.Filled.MoreHoriz,tint = Color.White, contentDescription = null)
        }
        Row (verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxSize()){
            Image(painter = painterResource(R.drawable.img), contentDescription =null, modifier = Modifier
                .size(68.dp)
                .clip(
                    RoundedCornerShape(10.dp)
                )
            )
            Spacer(modifier = Modifier.width(15.dp))
            Column {
                Text(text = "Nơi này có anh",color = Color.White, modifier = Modifier.padding(bottom = 10.dp), fontSize = 15.sp)
                Text(text = "Sơn Tùng MTP", color = Color.Gray, fontSize = 12.sp)
            }
            Spacer(modifier = Modifier.weight(1f))
            Icon(imageVector = Icons.Filled.PlayCircleOutline, tint = Color.Gray, contentDescription = null)
            Spacer(modifier = Modifier.width(10.dp))
            Icon(imageVector = Icons.Filled.FavoriteBorder, tint = Color.Gray, contentDescription = null)
            Spacer(modifier = Modifier.width(10.dp))
            Icon(imageVector = Icons.Filled.MoreHoriz,tint = Color.White, contentDescription = null)
        }
        Row (verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxSize()){
            Image(painter = painterResource(R.drawable.img), contentDescription =null, modifier = Modifier
                .size(68.dp)
                .clip(
                    RoundedCornerShape(10.dp)
                )
            )
            Spacer(modifier = Modifier.width(15.dp))
            Column {
                Text(text = "Nơi này có anh",color = Color.White, modifier = Modifier.padding(bottom = 10.dp), fontSize = 15.sp)
                Text(text = "Sơn Tùng MTP", color = Color.Gray, fontSize = 12.sp)
            }
            Spacer(modifier = Modifier.weight(1f))
            Icon(imageVector = Icons.Filled.PlayCircleOutline, tint = Color.Gray, contentDescription = null)
            Spacer(modifier = Modifier.width(10.dp))
            Icon(imageVector = Icons.Filled.FavoriteBorder, tint = Color.Gray, contentDescription = null)
            Spacer(modifier = Modifier.width(10.dp))
            Icon(imageVector = Icons.Filled.MoreHoriz,tint = Color.White, contentDescription = null)
        }
        Row (verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxSize()){
            Image(painter = painterResource(R.drawable.img), contentDescription =null, modifier = Modifier
                .size(68.dp)
                .clip(
                    RoundedCornerShape(10.dp)
                )
            )
            Spacer(modifier = Modifier.width(15.dp))
            Column {
                Text(text = "Nơi này có anh",color = Color.White, modifier = Modifier.padding(bottom = 10.dp), fontSize = 15.sp)
                Text(text = "Sơn Tùng MTP", color = Color.Gray, fontSize = 12.sp)
            }
            Spacer(modifier = Modifier.weight(1f))
            Icon(imageVector = Icons.Filled.PlayCircleOutline, tint = Color.Gray, contentDescription = null)
            Spacer(modifier = Modifier.width(10.dp))
            Icon(imageVector = Icons.Filled.FavoriteBorder, tint = Color.Gray, contentDescription = null)
            Spacer(modifier = Modifier.width(10.dp))
            Icon(imageVector = Icons.Filled.MoreHoriz,tint = Color.White, contentDescription = null)
        }
        Row (verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxSize()){
            Image(painter = painterResource(R.drawable.img), contentDescription =null, modifier = Modifier
                .size(68.dp)
                .clip(
                    RoundedCornerShape(10.dp)
                )
            )
            Spacer(modifier = Modifier.width(15.dp))
            Column {
                Text(text = "Nơi này có anh",color = Color.White, modifier = Modifier.padding(bottom = 10.dp), fontSize = 15.sp)
                Text(text = "Sơn Tùng MTP", color = Color.Gray, fontSize = 12.sp)
            }
            Spacer(modifier = Modifier.weight(1f))
            Icon(imageVector = Icons.Filled.PlayCircleOutline, tint = Color.Gray, contentDescription = null)
            Spacer(modifier = Modifier.width(10.dp))
            Icon(imageVector = Icons.Filled.FavoriteBorder, tint = Color.Gray, contentDescription = null)
            Spacer(modifier = Modifier.width(10.dp))
            Icon(imageVector = Icons.Filled.MoreHoriz,tint = Color.White, contentDescription = null)
        }
        Row (verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxSize()){
            Image(painter = painterResource(R.drawable.img), contentDescription =null, modifier = Modifier
                .size(68.dp)
                .clip(
                    RoundedCornerShape(10.dp)
                )
            )
            Spacer(modifier = Modifier.width(15.dp))
            Column {
                Text(text = "Nơi này có anh",color = Color.White, modifier = Modifier.padding(bottom = 10.dp), fontSize = 15.sp)
                Text(text = "Sơn Tùng MTP", color = Color.Gray, fontSize = 12.sp)
            }
            Spacer(modifier = Modifier.weight(1f))
            Icon(imageVector = Icons.Filled.PlayCircleOutline, tint = Color.Gray, contentDescription = null)
            Spacer(modifier = Modifier.width(10.dp))
            Icon(imageVector = Icons.Filled.FavoriteBorder, tint = Color.Gray, contentDescription = null)
            Spacer(modifier = Modifier.width(10.dp))
            Icon(imageVector = Icons.Filled.MoreHoriz,tint = Color.White, contentDescription = null)
        }
    }
}
@Composable
fun TopBar() {
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
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = null,
                tint = Color.White
            )
        }
        Row(Modifier.padding(end = 15.dp)) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.Share,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.padding()
                )
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.MoreHoriz,
                    tint = Color.White,
                    contentDescription = null
                )
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun Preview() {
    PlaylistScreen()
}
