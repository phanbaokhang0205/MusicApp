package com.example.muisicapp.View.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.muisicapp.View.Home.HomeDestination
import com.example.muisicapp.View.Home.HomeScreen
import com.example.muisicapp.View.Singer.DetailSingerScreen
import com.example.muisicapp.View.Singer.SingerDetailsDestination
import com.example.muisicapp.View.login_register.Login2Destination
import com.example.muisicapp.View.login_register.LoginDestination
import com.example.muisicapp.View.login_register.LoginScreen
import com.example.muisicapp.View.login_register.LoginScreen2
import com.example.muisicapp.View.login_register.RegisterDestination
import com.example.muisicapp.View.login_register.RegisterScreen
import com.example.muisicapp.View.search.SearchDestination
import com.example.muisicapp.View.search.SearchScreen
import com.example.muisicapp.View.song.SongDetailsDestination
import com.example.muisicapp.View.song.SongDetailsScreen
import com.example.muisicapp.View.user.AccountDestination
import com.example.muisicapp.View.user.UserDetail
import com.example.muisicapp.ViewModel.LoginViewModel

@Composable
fun MusicNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Login2Destination.route,
        modifier = Modifier,
    ) {
        /**
         *Login Screen
         */
        composable(route = LoginDestination.route) {
            val viewModel: LoginViewModel = viewModel()
            LoginScreen(viewModel = viewModel)
        }

        /**
         *Login2 Screen
         */
        composable(route = Login2Destination.route) {
            LoginScreen2(
                loginScreen = { navController.navigate(LoginDestination.route) },
                registerScreen = { navController.navigate(RegisterDestination.route) })
        }


        /**
         *Register Screen
         */
        composable(route = RegisterDestination.route) {
            RegisterScreen()
        }

        /**
         * Home Screen
         */
        composable(route = HomeDestination.route) {
            HomeScreen(
                goToSearchScreen = { navController.navigate(SearchDestination.route) },
                goToPlaylistScreen = { },
                goToAccountScreen = { navController.navigate(AccountDestination.route) },
                goToSongDetails = { navController.navigate("${SongDetailsDestination.route}/${it}") },
                goToDetailSinger = { navController.navigate("${SingerDetailsDestination.route}/${it}") }
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
         * Song Details Screen
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
         * Singer Details
         */
        composable(
            route = SingerDetailsDestination.routeWithArgs,
            arguments = listOf(navArgument(SingerDetailsDestination.singerIdAgr) {
                type = NavType.IntType
            })
        ) {
            DetailSingerScreen(

            )
        }


    }
}