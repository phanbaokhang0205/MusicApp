package com.example.muisicapp.View.Home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LibraryBooks
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Timelapse
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.muisicapp.R
import com.example.muisicapp.View.seekbar.CircleSeekBar
import com.example.muisicapp.ui.theme.Black1
import com.example.muisicapp.ui.theme.Gray1
import com.example.muisicapp.ui.theme.Gray2
import com.example.muisicapp.ui.theme.Green1
import com.example.muisicapp.ui.theme.MuisicAppTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldHome() {

    var isFavourite by rememberSaveable {
        mutableStateOf(false)
    }

    var isPlay by rememberSaveable {
        mutableStateOf(false)
    }

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                drawerContainerColor = Color.Black,
                drawerContentColor = Color.White
            ) {
                Row(
                    modifier = Modifier
                        .padding(12.dp)
                        .fillMaxWidth()
                        .clickable { /*TODO()*/ },
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.chungtacuatuonglai_mtp),
                        contentDescription = null,
                        modifier = Modifier
                            .size(50.dp)
                            .clip(shape = RoundedCornerShape(100))
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
//                        User name
                        Text(
                            text = "Khang Phan",
                            modifier = Modifier,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                        Text(
                            text = "Xem hồ sơ",
                            modifier = Modifier,
                            fontSize = 12.sp,
                            color = Gray1
                        )
                    }
                }
                Divider()
                Spacer(modifier = Modifier.height(18.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { /*TODO()*/ }
                        .padding(horizontal = 12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        imageVector = Icons.Filled.LibraryBooks,
                        contentDescription = null,
                        modifier = Modifier.size(28.dp)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        text = "Playlist của bạn", modifier = Modifier,
                        fontSize = 18.sp
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { /*TODO()*/ }
                        .padding(horizontal = 12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        imageVector = Icons.Filled.Timelapse,
                        contentDescription = null,
                        modifier = Modifier.size(28.dp)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        text = "Nội dung gần đây", modifier = Modifier,
                        fontSize = 18.sp
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { /*TODO()*/ }
                        .padding(horizontal = 12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        imageVector = Icons.Filled.Logout,
                        contentDescription = null,
                        modifier = Modifier.size(28.dp)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        text = "Đăng xuất", modifier = Modifier,
                        fontSize = 18.sp
                    )
                }
            }
        },
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.Black,
                        titleContentColor = Color.White,
                    ),
                    title = {
                        ContentTopAppBar(
                            scope,
                            drawerState
                        )
                    }
                )
            },
            bottomBar = {
                BottomAppBar(
                    onClickFavourite = {
                        isFavourite = !isFavourite
                    },
                    onClickPlaying = {
                        isPlay = !isPlay
                    },
                    isFavourite = isFavourite,
                    isPlaying = isPlay
                )
            },

            ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                Text(text = "asdasdasd")
                LazyRow {
                    item {
                        Text(text = "asdasdsda")
                        Text(text = "asdasdsda")
                        Text(text = "asdasdsda")
                        Text(text = "asdasdsda")
                        Text(text = "asdasdsda")
                        Text(text = "asdasdsda")
                        Text(text = "asdasdsda")
                        Text(text = "asdasdsda")
                    }
                }
            }
        }
    }


}


@Composable
fun ContentTopAppBar(
    scope: CoroutineScope,
    drawerState: DrawerState
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 10.dp),
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
                color = Gray1
            )
        }
        Spacer(modifier = Modifier.weight(1f))
//                        Image User
        Box(modifier = Modifier) {
            Image(
                painter = painterResource(id = R.drawable.chungtacuatuonglai_mtp),
                contentDescription = null,
                modifier = Modifier
                    .width(34.dp)
                    .height(34.dp)
                    .clip(shape = RoundedCornerShape(100))
                    .clickable {
                        scope.launch {
                            drawerState.apply {
                                if (isClosed) open() else close()
                            }
                        }
                    }
            )
        }
    }
}

@Composable
fun BottomAppBar(
    onClickFavourite: () -> Unit,
    onClickPlaying: () -> Unit,
    isFavourite: Boolean,
    isPlaying: Boolean,
) {
    Column(
        modifier = Modifier
            .wrapContentSize()
            .height(120.dp)
    ) {
        BottomAppBar(
            containerColor = Black1,
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
                            color = Gray1
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
                            onClickFavourite()
                        },
                    ) {
                        Icon(
                            imageVector = if (isFavourite) Icons.Filled.Favorite
                            else Icons.Filled.FavoriteBorder,
                            contentDescription = null,
                            tint = if (isFavourite) Green1
                            else Gray1,
                        )
                    }

                    CircleSeekBar(30f)
                }
            }
        }
        BottomAppBar(
            containerColor = Gray2,
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
                        modifier = Modifier,
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Home,
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )

                        Text(text = "Trang chủ", fontSize = 10.sp)
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

                        Text(text = "Tìm kiếm", fontSize = 10.sp)
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

                        Text(text = "Playlist", fontSize = 10.sp)
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
                        Text(text = "Tài khoản", fontSize = 10.sp)
                    }
                }
            }
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