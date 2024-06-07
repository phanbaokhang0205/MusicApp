package com.example.muisicapp.View.Album

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.muisicapp.Model.relations.AlbumWithSongsAndSingers
import com.example.muisicapp.R
import com.example.muisicapp.View.navigation.NavigationDestination
import com.example.muisicapp.ViewModel.AppViewModelProvider
import com.example.muisicapp.ViewModel.HomeViewModel
import com.example.muisicapp.ViewModel.ListViewModel

object AlbumListDestination : NavigationDestination {
    override val route: String = "album_list"

}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AlbumListScreen(
    viewModel: ListViewModel = viewModel(factory = AppViewModelProvider.Factory),
    goToAlbumDetails: (Int) -> Unit,
    goBack: () -> Unit,
) {

    val albumUi by viewModel.albumUiState.collectAsState()

    val gradient = Brush.verticalGradient(
        colors = listOf(Color(0xF2763090), Color(0xFF000000))
    )
    Box(
        modifier = Modifier
            .background(gradient)
            .fillMaxSize()
    ) {
        Scaffold(
            containerColor = Color.Transparent,
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(Color.Transparent),
                    title = {
                        IconButton(onClick = { goBack() }) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                tint = Color.White,
                                contentDescription = null
                            )
                        }
                    })
            }) {
            Column(modifier = Modifier.padding(it)) {
                AlbumListContent(albums = albumUi.albumList, goToAlbumDetails = goToAlbumDetails)
            }
        }
    }
}

@Composable
fun AlbumListContent(
    albums: List<AlbumWithSongsAndSingers>,
    goToAlbumDetails: (Int) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp)
    ) {
        Text(
            text = "Album Phổ Biến",
            fontSize = 20.sp,
            color = Color.White,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold
        )
    }
    Row {
        LazyColumn(
            modifier = Modifier.padding(top = 20.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            items(albums, { it.album.albumId!! }) { album ->
                AlbumItemContent(
                    album = album,
                    goToAlbumDetails = { goToAlbumDetails(album.album.albumId!!) })
            }
        }
    }
}

@Composable
fun AlbumItemContent(
    album: AlbumWithSongsAndSingers,
    goToAlbumDetails: () -> Unit
) {
    Column(modifier = Modifier.padding(horizontal = 15.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { goToAlbumDetails() },
            verticalAlignment = Alignment.CenterVertically
        ) {

            AsyncImage(
                model = album.album.albumImage,
                error = painterResource(id = R.drawable.ic_broken_image),
                placeholder = painterResource(R.drawable.loading_image),
                contentDescription = null,
                modifier = Modifier.size(90.dp)
            )

            Spacer(modifier = Modifier.width(20.dp))
            Column {
                heading2(content = album.album.albumName)
            }
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.MoreVert,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
//    AlbumListScreen()
}