package com.emirhankolver.tmdbapp.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.emirhankolver.tmdbapp.ui.home.components.HomeTopSliderView

@Composable
fun HomeScreen(navHostController: NavHostController) {
    val viewModel: HomeViewModel = hiltViewModel()
    val sliderState = viewModel.upcomingList.collectAsState()

    Scaffold {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            HomeTopSliderView(state = sliderState.value)
            Text(text = "Home Screen")
        }
    }
}