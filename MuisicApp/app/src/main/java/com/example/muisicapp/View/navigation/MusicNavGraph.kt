package com.example.muisicapp.View.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.muisicapp.View.Album.AlbumDestination
import com.example.muisicapp.View.Album.AlbumListDestination
import com.example.muisicapp.View.Album.AlbumListScreen
import com.example.muisicapp.View.Album.AlbumScreen
import com.example.muisicapp.View.Home.HomeDestination
import com.example.muisicapp.View.Home.HomeScreen
import com.example.muisicapp.View.Singer.DetailSingerScreen
import com.example.muisicapp.View.Singer.SingerDetailsDestination
import com.example.muisicapp.View.Singer.SingerListDestination
import com.example.muisicapp.View.Singer.SingerListScreen
import com.example.muisicapp.View.playlist.PlayListDestination
import com.example.muisicapp.View.playlist.PlaylistScreen
import com.example.muisicapp.View.search.SearchDestination
import com.example.muisicapp.View.search.SearchScreen
import com.example.muisicapp.View.song.SongDetailsDestination
import com.example.muisicapp.View.song.SongDetailsScreen
import com.example.muisicapp.View.song.SongListDestination
import com.example.muisicapp.View.song.SongListScreen
import com.example.muisicapp.View.user.AccountDestination
import com.example.muisicapp.View.user.UserDetail

@Composable
fun MusicNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = HomeDestination.route,
        modifier = Modifier,
    ) {
        /**
         * Home Screen
         */
        composable(route = HomeDestination.route) {
            HomeScreen(
                goToSearchScreen = { navController.navigate(SearchDestination.route) },
                goToPlaylistScreen = { },
                goToAccountScreen = { navController.navigate(AccountDestination.route) },
                goToSingerList = { navController.navigate(SingerListDestination.route) },
                goToSongList = { navController.navigate(SongListDestination.route) },
                goToAlbumList = { navController.navigate(AlbumListDestination.route) },
                goToSongDetails = { navController.navigate("${SongDetailsDestination.route}/${it}") },
                goToDetailSinger = { navController.navigate("${SingerDetailsDestination.route}/${it}") },
                goToDetailAlbum = { navController.navigate("${AlbumDestination.route}/${it}") },
                goToDetailPlaylist = { navController.navigate("${PlayListDestination.route}/${it}") }
            )
        }

        /**
         * Singer List Screen
         */
        composable(route = SingerListDestination.route) {
            SingerListScreen(
                goBack = { navController.popBackStack() },
                goToSingerDetails = { navController.navigate("${SingerDetailsDestination.route}/${it}") }
            )
        }

        /**
         * Song List Screen
         */
        composable(route = SongListDestination.route) {
            SongListScreen(
                goBack = { navController.popBackStack() },
                goToSongDetails = { navController.navigate("${SongDetailsDestination.route}/${it}") }
            )
        }

        /**
         * Album List Screen
         */
        composable(route = AlbumListDestination.route) {
            AlbumListScreen(
                goBack = { navController.popBackStack() },
                goToAlbumDetails = { navController.navigate("${AlbumDestination.route}/${it}") }
            )
        }

        /**
         * Search Screen
         */
        composable(route = SearchDestination.route) {
            SearchScreen(
                goToHomeScreen = { navController.navigate(HomeDestination.route) },
                goToAccountScreen = { navController.navigate(AccountDestination.route) },
                goToPlaylistScreen = { },
                goBack = { navController.popBackStack() }
            )
        }


        /**
         * Account Screen
         */
        composable(route = AccountDestination.route) {
            UserDetail(
                goToHomeScreen = { navController.navigate(HomeDestination.route) },
                goToSearchScreen = { navController.navigate(SearchDestination.route) },
                goToPlaylistScreen = { },
                goBack = { navController.popBackStack() }
            )
        }


        /**
         * Song Details
         */
        composable(
            route = SongDetailsDestination.routeWithArgs,
            arguments = listOf(navArgument(SongDetailsDestination.songIdAgr) {
                type = NavType.IntType
            })
        ) {
            SongDetailsScreen(
                goBackEvent = { navController.popBackStack() },
                goOptionEvent = {},
                goShareEvent = {}
            )
        }

        /**
         * Singer Details
         */
        composable(
            route = SingerDetailsDestination.routeWithArgs,
            arguments = listOf(navArgument(SingerDetailsDestination.singerIdAgr) {
                type = NavType.IntType
            })
        ) {
            DetailSingerScreen(
                goBackEvent = { navController.popBackStack() },
                goShareEvent = { /*TODO*/ },
                goOptionEvent = {})
        }

        /**
         * Album Details
         */
        composable(
            route = AlbumDestination.routeWithArgs,
            arguments = listOf(navArgument(AlbumDestination.albumIdAgr) {
                type = NavType.IntType
            })
        ) {
            AlbumScreen(
                goBackEvent = { navController.popBackStack() },
                goShareEvent = { /*TODO*/ },
                goOptionEvent = { /*TODO*/ },
                goToDetailSingerOfAlbum = {}
            )
        }

        /**
         * PlayList Details
         */
        composable(
            route = PlayListDestination.routeWithArgs,
            arguments = listOf(navArgument(PlayListDestination.playListIdAgr) {
                type = NavType.IntType
            })
        ) {
            PlaylistScreen(
                goBackEvent = { navController.popBackStack() },
                goShareEvent = { /*TODO*/ },
                goOptionEvent = { /*TODO*/ })
        }


    }
}