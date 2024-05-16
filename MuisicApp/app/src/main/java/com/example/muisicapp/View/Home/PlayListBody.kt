package com.example.muisicapp.View.Home

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.muisicapp.Model.data.Playlist
import com.example.muisicapp.Model.relations.PlaylistWithSongs
import com.example.muisicapp.Model.relations.PlaylistWithSongsAndSingers
import com.example.muisicapp.R
import com.example.muisicapp.View.navigation.NavigationDestination
import com.example.muisicapp.ui.theme.MuisicAppTheme

@Composable
fun PlayListBody(
    playList: List<PlaylistWithSongsAndSingers>,
    goToPlaylistDetails: (Int) -> Unit,
) {
    Column(
        modifier = Modifier
            .background(Color.Black)
    ) {
        if (playList.isEmpty()) {
            Text(text = "The list is empty")
        } else {
            PlayList(
                playList,
                modifier = Modifier
            ) {
                goToPlaylistDetails(it.playlist.playlistId!!)
            }
        }

    }
}

@Composable
fun PlayList(
    playList: List<PlaylistWithSongsAndSingers>,
    modifier: Modifier = Modifier,
    goToPlaylistDetails: (PlaylistWithSongsAndSingers) -> Unit,
) {
    var isSongSelected by remember { mutableStateOf(false) }

    LazyRow(
        modifier = modifier.padding(start = 18.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        items(items = playList, key = { it.playlist.playlistId!! }) { playList ->
            PlaylistItem(
                playList = playList,
                goToPlaylistDetails = { goToPlaylistDetails(playList) },
            )
        }
    }
}

@Composable
fun PlaylistItem(
    playList: PlaylistWithSongsAndSingers,
    goToPlaylistDetails:() -> Unit,
) {
    Column(
        modifier = Modifier
            .background(Color.Black)
            .width(120.dp)
            .clickable { goToPlaylistDetails() }
    ) {

        Box(
            modifier = Modifier
                .size(120.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color.Black)
        ) {
            AsyncImage(
                model = playList.playlist.playlistImage,
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
            text = playList.playlist.playlistName,
            fontSize = 12.sp,
            color = Color.White,
            modifier = Modifier.width(120.dp),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PlaylistItemPreview() {
    MuisicAppTheme {

    }
}