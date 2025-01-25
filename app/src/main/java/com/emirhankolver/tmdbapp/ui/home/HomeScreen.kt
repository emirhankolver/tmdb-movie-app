package com.emirhankolver.tmdbapp.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.emirhankolver.tmdbapp.ui.home.components.HomeTopSliderView
import com.emirhankolver.tmdbapp.ui.home.components.MovieDetailList

@Composable
fun HomeScreen(navHostController: NavHostController) {
    val viewModel: HomeViewModel = hiltViewModel()
    val sliderState = viewModel.upcomingList.collectAsState()
    val nowPlayingState = viewModel.nowPlayingList.collectAsState()

    Scaffold {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            MovieDetailList(state = nowPlayingState.value) {
                HomeTopSliderView(state = sliderState.value)
            }
        }
    }
}