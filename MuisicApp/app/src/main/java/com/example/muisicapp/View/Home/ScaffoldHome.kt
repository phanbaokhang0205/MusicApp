package com.example.muisicapp.View.Home

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Collections
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LibraryBooks
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ViewList
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.muisicapp.R
import com.example.muisicapp.ui.theme.MuisicAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldHome() {

    var isFavourite by rememberSaveable {
        mutableStateOf(false)
    }

    var isPlay by rememberSaveable {
        mutableStateOf(false)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = Color.Black,
                    titleContentColor = Color.White,
                ),
                title = {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
//                        Welcome user
                        Column(
                            modifier = Modifier.wrapContentSize(),
                        ) {
                            Text(
                                text = "Hello Khang!",
                                fontSize = 14.sp,
                            )
                            Text(
                                text = "Let's listen to something cool today",
                                fontSize = 12.sp,
                                color = Color(0xff808080)
                            )
                        }
//                        Image User
                        Box(modifier = Modifier) {
                            Image(
                                painter = painterResource(id = R.drawable.chungtacuatuonglai_mtp),
                                contentDescription = null,
                                modifier = Modifier
                                    .width(34.dp)
                                    .height(34.dp)
                                    .clip(shape = RoundedCornerShape(100))
                            )
                        }


                    }
                }
            )
        },
        bottomBar = {
            Column(
                modifier = Modifier
                    .wrapContentSize()
                    .height(120.dp)
            ) {
                BottomAppBar(
                    containerColor = Color(0xff232323),
                    contentColor = Color.White,
                    modifier = Modifier.weight(1f)
                ) {
                    Row(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.weight(1f),

                            ) {
                            Box(
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(shape = RoundedCornerShape(10.dp))
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.chungtacuatuonglai_mtp),
                                    contentDescription = null
                                )
                            }
                            Spacer(modifier = Modifier.width(10.dp))
                            Column(

                            ) {
                                Text(text = "Chúng ta của hiện tại", fontSize = 10.sp)
                                Spacer(modifier = Modifier.height(5.dp))
                                Text(
                                    text = "Sơn Tùng MTP",
                                    fontSize = 10.sp,
                                    color = Color(0xff808080)
                                )
                            }
                        }

                        Row(
                            modifier = Modifier.weight(1f),
                            horizontalArrangement = Arrangement.End,
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            IconButton(
                                onClick = {
                                    isFavourite = !isFavourite
                                },
                            ) {
                                Icon(
                                    imageVector = if (isFavourite) Icons.Filled.Favorite
                                    else Icons.Filled.FavoriteBorder,
                                    contentDescription = null,
                                    tint = if (isFavourite) Color(0xff059F05)
                                    else Color(0xff808080),
                                )
                            }

                            IconButton(onClick = {
                                isPlay = !isPlay
                            }) {
                                Icon(
                                    imageVector = if (isPlay) Icons.Filled.Pause
                                    else Icons.Filled.PlayArrow,
                                    contentDescription = null,
                                    tint = Color(0xffD9D9D9)
                                )
                            }
                        }
                    }
                }
                BottomAppBar(
                    containerColor = Color(0xff474747),
                    contentColor = Color.White,
                    modifier = Modifier.weight(1f)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        IconButton(
                            onClick = { /*TODO*/ },
                            modifier = Modifier.size(80.dp),
                        ) {
                            Column(
                                modifier = Modifier.height(46.dp).width(30.dp),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Home,
                                    contentDescription = null,
                                    modifier = Modifier.size(24.dp)
                                )

                                Text(text = "Home", fontSize = 10.sp)
                            }
                        }

                        IconButton(
                            onClick = { /*TODO*/ },
                            modifier = Modifier.size(80.dp),
                        ) {
                            Column(
                                modifier = Modifier,
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Search,
                                    contentDescription = null,
                                    modifier = Modifier.size(24.dp)
                                )

                                Text(text = "Search", fontSize = 10.sp)
                            }
                        }

                        IconButton(
                            onClick = { /*TODO*/ },
                            modifier = Modifier.size(80.dp),

                        ) {
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.LibraryBooks,
                                    contentDescription = null,
                                    modifier = Modifier.size(24.dp)
                                )

                                Text(text = "Your Playlist", fontSize = 10.sp)
                            }
                        }

                        IconButton(
                            onClick = { /*TODO*/ },
                            modifier = Modifier.size(80.dp),
                        ) {
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.AccountCircle,
                                    contentDescription = null,
                                    modifier = Modifier.size(24.dp)
                                )
                                Text(text = "Account", fontSize = 10.sp)
                            }
                        }
                    }
                }
            }
        },

        ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {

        }
    }
}


@Preview(showBackground = true)
@Composable
fun ScaffoldPreview() {
    MuisicAppTheme {
        ScaffoldHome()
    }
}