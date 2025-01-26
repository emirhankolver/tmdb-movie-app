package com.emirhankolver.tmdbapp.ui.detail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.emirhankolver.tmdbapp.data.MovieDetail
import com.emirhankolver.tmdbapp.data.UiState
import com.emirhankolver.tmdbapp.ui.components.ErrorCard
import com.valentinilk.shimmer.shimmer

@Composable
fun DetailSummaryText(state: UiState<MovieDetail?>) {
    when (state) {
        is UiState.Error -> {
            ErrorCard(subtitle = state.message)
        }

        is UiState.Loading -> {
            Card(
                Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
            ) {
                repeat(3) {
                    Box(
                        Modifier
                            .fillMaxWidth()
                            .height(48.dp)
                            .padding(horizontal = 16.dp, vertical = 8.dp)
                            .shimmer()
                            .background(
                                color = MaterialTheme.colorScheme.primary.copy(alpha = 0.2f),
                                shape = RoundedCornerShape(4.dp),
                            )
                    )
                }
            }
        }

        is UiState.Success -> {
            Text(
                state.data?.overview ?: "-",
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}