package com.emirhankolver.tmdbapp.ui.home.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.emirhankolver.tmdbapp.data.MovieDetail
import com.emirhankolver.tmdbapp.ui.components.ErrorCard
import com.emirhankolver.tmdbapp.ui.components.MovieDetailView

@Composable
fun MovieDetailList(
    state: LazyPagingItems<MovieDetail>,
    onClickItem: (MovieDetail?) -> Unit,
    header: @Composable (() -> Unit)?,
) {
    LazyColumn(horizontalAlignment = Alignment.CenterHorizontally) {
        item {
            header?.invoke()
            Box(Modifier.height(8.dp))
        }

        items(state.itemCount) {
            MovieDetailView(movieDetail = state[it], onClickItem)
        }

        // Handle Loading State
        state.apply {
            loadState.append.let { appendState ->
                when (appendState) {
                    is LoadState.Loading -> {
                        item { CircularProgressIndicator(modifier = Modifier.padding(16.dp)) }
                    }

                    is LoadState.Error -> {
                        val error = appendState.error
                        item {
                            ErrorCard(error.message) {
                                state.retry()
                            }
                        }
                    }

                    else -> Unit // Handle other cases (e.g., Loaded)
                }
            }

            loadState.refresh.let { refreshState ->
                when (refreshState) {
                    is LoadState.Error -> {
                        val error = refreshState.error
                        item {
                            ErrorCard(error.message) {
                                state.refresh()
                            }
                        }
                    }

                    is LoadState.Loading -> {
                        items(10) {
                            MovieDetailPlaceHolder()
                        }
                    }

                    else -> Unit // Handle other cases (e.g., Loaded, Loading)
                }
            }
        }
    }
}