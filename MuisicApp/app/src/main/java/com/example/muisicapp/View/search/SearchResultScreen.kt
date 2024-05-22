package com.example.muisicapp.View.search

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.muisicapp.Model.data.Singer
import com.example.muisicapp.Model.data.Song
import com.example.muisicapp.Model.relations.SongWithSingers
import com.example.muisicapp.R
import com.example.muisicapp.View.Album.heading2
import com.example.muisicapp.View.Album.heading3
import com.example.muisicapp.View.navigation.NavigationDestination
import com.example.muisicapp.View.song.stringBuilder
import com.example.muisicapp.ViewModel.AppViewModelProvider
import com.example.muisicapp.ViewModel.SearchViewModel

object SearchResultDestination : NavigationDestination {
    override val route: String = "search_result"
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SearchResultScreen(
    viewModel: SearchViewModel = viewModel(factory = AppViewModelProvider.Factory),
    goBack: () -> Unit,

    ) {

    val searchQuery = viewModel.searchQuery.collectAsState()
    val searchResults = viewModel.searchResults.collectAsState()

    Scaffold(topBar = {
        TopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.Black,
            ), title = {
                SearchTopBar(goBack, searchQuery.value) { viewModel.updateSearchQuery(it) }
            })
    }) {

        SearchResultList(paddingValues = it, result = searchResults.value.searchResult)
    }
}

@Composable
fun SearchResultList(
    paddingValues: PaddingValues,
    result: List<SongWithSingers>,

) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .background(Color.Black)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        result.forEachIndexed { index, item ->
            SearchResult(song = item.song, singers = item.singers, goToSongDetails =  {})
        }
    }
}


@Composable
fun SearchResult(
    song: Song,
    singers: List<Singer>,
    goToSongDetails: () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(vertical = 15.dp, horizontal = 15.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 15.dp)
                .clickable { goToSongDetails() }, verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = song.songImage,
                contentDescription = null,
                error = painterResource(id = R.drawable.ic_broken_image),
                placeholder = painterResource(R.drawable.loading_image),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(68.dp)
            )

            Spacer(modifier = Modifier.width(15.dp))
            Column {
                heading2(content = song.songName)
                heading3(content = stringBuilder(singers))
            }
            Spacer(modifier = Modifier.weight(1f))
            Icon(imageVector = Icons.Filled.MoreHoriz, contentDescription = null, tint = Color.Gray)
        }
    }
}

@Composable
fun SearchTopBar(
    goBack: () -> Unit,
    searchValue: String,
    searchValueChange: (String) -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black),
        verticalAlignment = Alignment.CenterVertically,

        ) {
        Icon(
            imageVector = Icons.Filled.ArrowBack, contentDescription = null,

            modifier = Modifier
                .padding(end = 20.dp)
                .size(25.dp)
                .clickable {
                    goBack()
                }, tint = Color.White
        )

        SearchTextField(
            searchValue = searchValue, searchOnValueChange = searchValueChange, modifier = Modifier
        )
    }
}


@Preview(showBackground = true)
@Composable
fun Preview() {
//    SearchResultScreen()
}