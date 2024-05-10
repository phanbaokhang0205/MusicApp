package com.example.muisicapp.View.Album


import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowCircleDown
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.FiberManualRecord
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.muisicapp.R
import com.example.muisicapp.View.scaffold.TopBarOption

val gradient = Brush.linearGradient(
    colors = listOf(Color(0xff5898E0), Color(0xff000000))
)

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AlbumScreen() {
    Scaffold(topBar = { TopBarOption({},{},{}) }) {

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
        ) {
            item {
                albumBox()
                albumSongs()
                dateAlbum()
                aboutArtist()
            }
        }
    }
}

@Composable
fun albumBox() {
    Box(
        modifier = Modifier
            .height(400.dp)
            .fillMaxSize()
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()
                .background(gradient)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()

            ) {
                Image(
                    painter = painterResource(R.drawable.img),
                    contentDescription = null,
                    modifier = Modifier
                        .size(200.dp)
                        .fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                Text(
                    modifier = Modifier.padding(top = 7.dp),
                    text = "Sky Tour (Original Motion Picture Soundtrack)",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontFamily = FontFamily.SansSerif
                )
                heading2(content = "Sơn Tùng MTP")
                Row(verticalAlignment = Alignment.CenterVertically) {
                    heading3(content = "Album")
                    Icon(
                        imageVector = Icons.Filled.FiberManualRecord,
                        tint = Color.Gray,
                        modifier = Modifier
                            .size(10.dp)
                            .padding(start = 2.dp),
                        contentDescription = null
                    )
                    heading3(content = "2020")
                }
            }
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 7.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = Icons.Filled.ArrowCircleDown,
                        tint = Color.Gray,
                        contentDescription = null
                    )
                    heading3(content = "Download")
                }
                Spacer(modifier = Modifier.width(20.dp))
                Column {
                    Button(
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(Color(0xff1ED760))
                    ) {
                        Text(text = "PHÁT NHẠC", color = Color.Black)
                    }
                }
                Spacer(modifier = Modifier.width(20.dp))
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = Icons.Filled.FavoriteBorder,
                        tint = Color.Gray,
                        contentDescription = null
                    )
                    heading3(content = "Thích")
                }
            }
        }
    }
}

@Composable
fun albumSongs() {
    Column(modifier = Modifier.padding(vertical = 15.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 10.dp)
        ) {
            Text(text = "1", fontSize = 15.sp, color = Color.White)
            Spacer(modifier = Modifier.width(20.dp))
            Column {
                heading2(content = "Sky Tour Intro")
                heading3(content = "Sơn Tùng MTP")
            }
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.MoreHoriz,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 10.dp)
        ) {
            Text(text = "2", fontSize = 15.sp, color = Color.White)
            Spacer(modifier = Modifier.width(20.dp))
            Column {
                heading2(content = "Chạy Ngay Đi (Sky Tour 2019)")
                heading3(content = "Sơn Tùng MTP")
            }
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.MoreHoriz,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 10.dp)
        ) {
            Text(text = "3", fontSize = 15.sp, color = Color.White)
            Spacer(modifier = Modifier.width(20.dp))
            Column {
                heading2(content = "Chúng Ta Không Thuộc Về Nhau")
                heading3(content = "Sơn Tùng MTP")
            }
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.MoreHoriz,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 10.dp)
        ) {
            Text(text = "4", fontSize = 15.sp, color = Color.White)
            Spacer(modifier = Modifier.width(20.dp))
            Column {
                heading2(content = "Lạc Trôi (Sky Tour 2019)")
                heading3(content = "Sơn Tùng MTP")
            }
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.MoreHoriz,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }
    }
}

@Composable
fun aboutArtist() {
    Column(modifier = Modifier.padding(horizontal = 15.dp, vertical = 20.dp)) {
        heading1(content = "Về nghệ sĩ")
        Box(
            modifier = Modifier
                .background(Color.LightGray)
                .padding(horizontal = 10.dp)
                .clip(RoundedCornerShape(16.dp))
        ) {
            Column {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(vertical = 15.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.img), modifier = Modifier
                            .size(68.dp)
                            .clip(
                                CircleShape
                            ), contentDescription = null
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Column {
                        Text(
                            text = "Sơn Tùng MTP",
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.SansSerif
                        )
                        Text(text = "2.4M quan tâm")
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier.width(100.dp),
                        colors = ButtonDefaults.buttonColors(
                            Color.Transparent
                        ),
                        border = BorderStroke(width = 1.dp, Color.White)
                    ) {
                        Text(text = "QUAN TÂM", fontSize = 10.sp, color = Color.Black)
                    }
                }
                Row(modifier = Modifier.padding(bottom = 10.dp)) {
                    Text(
                        text = "Có chất giọng cao luyến láy cùng những bản hit R&B \n" +
                                "hay Dance Pop, Sơn Tùng M-TP là ca sĩ rất thành \n" +
                                "công, không chỉ nổi tiếng ở Việt Nam mà còn được \n" +
                                "khán giả yêu nhạc Việt trên thế giới biết đến."
                    )
                }
            }
        }
    }
}

@Composable
fun dateAlbum() {
    Column(modifier = Modifier.padding(start = 15.dp)) {
        heading3(content = "Phát hành 12/06/2020")
        heading3(content = "7 bài hát, 28 phút")
        heading3(content = "Cung cấp b VIVI ENM")
    }
}

@Composable
fun heading2(content: String) {
    Text(
        text = content,
        modifier = Modifier.padding(vertical = 5.dp),
        color = Color.White,
        fontSize = 14.sp
    )
}

@Composable
fun heading3(content: String) {
    Text(
        text = content,
        color = Color.Gray,
        fontSize = 12.sp,
        modifier = Modifier.padding(vertical = 3.dp)
    )
}

@Composable
fun heading1(content: String) {
    Text(
        text = content,
        modifier = Modifier.padding(vertical = 5.dp),
        color = Color.White,
        fontSize = 17.sp
    )
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    AlbumScreen()
}