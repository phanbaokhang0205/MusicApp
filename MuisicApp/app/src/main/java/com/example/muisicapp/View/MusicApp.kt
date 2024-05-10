package com.example.muisicapp.View

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.muisicapp.View.Home.HomeScreen
import com.example.muisicapp.View.navigation.MusicNavHost

@Composable
fun MusicApp(navController: NavHostController = rememberNavController()) {
    MusicNavHost(navController = navController)
}
