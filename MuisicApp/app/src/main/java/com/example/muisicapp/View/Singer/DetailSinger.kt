package com.example.muisicapp.View.Singer

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.NavigateNext
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import com.example.muisicapp.R
import com.example.muisicapp.View.Home.TopBar


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailSingerScreen() {
    Scaffold(topBar = { TopBar() }) {

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
        ) {
            item {
                imgSinger()
                popularSong()
                singerAlbum()
                popularSinger()
                singerInfor()
            }
        }
    }
}

@Composable
fun imgSinger() {
    Box(modifier = Modifier.height(400.dp)) {
        Image(
            painter = painterResource(R.drawable.img_1),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 15.dp),
            verticalArrangement = Arrangement.Bottom,
        ) {
            Column() {
                Text(
                    text = "Sơn Tùng M-TP",
                    fontSize = 25.sp,
                    color = Color.White,
                    fontFamily = FontFamily.SansSerif
                )
                Text(
                    text = "2.4M quan tâm",
                    fontSize = 17.sp,
                    fontFamily = FontFamily.SansSerif,
                    color = Color.LightGray
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 20.dp), horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.width(150.dp),
                    colors = ButtonDefaults.buttonColors(Color.Gray)
                ) {
                    Text(text = "QUAN TÂM")
                }
                Button(onClick = { /*TODO*/ }, modifier = Modifier.width(150.dp)) {
                    Text(text = "PHÁT NHẠC")
                }
            }
        }
    }
}

@Composable
fun popularSong() {
    Column {
        NavigationTitle(navTitle = "Bài Hát Nổi Bật") {

        }
        popularSongItems()
    }
}

@Composable
fun singerAlbum() {
    NavigationTitle(navTitle = "Album") {

    }
    LazyRow {
        item { albumItems() }
    }
}

@Composable
fun popularSinger() {
    NavigationTitle(navTitle = "Các ca sĩ liên quan") {

    }
    LazyRow {
        item { popularSingerItems() }
    }
}

@Composable
fun NavigationTitle(
    navTitle: String,
    onClickNavigation: () -> Unit,
) {
    Row(
        modifier = Modifier
            .background(Color.Black)
            .fillMaxWidth()
            .padding(start = 18.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = navTitle,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            IconButton(onClick = onClickNavigation) {
                Icon(
                    imageVector = Icons.Filled.NavigateNext,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }
    }
}

@Composable
fun popularSongItems() {
    Column(
        verticalArrangement = Arrangement.Center, modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 15.dp, horizontal = 20.dp)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(vertical = 15.dp), verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                contentScale = ContentScale.Crop,
                painter = painterResource(R.drawable.img_3),
                contentDescription = null,
                modifier = Modifier
                    .clip(
                        RoundedCornerShape(10.dp)
                    )
                    .size(68.dp)
            )
            Spacer(modifier = Modifier.width(15.dp))
            Column {
                Text(text = "Nơi Này Có Anh", modifier = Modifier.padding(bottom = 6.dp))
                Text(text = "Sơn Tùng MTP", fontSize = 12.sp, color = Color.Gray)
            }
            Spacer(modifier = Modifier.weight(1f))
            Icon(imageVector = Icons.Filled.MoreHoriz, contentDescription = null)
        }
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Image(
                contentScale = ContentScale.Crop,
                painter = painterResource(R.drawable.img_3),
                contentDescription = null,
                modifier = Modifier
                    .clip(
                        RoundedCornerShape(10.dp)
                    )
                    .size(68.dp)
            )
            Spacer(modifier = Modifier.width(15.dp))
            Column {
                Text(text = "Nơi Này Có Anh", modifier = Modifier.padding(bottom = 6.dp))
                Text(text = "Sơn Tùng MTP", fontSize = 12.sp, color = Color.Gray)
            }
            Spacer(modifier = Modifier.weight(1f))
            Icon(imageVector = Icons.Filled.MoreHoriz, contentDescription = null)
        }
    }
}

