package com.emirhankolver.tmdbapp.ui.navigation

sealed class Routes(val route: String) {
    data object Home : Routes("home")
    data object Detail : Routes("detail")
    data object Populars : Routes("populars")
}