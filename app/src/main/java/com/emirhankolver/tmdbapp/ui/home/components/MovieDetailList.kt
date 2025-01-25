package com.emirhankolver.tmdbapp.ui.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.emirhankolver.tmdbapp.data.MovieDetail
import com.emirhankolver.tmdbapp.data.UiState
import com.emirhankolver.tmdbapp.ui.components.MovieDetailView

@Composable
fun MovieDetailList(state: UiState<List<MovieDetail?>>, header: @Composable (() -> Unit)?) {
    when (state) {
        is UiState.Error -> Box {}
        is UiState.Loading -> {
            LazyColumn {
                items(10) {
                    if (it == 0) header?.invoke()
                    if (it == 0) Box(Modifier.height(8.dp))
                    MovieDetailPlaceHolder()
                }
            }
        }

        is UiState.Success -> {
            LazyColumn {
                items(state.data.size) {
                    if (it == 0) header?.invoke()
                    if (it == 0) Box(Modifier.height(8.dp))
                    MovieDetailView(movieDetail = state.data[it])
                }
            }
        }
    }
}