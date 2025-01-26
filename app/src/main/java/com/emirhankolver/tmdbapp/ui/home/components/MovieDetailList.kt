package com.emirhankolver.tmdbapp.ui.home.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.emirhankolver.tmdbapp.data.MovieDetail
import com.emirhankolver.tmdbapp.data.UiState
import com.emirhankolver.tmdbapp.ui.components.ErrorCard
import com.emirhankolver.tmdbapp.ui.components.MovieDetailView

@Composable
fun MovieDetailList(
    state: UiState<List<MovieDetail?>>,
    onClickItem: (MovieDetail?) -> Unit,
    header: @Composable (() -> Unit)?,
) {
    when (state) {
        is UiState.Error -> Column {
            header?.invoke()
            ErrorCard()
        }

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
                    MovieDetailView(movieDetail = state.data[it], onClickItem)
                }
            }
        }
    }
}