@Composable
fun albumItems() {
    Column(modifier = Modifier.padding(vertical = 15.dp, horizontal = 15.dp)) {
        Image(
            painter = painterResource(R.drawable.img),
            contentDescription = null,
            Modifier
                .width(120.dp)
                .clip(
                    RoundedCornerShape(16.dp)
                )
        )
        Text(
            text = "Sky Tour (Original Motion Picture Soundtrack)",
            modifier = Modifier
                .width(120.dp)
                .padding(vertical = 5.dp),
            fontSize = 15.sp,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Black,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
        Text(text = "12/06/2020")
    }
    Column(modifier = Modifier.padding(vertical = 15.dp, horizontal = 15.dp)) {
        Image(
            painter = painterResource(R.drawable.img),
            contentDescription = null,
            Modifier
                .width(120.dp)
                .clip(
                    RoundedCornerShape(16.dp)
                )
        )
        Text(
            text = "Sky Tour (Original Motion Picture Soundtrack)",
            modifier = Modifier
                .width(120.dp)
                .padding(vertical = 5.dp),
            fontSize = 15.sp,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Black,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
        Text(text = "12/06/2020")
    }
    Column(modifier = Modifier.padding(vertical = 15.dp, horizontal = 15.dp)) {
        Image(
            painter = painterResource(R.drawable.img),
            contentDescription = null,
            Modifier
                .width(120.dp)
                .clip(
                    RoundedCornerShape(16.dp)
                )
        )
        Text(
            text = "Sky Tour (Original Motion Picture Soundtrack)",
            modifier = Modifier
                .width(120.dp)
                .padding(vertical = 5.dp),
            fontSize = 15.sp,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Black,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
        Text(text = "12/06/2020")
    }
}

@Composable
fun popularSingerItems() {
    Column(
        modifier = Modifier
            .padding(vertical = 15.dp, horizontal = 15.dp)
            .width(150.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.img),
            contentDescription = null,
            modifier = Modifier
                .clip(
                    CircleShape
                )
        )
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Sơn Tùng MTP",
                color = Color.Black,
                fontFamily = FontFamily.SansSerif,
                fontSize = 14.sp,
                modifier = Modifier.padding(vertical = 6.dp)
            )
            Text(text = "2.4M quan tâm", color = Color.Gray)
        }
    }
    Column(
        modifier = Modifier
            .padding(vertical = 15.dp, horizontal = 15.dp)
            .width(150.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.img),
            contentDescription = null,
            modifier = Modifier
                .clip(
                    CircleShape
                )
        )
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Sơn Tùng MTP",
                color = Color.Black,
                fontFamily = FontFamily.SansSerif,
                fontSize = 14.sp,
                modifier = Modifier.padding(vertical = 6.dp)
            )
            Text(text = "2.4M quan tâm", color = Color.Gray)
        }
    }
    Column(
        modifier = Modifier
            .padding(vertical = 15.dp, horizontal = 15.dp)
            .width(150.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.img),
            contentDescription = null,
            modifier = Modifier
                .clip(
                    CircleShape
                )
        )
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Sơn Tùng MTP",
                color = Color.Black,
                fontFamily = FontFamily.SansSerif,
                fontSize = 14.sp,
                modifier = Modifier.padding(vertical = 6.dp)
            )
            Text(text = "2.4M quan tâm", color = Color.Gray)
        }
    }
}

@Composable
fun singerInfor() {
    var click by remember {
        mutableStateOf(false)
    }
    var maxLine by remember {
        mutableStateOf(3)
    }
    Column (modifier = Modifier.padding(vertical = 15.dp, horizontal = 15.dp)){
        Text(
            text = "Thông tin",
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Black,
            fontSize = 16.sp
        )
        Text(
            text = "Thanh Tùng bắt đầu chơi nhạc từ cấp ba với nghệ danh M-TP và được biết đến với \"Cơn Mưa Ngang Qua\".\n" +
                    "Năm 2012, anh đậu thủ khoa Nhạc viện TPHCM và ký hợp đồng với Văn Production, đổi nghệ danh sang Sơn Tùng M-TP.\n" +
                    "Từ 2013 đến 2015, anh có nhiều bản hit như \"Em Của Ngày Hôm Qua\", \"Nắng Ấm Xa Dần\"...\n" +
                    "Năm 2015, anh rời khỏi công ty cũ và gia nhập WePro, tổ chức minishow đầu tiên \"M-TP and Friends\".\n" +
                    "Năm 2017, anh rời khỏi WePro để thành lập M-TP Entertainment, ra mắt \"Lạc Trôi\" và \"Nơi Này Có Anh\". Anh ra mắt album đầu tay \"m-tp M-TP\".\n" +
                    "Năm 2018 anh ra mắt \"Chạy Ngay Đi\" và \"Hãy Trao Cho Anh\" năm 2019. Cả hai bài hát đều trở thành hit. Đặc biệt \"Hãy Trao Cho Anh\" kết hợp với Snopp Dogg đã đưa tên tuổi anh ra thế giới.",
            maxLines = maxLine,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .padding(vertical = 10.dp)
                .clickable {
                    click = !click
                    if (click) {
                        maxLine = 30
                    } else maxLine = 3
                }
        )
        Row {
            Text(text = "Tên thật", color = Color.Gray)
            Spacer(modifier = Modifier.width(40.dp))
            Text(text = "Nguyễn Thanh Tùng", fontWeight = FontWeight.Black)
        }
        Row {
            Text(text = "Ngày sinh",color = Color.Gray)
            Spacer(modifier = Modifier.width(40.dp))
            Text(text = "05/07/1994", fontWeight = FontWeight.Black)
        }
        Row {
            Text(text = "Quốc gia",color = Color.Gray)
            Spacer(modifier = Modifier.width(40.dp))
            Text(text = "Việt Nam", fontWeight = FontWeight.Black)
        }
        Row {
            Text(text = "Thể loại",color = Color.Gray)
            Spacer(modifier = Modifier.width(40.dp))
            Text(text = "Việt Nam,Rap Việt", fontWeight = FontWeight.Black)
        }
    }
}