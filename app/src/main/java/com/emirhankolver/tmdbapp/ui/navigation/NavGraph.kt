package com.emirhankolver.tmdbapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.emirhankolver.tmdbapp.ui.detail.DetailScreen
import com.emirhankolver.tmdbapp.ui.home.HomeScreen
import com.emirhankolver.tmdbapp.ui.populars.PopularsScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Routes.Home.route
    ) {
        composable(Routes.Home.route) {
            HomeScreen(navController)
        }
        composable(Routes.Detail.route) {
            DetailScreen(navController)
        }
        composable(Routes.Detail.route) {
            PopularsScreen(navController)
        }
    }
}