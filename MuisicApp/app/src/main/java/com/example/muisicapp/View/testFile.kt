package com.example.muisicapp.View

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.FiberManualRecord
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.muisicapp.R
import com.example.muisicapp.View.seekbar.SeekBar
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TestFile(

) {
    var presses by remember { mutableIntStateOf(0) }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()


    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Text("Drawer title", modifier = Modifier.padding(16.dp))
                Divider()
                NavigationDrawerItem(
                    label = { Text(text = "Drawer Item") },
                    selected = false,
                    onClick = { /*TODO*/ }
                )
                // ...other drawer items
            }
        },
    ) {
        // Screen content
        Scaffold(
            topBar = {
                TopAppBar(
                    colors = topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.primary,
                    ),
                    title = {
                        Text("Top app bar")
                    }
                )
            },
            bottomBar = {
                BottomAppBar(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    contentColor = MaterialTheme.colorScheme.primary,
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        text = "Bottom app bar",
                    )
                }
            },
            floatingActionButton = {
                FloatingActionButton(onClick = {
                    scope.launch {
                        drawerState.apply {
                            if (isClosed) open() else close()
                        }
                    }
                }) {
                    Icon(Icons.Default.Add, contentDescription = "Add")
                }
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                Column(
                    modifier = Modifier.fillMaxSize()
                ) {

                }
            }
        }
    }
}

//@Composable
//private fun SongDetails() {
//    var progress by rememberSaveable { mutableStateOf(0f) }
//    var isPlaying by rememberSaveable { mutableStateOf(false) }
//
//    var isFavourite by rememberSaveable {
//        mutableStateOf(false)
//    }
//
//    Box(modifier = Modifier) {
//        Column(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(top = 30.dp),
//            horizontalAlignment = Alignment.CenterHorizontally,
//        ) {
//            Box(modifier = Modifier, contentAlignment = Alignment.Center) {
//                Image(
//                    painter = painterResource(id = R.drawable.chungtacuatuonglai_mtp),
//                    contentDescription = null,
//                    contentScale = ContentScale.Crop,
//                    modifier = Modifier
//                        .size(300.dp)
//                        .clip(CircleShape)
//                        .graphicsLayer {
//
//                        }
//                )
//                Icon(
//                    imageVector = Icons.Filled.FiberManualRecord,
//                    contentDescription = null,
//                    tint = Color.White,
//                    modifier = Modifier.size(60.dp)
//                )
//            }
//        }
//        Box(
//            modifier = Modifier
//                .fillMaxSize()
//                .background(Color(0x6A454545))
//        )
//        Column(
//            modifier = Modifier
//                .fillMaxSize(),
//            verticalArrangement = Arrangement.Bottom
//        ) {
//            SeekBar(
//                progress = progress,
//                onProgressChange = { progress = it },
//                isPlaying = isPlaying,
//                playingEvent = {
//
//                },
//                isFavourite = isFavourite,
//                favouriteEvent = { },
//                songName = "Song name",
//                singerName = "Singer Name",
//                duration = 0
//            )
//
//        }
//    }
//}

@Preview(showBackground = true)
@Composable
fun Preview() {
//    SongDetails()
}


@Preview(showBackground = true)
@Composable
fun Preview2() {
    TestFile()
}


