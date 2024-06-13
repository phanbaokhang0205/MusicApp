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
import com.example.muisicapp.View.login_register.LoginScreen
import com.example.muisicapp.View.login_register.LoginScreen2
import com.example.muisicapp.View.login_register.RegisterScreen
import com.example.muisicapp.View.playlist.PlayListDestination
import com.example.muisicapp.View.playlist.PlaylistListDestination
import com.example.muisicapp.View.playlist.PlaylistListScreen
import com.example.muisicapp.View.playlist.PlaylistScreen
import com.example.muisicapp.View.search.SearchDestination
import com.example.muisicapp.View.search.SearchResultDestination
import com.example.muisicapp.View.search.SearchResultScreen
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
        startDestination = LoginScreen.route,
        modifier = Modifier,
    ) {

        //user
        composable(route = LoginScreen.route) {
            LoginScreen(
                loginScreen2 = { navController.navigate(LoginScreen2.route) },
                registerScreen = { navController.navigate(RegisterScreen.route) }
            )
        }

        composable(route = LoginScreen2.route) {
            LoginScreen2(
                homeScreen = { navController.navigate("${HomeDestination.route}/${it}") }
            )
        }
        composable(route = RegisterScreen.route) {
            RegisterScreen()
        }


        /**
         * Home Screen
         */
        composable(
            route = HomeDestination.routeWithArgs,
            arguments = listOf(
                navArgument(HomeDestination.userID) {
                    type = NavType.IntType
                }
            )
        ) {
            HomeScreen(
                goToSearchScreen = { navController.navigate(SearchResultDestination.route) },
                goToPlaylistScreen = { navController.navigate(PlaylistListDestination.route) },
                goToAccountScreen = { userId ->
                    navController.navigate("${AccountDestination.route}/${userId}")
                },
                goToSingerList = { navController.navigate(SingerListDestination.route) },
                goToSongList = { navController.navigate(SongListDestination.route) },
                goToAlbumList = { navController.navigate(AlbumListDestination.route) },

                goToSongDetails = { songId ->
                    navController.navigate("${SongDetailsDestination.route}/${songId}")
                },
                goToDetailSinger = { singerId ->
                    navController.navigate("${SingerDetailsDestination.route}/${singerId}")
                },
                goToDetailAlbum = { albumId ->
                    navController.navigate("${AlbumDestination.route}/${albumId}")
                },
                goToDetailPlaylist = { playListID ->
                    navController.navigate("${PlayListDestination.route}/${playListID}")
                },
                onLogoutEvent = { navController.popBackStack(LoginScreen.route, false) }

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
         * Playlist List Screen
         */
        composable(route = PlaylistListDestination.route) {
            PlaylistListScreen(
                goBack = { navController.popBackStack() },
                goToPlaylistDetails = { navController.navigate("${PlayListDestination.route}/${it}") }
            )
        }

        /**
         * Search Result
         */

        composable(route = SearchResultDestination.route) {
            SearchResultScreen(
                goBack = { navController.popBackStack() },
                goToSongDetails = { navController.navigate("${SongDetailsDestination.route}/${it}") }
            )
        }


        /**
         * Account Screen
         */
        composable(
            route = AccountDestination.routeWithArgs,
            arguments = listOf(
                navArgument(AccountDestination.userID) {
                    type = NavType.IntType
                }
            )
        ) {
            UserDetail(
                goToHomeScreen = { navController.navigate("${HomeDestination.route}/${it}") },
                goToSearchScreen = { navController.navigate(SearchDestination.route) },
                goToPlaylistScreen = { navController.navigate(PlaylistListDestination.route) },
                goBack = { navController.popBackStack() },
                goToSongDetails = { navController.navigate("${SongDetailsDestination.route}/${it}") },
            )
        }


        /**
         * Song Details
         */
        composable(
            route = SongDetailsDestination.routeWithArgs,
            arguments = listOf(
                navArgument(SongDetailsDestination.songIdAgr) {
                    type = NavType.IntType
                }
            )
        ) {
            SongDetailsScreen(
                goBackEvent = { navController.popBackStack() },
                goOptionEvent = {},
                goShareEvent = {},

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
                goOptionEvent = {},
                goToSongDetails = { navController.navigate("${SongDetailsDestination.route}/${it}") },
                goToAlbumDetails = { navController.navigate("${AlbumDestination.route}/${it}") }
            )
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
                goToDetailSingerOfAlbum = { navController.navigate("${SongDetailsDestination.route}/${it}") }
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