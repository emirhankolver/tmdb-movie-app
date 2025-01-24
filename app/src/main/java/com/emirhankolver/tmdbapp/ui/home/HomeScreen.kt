package com.emirhankolver.tmdbapp.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun HomeScreen(navHostController: NavHostController) {
    Scaffold {
        Column(modifier = Modifier
            .padding(it)
            .fillMaxSize()) {
            Text(text = "Home Screen")
        }
    }
}