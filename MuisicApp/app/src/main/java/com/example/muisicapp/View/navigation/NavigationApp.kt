package com.example.muisicapp.View.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.muisicapp.R
import com.example.muisicapp.ui.theme.MuisicAppTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun test() {
    Scaffold(
        topBar = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
                }

                Row {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
                    }
                }
            }
        }
    ) { it ->
        Column(
            modifier = Modifier
                .padding()
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .padding()
                    .fillMaxWidth()
                    .height(377.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.chungtacuatuonglai_mtp),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .blur(5.dp)
                        .background(Color.Transparent),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Text(
                        text = "ANCHCHCHASODO \n AJSDHKJAHDS",
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                }


            }

            Box(modifier = Modifier
                .background(Color.Black)
                .fillMaxSize()) {
                LazyColumn {
                    item {
                        Text(text = "asddsdasd", color = Color.White)
                        Text(text = "asddsdasd", color = Color.White)
                        Text(text = "asddsdasd", color = Color.White)
                        Text(text = "asddsdasd", color = Color.White)
                        Text(text = "asddsdasd", color = Color.White)
                        Text(text = "asddsdasd", color = Color.White)
                        Text(text = "asddsdasd", color = Color.White)
                    }
                }
            }


        }
    }
}

@Composable
fun PlayButton() {
    // Sử dụng Box để Divider và Text chồng lên nhau
    Box(modifier = Modifier
        .fillMaxWidth()
        .background(Color.Black)) {
        Divider(
            thickness = 0.dp,
            color = Color.Black,
            modifier = Modifier.align(Alignment.Center) // căn giữa với Column chứa Text
        )
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.End // căn chỉnh Text vào giữa Column
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.PlayArrow, contentDescription = null, tint = Color.White)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    MuisicAppTheme {
        PlayButton()
    }
}

@Preview(showBackground = true)
@Composable
fun testPreview() {
    MuisicAppTheme {
        test()
    }
}