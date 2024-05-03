package com.example.muisicapp.View.Home

import androidx.compose.foundation.background
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.muisicapp.Model.data.Singer
import com.example.muisicapp.Model.data.Song
import com.example.muisicapp.Model.relations.SongWithSingers
import com.example.muisicapp.ui.theme.MuisicAppTheme

@Composable
fun SongBody(
    songList: List<SongWithSingers>,
) {
    Column(
        modifier = Modifier
            .background(Color.Black)
    ) {
        if (songList.isEmpty()) {
            Text(text = "The list is empty")
        } else {
            SongList(
                songList,
                modifier = Modifier,
            )
        }

    }
}

@Composable
fun SongList(
    songList: List<SongWithSingers>,
    modifier: Modifier = Modifier,
) {
    LazyRow(
        modifier = modifier.padding(start = 18.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        items(items = songList, key = { it.song.songId!! }) { song ->
            SongItem(
                song = song.song,
                singers = song.singers
            )
        }
    }
}

@Composable
fun SongItem(
    song: Song,
    singers: List<Singer>
) {
    Column(
        modifier = Modifier
            .background(Color.Black)
            .width(120.dp)
    ) {

        Box(
            modifier = Modifier
                .size(120.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color.Black)
        ) {
            AsyncImage(
                model = song.songImage,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.background(Color.Black)
            )
        }
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = song.songName,
            fontSize = 12.sp,
            color = Color.White,
            modifier = Modifier.width(120.dp),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )



        Text(
            text = stringBuilder(singers),
            fontSize = 10.sp,
            color = Color(0xff808080),
            modifier = Modifier.width(120.dp),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )


    }
}

@Composable
private fun stringBuilder(singers: List<Singer>): String {
    val builder = StringBuilder()

    singers.forEachIndexed { index, singer ->
        builder.append(singer.singerName)
        if (index < singers.size - 1) {
            builder.append(", ")
        }
    }

    return builder.toString()

}
@Preview(showBackground = true)
@Composable
fun HomeBodyPreview() {
    MuisicAppTheme {
//        SongBody(
//
//        )
    }
}

@Preview(showBackground = true)
@Composable
fun SongItemPreview() {
    MuisicAppTheme {
//        SongItem(
//            Song(1, "Yêu anh hơn chính em", "image", "link", 3),
//        )
    }
}