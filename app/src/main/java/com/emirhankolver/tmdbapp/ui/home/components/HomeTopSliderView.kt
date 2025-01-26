package com.emirhankolver.tmdbapp.ui.home.components

import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.emirhankolver.tmdbapp.data.MovieDetail
import com.emirhankolver.tmdbapp.data.UiState
import com.emirhankolver.tmdbapp.ui.components.ErrorCard


@Composable
fun HomeTopSliderView(
    state: UiState<List<MovieDetail?>>,
    onClickItem: (MovieDetail?) -> Unit,
) {
    val screenWidth = LocalConfiguration.current.screenWidthDp
    val listState = rememberLazyListState()

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        when (state) {
            is UiState.Error -> {
                ErrorCard(state.message)
            }

            is UiState.Loading -> {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        CircularProgressIndicator()
                    }
                }
            }

            is UiState.Success -> {
                Box(
                    contentAlignment = Alignment.BottomCenter
                ) {
                    LazyRow(
                        state = listState,
                        flingBehavior = rememberSnapFlingBehavior(lazyListState = listState)
                    ) {
                        items(state.data.size) {
                            SliderItemView(
                                screenWidth = screenWidth,
                                movieDetail = state.data[it],
                                onClickItem = onClickItem,
                            )
                        }
                    }
                    DotIndicator(listState)
                }
            }
        }
    }
}