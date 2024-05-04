package com.example.muisicapp.View.play

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.muisicapp.R
import com.example.muisicapp.View.scaffold.TopBarOption
import com.example.muisicapp.View.seekbar.SeekBar
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PlayScreen() {
    var progress by remember { mutableStateOf(0f) }
    val coroutineScope = rememberCoroutineScope()
    var isPlaying by remember { mutableStateOf(false) }

    var isFavourite by rememberSaveable {
        mutableStateOf(false)
    }

    Scaffold(
        topBar = {
            TopBarOption(
                goBackEvent = { /*TODO*/ },
                goShareEvent = { /*TODO*/ },
                goOptionEvent = { /*TODO*/ }
            )
        }
    ) {
        Box(modifier = Modifier) {
            Image(
                painter = painterResource(id = R.drawable.img_1),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0x6A454545))
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(0.dp),
                verticalArrangement = Arrangement.Bottom
            ) {
                SeekBar(
                    progress = progress,
                    onProgressChange = { progress = it },
                    isPlaying = isPlaying,
                    playingEvent = {
                        isPlaying = !isPlaying
                        coroutineScope.launch {
                            while (isPlaying && progress < 60f) {
                                delay(1000)
                                progress += 1f
                            }
                        }
                    },
                    isFavourite = isFavourite,
                    favouriteEvent = { isFavourite = !isFavourite }
                )

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SeekBarPreview() {
    PlayScreen()
}