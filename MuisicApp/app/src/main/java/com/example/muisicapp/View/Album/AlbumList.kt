package com.example.muisicapp.View.Album

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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.muisicapp.R

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AlbumListScreen(){
    val gradient = Brush.verticalGradient(
        colors = listOf(Color(0xF2763090), Color(0xFF000000))
    )
    Box(modifier = Modifier
        .background(gradient)
        .fillMaxSize()) {
        Scaffold(
            containerColor = Color.Transparent,
            topBar = {
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
            Column (modifier = Modifier.padding(it)){
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp)) {
                    Text(text = "Album Phổ Biến", fontSize = 20.sp, color = Color.White, fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.Bold)
                }
                Row {
                    LazyColumn(modifier = Modifier.padding(top = 20.dp)
                    ,verticalArrangement = Arrangement.spacedBy(15.dp)) {
                        item { AlbumListContent() }
                    }
                }
            }
        }
    }
}

@Composable
fun AlbumListContent(){
    Column(modifier = Modifier.padding(horizontal = 15.dp)) {
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Image(painter = painterResource(R.drawable.mck99), contentDescription = null, modifier = Modifier.size(90.dp) )
            Spacer(modifier = Modifier.width(20.dp))
            Column {
                heading2(content = "99%")
                heading3(content = "MCK")
            }
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.MoreVert, contentDescription = null, tint = Color.White)
            }
        }
    }
}

@Preview (showBackground = true)
@Composable
fun Preview(){
    AlbumListScreen()
}