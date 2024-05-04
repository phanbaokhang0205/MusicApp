package com.example.muisicapp.View.Home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.muisicapp.Model.data.Singer
import com.example.muisicapp.R
import com.example.muisicapp.ui.theme.MuisicAppTheme

@Composable
fun SingerBody(
    singerList: List<Singer>,
    goToDetailSinger: () -> Unit,
) {
    Column(
        modifier = Modifier
            .background(Color.Black)

    ) {
        if (singerList.isEmpty()) {
            Text(text = "The list is empty")
        } else {
            SingerList(
                singerList,
                modifier = Modifier,
                goToDetailSinger
            )
        }

    }
}

@Composable
fun SingerList(
    singerList: List<Singer>,
    modifier: Modifier,
    goToDetailSinger: () -> Unit,
) {
    LazyRow(
        modifier = modifier.padding(start = 18.dp),
        horizontalArrangement = Arrangement.spacedBy(22.dp),
    ) {
        items(items = singerList, key = { it.singerId!! }) { singer ->
            SingerItem(singer = singer, goToDetailSinger)
        }
    }
}

@Composable
fun SingerItem(
    singer: Singer,
    goToDetailSinger: () -> Unit,
) {
    Column(
        modifier = Modifier
            .background(Color.Black)
            .width(66.dp)
            .height(96.dp)
            .clickable { goToDetailSinger() },
    ) {
        Box(
            modifier = Modifier
                .size(64.dp)
                .clip(RoundedCornerShape(100))
                .background(Color.Black)
        ) {
            AsyncImage(
                model = singer.singerImage,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.background(Color.Black),
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = singer.singerName,
            fontSize = 12.sp,
            color = Color.White,
            modifier = Modifier.width(62.dp),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center
        )
    }
}


/**
 * Test UI
 */
@Composable
fun SingerListTest() {
    LazyRow(
        modifier = Modifier,
        horizontalArrangement = Arrangement.spacedBy(22.dp),
    ) {
        item {
            SingerTestItem()
            SingerTestItem()
            SingerTestItem()
            SingerTestItem()
        }
    }
}

@Composable
fun SingerTestItem() {
    Column(
        modifier = Modifier
            .background(Color.Black)
            .size(100.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(64.dp)
                .clip(RoundedCornerShape(100))
                .background(Color.Black)
        ) {
            Image(
                painter = painterResource(id = R.drawable.chungtacuatuonglai_mtp),
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Sơn Tùng MTP",
            fontSize = 12.sp,
            color = Color.White,
            modifier = Modifier.width(62.dp),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SingerItemPreview() {
    MuisicAppTheme {
        SingerTestItem()
    }
}

@Preview(showBackground = true)
@Composable
fun SingerItemListPreview() {
    MuisicAppTheme {
        SingerListTest()
    }
}