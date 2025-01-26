package com.emirhankolver.tmdbapp.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import com.emirhankolver.tmdbapp.data.MovieDetail
import com.emirhankolver.tmdbapp.ui.home.components.HomeTopSliderView
import com.emirhankolver.tmdbapp.ui.home.components.MovieDetailList
import com.emirhankolver.tmdbapp.ui.navigation.Routes
import com.google.gson.Gson
import java.net.URLEncoder

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navHostController: NavHostController, viewModel: HomeViewModel = hiltViewModel()) {
    val sliderState = viewModel.upcomingList.collectAsState()
    val nowPlayingState = viewModel.nowPlayingFlow.collectAsLazyPagingItems()
    val isRefreshing = viewModel.isRefreshing.collectAsState()

    Scaffold {
        PullToRefreshBox(
            isRefreshing = isRefreshing.value,
            onRefresh = {
                nowPlayingState.refresh()
                viewModel.refresh()
            }
        ) {
            Column(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize()
            ) {
                MovieDetailList(
                    state = nowPlayingState,
                    onClickItem = { detail ->
                        navigateToDetails(navHostController, detail)
                    },
                ) {
                    HomeTopSliderView(
                        state = sliderState.value,
                        onTapRetry = { viewModel.loadUpcomingList() },
                        onClickItem = { detail ->
                            navigateToDetails(navHostController, detail)
                        },
                    )
                }
            }
        }
    }
}

fun navigateToDetails(navHostController: NavHostController, detail: MovieDetail?) {
    navHostController.navigate(
        Routes.Detail.route.replace(
            "{item}",
            URLEncoder.encode(Gson().toJson(detail)),
        )
    )
}