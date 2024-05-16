package com.example.muisicapp.View.Home


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.muisicapp.Model.data.Album
import com.example.muisicapp.Model.relations.AlbumWithSongs
import com.example.muisicapp.Model.relations.AlbumWithSongsAndSingers
import com.example.muisicapp.R
import com.example.muisicapp.ui.theme.MuisicAppTheme

@Composable
fun AlbumBody(
    albumList: List<AlbumWithSongsAndSingers>,
    goToDetailAlbum: (Int) -> Unit,
) {
    Column(
        modifier = Modifier
            .background(Color.Black)

    ) {
        if (albumList.isEmpty()) {
            Text(text = "The list is empty")
        } else {
            AlbumList(
                albumList,
                modifier = Modifier
            ) { goToDetailAlbum(it.album.albumId!!) }
        }

    }
}

@Composable
fun AlbumList(
    albumList: List<AlbumWithSongsAndSingers>,
    modifier: Modifier,
    goToDetailAlbum: (AlbumWithSongsAndSingers) -> Unit,
) {
    LazyRow(
        modifier = modifier.padding(start = 18.dp),
        horizontalArrangement = Arrangement.spacedBy(22.dp),
    ) {
        items(items = albumList, key = { it.album.albumId!! }) { album ->
            AlbumItem(album = album) { goToDetailAlbum(album) }
        }
    }
}

@Composable
fun AlbumItem(
    album: AlbumWithSongsAndSingers,
    goToDetailAlbum: () -> Unit,
) {
    Column(
        modifier = Modifier
            .background(Color.Black)
            .width(120.dp)
            .clickable { goToDetailAlbum() }
    ) {

        Box(
            modifier = Modifier
                .size(120.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color.Black)
        ) {
            AsyncImage(
                model = album.album.albumImage,
                contentDescription = null,
                error = painterResource(id = R.drawable.ic_broken_image),
                placeholder = painterResource(R.drawable.loading_image),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .background(Color.Black)
                    .fillMaxSize()
                    .align(Alignment.Center),
            )
        }
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = album.album.albumName,
            fontSize = 12.sp,
            color = Color.White,
            modifier = Modifier.width(120.dp),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}


/**
 * Test UI
 */
@Composable
fun AlbumListTest() {
    LazyRow(
        modifier = Modifier,
        horizontalArrangement = Arrangement.spacedBy(22.dp),
    ) {
        item {
            AlbumTestItem()
            AlbumTestItem()
            AlbumTestItem()
            AlbumTestItem()
        }
    }
}

@Composable
fun AlbumTestItem() {
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
fun AlbumItemPreview() {
    MuisicAppTheme {
        AlbumTestItem()
    }
}

@Preview(showBackground = true)
@Composable
fun AlbumItemListPreview() {
    MuisicAppTheme {
        AlbumListTest()
    }
}