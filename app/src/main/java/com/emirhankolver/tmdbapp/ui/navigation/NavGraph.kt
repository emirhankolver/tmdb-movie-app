package com.emirhankolver.tmdbapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.emirhankolver.tmdbapp.data.MovieDetail
import com.emirhankolver.tmdbapp.ui.detail.DetailScreen
import com.emirhankolver.tmdbapp.ui.home.HomeScreen
import com.emirhankolver.tmdbapp.ui.populars.PopularsScreen
import com.google.gson.Gson
import java.net.URLDecoder

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Routes.Home.route
    ) {
        composable(Routes.Home.route) {
            HomeScreen(navController)
        }
        composable(
            Routes.Detail.route,
            arguments = listOf(navArgument("item") { type = NavType.StringType })
        ) {
            val itemJson = it.arguments?.getString("item")
            val item =
                URLDecoder.decode(itemJson)?.let { Gson().fromJson(it, MovieDetail::class.java) }
            DetailScreen(navController, item)
        }
        composable(Routes.Populars.route) {
            PopularsScreen(navController)
        }
    }
}