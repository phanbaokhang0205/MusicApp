package com.example.muisicapp.View.Singer

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.muisicapp.Model.data.Singer
import com.example.muisicapp.Model.relations.SingerWithSongs
import com.example.muisicapp.R
import com.example.muisicapp.View.Album.heading1
import com.example.muisicapp.View.Album.heading2
import com.example.muisicapp.View.navigation.NavigationDestination
import com.example.muisicapp.ViewModel.AppViewModelProvider
import com.example.muisicapp.ViewModel.HomeViewModel
import com.example.muisicapp.ViewModel.ListViewModel

object SingerListDestination : NavigationDestination {
    override val route: String = "singer_list"
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SingerListScreen(
    goBack: () -> Unit,
    viewModel: ListViewModel = viewModel(factory = AppViewModelProvider.Factory),
    goToSingerDetails: (Int) -> Unit
) {
    val gradient = Brush.verticalGradient(
        colors = listOf(Color(0xffA5678E), Color(0xff000000))
    )

    val singerWithSongs by viewModel.singerUiState.collectAsState()

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
            SingerList(
                singerList = singerWithSongs.singerSongList,
                valuePaddingValues = it,
                goToSingerDetails
            )
        }
    }
}

@Composable
fun SingerList(
    singerList: List<SingerWithSongs>,
    valuePaddingValues: PaddingValues,
    goToSingerDetails: (Int) -> Unit,
) {
    Column {
        Row(
            modifier = Modifier
                .padding(valuePaddingValues)
                .padding(horizontal = 15.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            heading1(content = "NGHỆ SĨ NỔI BẬT")
        }
        LazyColumn(
            modifier = Modifier.padding(top = 15.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp),
        ) {
            items(items = singerList, key = { it.singer.singerId!! }) { singer ->
                SingerListItem(
                    singer = singer.singer,
                    goToSingerDetails = { goToSingerDetails(singer.singer.singerId!!) }
                )
            }
        }
    }
}

@Composable
fun SingerListItem(
    singer: Singer,
    goToSingerDetails: () -> Unit,
) {
    Column(modifier = Modifier.padding(horizontal = 15.dp)) {
        Row(modifier = Modifier.clickable { goToSingerDetails() }, verticalAlignment = Alignment.CenterVertically) {

            AsyncImage(
                model = singer.singerImage,
                error = painterResource(id = R.drawable.ic_broken_image),
                placeholder = painterResource(R.drawable.loading_image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(68.dp)
                    .clip(
                        CircleShape
                    )
            )
            Spacer(modifier = Modifier.width(20.dp))
            Column {
                heading2(singer.singerName)
                Text(
                    text = "2.4M Follow",
                    fontSize = 14.sp,
                    color = Color.LightGray,
                    modifier = Modifier.padding(top = 5.dp)
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.FavoriteBorder,
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
//    SingerListScreen({},)
}