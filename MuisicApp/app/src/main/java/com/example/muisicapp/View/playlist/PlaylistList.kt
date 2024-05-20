package com.example.muisicapp.View.playlist

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.muisicapp.R
import com.example.muisicapp.View.Album.heading1
import com.example.muisicapp.View.Album.heading2
import com.example.muisicapp.View.Singer.songList

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PlaylistListScreen() {
    val gradient = Brush.verticalGradient(
        colors = listOf(Color(0xffA5678E), Color(0xff000000))
    )
    Box(modifier = Modifier.background(gradient)) {
        Scaffold(containerColor = Color.Transparent,topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(Color.Transparent),
                title = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            tint = Color.White,
                            contentDescription = null
                        )
                    }
                })
        }) {
            Column {
                Row(
                    modifier = Modifier
                        .padding(it)
                        .padding(horizontal = 15.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(text = "YOUR PLAYLIST", fontWeight = FontWeight.Bold,fontFamily = FontFamily.SansSerif, fontSize = 20.sp, color = Color.White)
                }
                LazyColumn(
                    modifier = Modifier.padding(top = 15.dp),
                    verticalArrangement = Arrangement.spacedBy(15.dp),
                ) {
                    item { playlistList() }
                }
            }
        }
    }
}

@Composable
fun playlistList(){
    Column(modifier = Modifier.padding(horizontal = 15.dp)) {
        Row(modifier = Modifier, verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(R.drawable.chungtacuatuonglai_mtp),
                contentDescription = null,
                modifier = Modifier
                    .size(80.dp)

            )
            Spacer(modifier = Modifier.width(20.dp))
            Column {
                heading1("Your Top Songs")
                Text(text = "6.7M likes", fontSize = 15.sp, color = Color.LightGray, modifier = Modifier.padding(top = 5.dp))
            }
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.ArrowForwardIos,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview(){
    PlaylistListScreen()
}