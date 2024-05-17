package com.example.muisicapp.View.search

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.muisicapp.View.navigation.NavigationDestination
import com.example.muisicapp.View.scaffold.BottomAppBar
import com.example.muisicapp.ui.theme.MuisicAppTheme

object SearchDestination : NavigationDestination {
    override val route: String = "search_screen"

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    goToHomeScreen: () -> Unit,
    goToAccountScreen: () -> Unit,
    goToPlaylistScreen: () -> Unit,
    goBack: () -> Unit
) {
    var isFavourite by rememberSaveable {
        mutableStateOf(false)
    }

    var isPlay by rememberSaveable {
        mutableStateOf(false)
    }

    var showAllItems by rememberSaveable {
        mutableStateOf(false)
    }
    val itemsToShow = if (showAllItems) {
        RecommendList.recommends
    } else {
        RecommendList.recommends.take(6)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Black,
                    titleContentColor = Color.White,
                ),
                title = {
                    SearchTopBar {

                    }
                },
            )


        },

        ) {
        Column(
            modifier = Modifier
                .padding(it)
                .background(Color.Black)
                .fillMaxSize()
        ) {
//            Đề xuất tìm kiếm
            RecommendSearch(
                showAllItems = showAllItems,
                onEventChange = { showAllItems = !showAllItems },
                itemsToShow = itemsToShow
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SearchPreview() {
    MuisicAppTheme {
        SearchScreen({}, {}, {}, {})
    }
}

//          Ô nhập tìm kiếm
@Composable
fun SearchTextField(
    searchValue: String,
    searchOnValueChange: () -> Unit,
    modifier: Modifier,
) {
    OutlinedTextField(value = searchValue,
        onValueChange = { searchOnValueChange() },
        singleLine = true,
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = null,
                modifier = Modifier.size(25.dp)
            )
        },
        placeholder = {
            Text(text = "Tìm kiếm bài hát, nghệ sĩ...", fontSize = 14.sp)

        },
        shape = RoundedCornerShape(30.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(45.dp)

    )
}

@Preview(showBackground = true)
@Composable
fun SearchTextFieldPreview() {
    MuisicAppTheme {
        SearchTextField("", {}, Modifier)
    }
}


//          Đề xuất tìm kiếm
@Composable
private fun RecommendSearch(
    showAllItems: Boolean, onEventChange: () -> Unit, itemsToShow: List<Recommendation>
) {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
    ) {
        Text(
            text = "Đề xuất cho bạn",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(20.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(itemsToShow) { recommend ->
                RecommendItem(content = recommend.name)
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(22.dp),
            horizontalArrangement = Arrangement.Center
        ) {

            TextButton(
                onClick = { onEventChange() },
                modifier = Modifier
                    .width(200.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xff232323))
            ) {
                Text(
                    text = if (showAllItems) "Ẩn bớt"
                    else "Xem thêm",
                    color = Color.White,
                    fontSize = 10.sp,
                )
            }
        }
    }
}

object RecommendList {
    val recommends = listOf(
        Recommendation("son tung"),
        Recommendation("jack 5 cu"),
        Recommendation("hieu thu 2"),
        Recommendation("abc"),
        Recommendation("son tung"),
        Recommendation("jack 5 cu"),
        Recommendation("hieu thu 2"),
        Recommendation("abc"),
        Recommendation("son tung"),
        Recommendation("jack 5 cu"),
        Recommendation("hieu thu 2"),
        Recommendation("abc"),
    )
}

data class Recommendation(
    var name: String
)

@Composable
private fun RecommendItem(
    content: String,
) {
    TextButton(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .wrapContentSize()
            .clip(RoundedCornerShape(22.dp))
            .background(Color(0xff232323))
    ) {
        Text(text = content, color = Color.White, fontSize = 12.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun RecommendPreview() {
    MuisicAppTheme {
        RecommendSearch(showAllItems = true, onEventChange = { /*TODO*/ }, itemsToShow = listOf())
    }
}



