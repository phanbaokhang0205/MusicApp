package com.example.muisicapp.View.Home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.muisicapp.ui.theme.LightRed

@Composable
fun HomeScreen(){
    Box(modifier = Modifier
        .background(LightRed)
        .fillMaxSize())
    {
        Column {
            GreetingSection()
        }
    }
}
@Composable
fun GreetingSection(
    name:String = "Hau"
){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Column(verticalArrangement = Arrangement.Center) {
            Text(
                text = "Hello $name",
                style = TextStyle(fontFamily = FontFamily.SansSerif)
            )
            Text(
                text = "Let's listen to something cool today",
                style = TextStyle(fontFamily = FontFamily.SansSerif)
            )
        }
//        Icon(
//            painter = painterResource(id = R.drawable.ic_search),
//            contentDescription ="Search",
//            tint = Color.White,
//            modifier = Modifier.size(24.dp)
//        )
    }
}
@Composable
@Preview(showBackground = true)
fun HomeScreenPreview(){
    HomeScreen()
}

