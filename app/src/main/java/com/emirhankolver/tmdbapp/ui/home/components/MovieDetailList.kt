package com.emirhankolver.tmdbapp.ui.home.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Warning
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.emirhankolver.tmdbapp.data.MovieDetail
import com.emirhankolver.tmdbapp.data.UiState
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
            Card(
                Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                colors = CardColors(
                    containerColor = MaterialTheme.colorScheme.errorContainer,
                    contentColor = MaterialTheme.colorScheme.error,
                    disabledContainerColor = MaterialTheme.colorScheme.errorContainer,
                    disabledContentColor = MaterialTheme.colorScheme.errorContainer,
                )
            ) {
                Column(
                    Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        modifier = Modifier.size(36.dp),
                        imageVector = Icons.Rounded.Warning,
                        contentDescription = "Error Icon",
                    )
                    Text("Connection Issue", style = MaterialTheme.typography.titleMedium)
                    Text(state.message)
                }
            }
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