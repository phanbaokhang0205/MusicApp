package com.example.muisicapp.View.search

import android.annotation.SuppressLint
import android.app.appsearch.SearchResult
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.muisicapp.R
import com.example.muisicapp.View.Album.heading2
import com.example.muisicapp.View.Album.heading3

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SearchResultScreen() {
    Scaffold(topBar = {
        TopAppBar(colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Black
        ),title = {
            SearchTopBar {

            }
        })
    }) {
        LazyColumn(modifier = Modifier.padding(it).background(Color.Black)) {
            item { SearchResult()}
        }
    }
}

@Composable
fun SearchResult(){
    Column(modifier = Modifier.fillMaxSize().padding(vertical = 15.dp, horizontal = 15.dp)) {
        Row(modifier = Modifier.fillMaxWidth().padding(bottom = 15.dp), verticalAlignment = Alignment.CenterVertically) {
            Image(painter = painterResource(R.drawable.chungtacuatuonglai_mtp), contentDescription = null, modifier = Modifier.size(68.dp))
            Spacer(modifier = Modifier.width(15.dp))
            Column {
                heading2(content = "Chúng ta của tương lai")
                heading3(content = "Sơn Tùng MTP")
            }
            Spacer(modifier = Modifier.weight(1f))
            Icon(imageVector = Icons.Filled.MoreHoriz, contentDescription = null, tint = Color.Gray)
        }
    }
}

@Composable
fun SearchTopBar(
    goBack: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth()
            .background(Color.Black),
        verticalAlignment = Alignment.CenterVertically,

    ) {
        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null,

            modifier = Modifier
                .padding(end = 20.dp)
                .size(25.dp)
                .clickable {
                    goBack()
                }
                , tint = Color.White)

        SearchTextField(
            searchValue = "", searchOnValueChange = { /*TODO*/ }, modifier = Modifier
        )
    }
}


@Preview(showBackground = true)
@Composable
fun Preview() {
    SearchResultScreen()
}