package com.emirhankolver.tmdbapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.emirhankolver.tmdbapp.common.AppConstants
import com.emirhankolver.tmdbapp.data.MovieDetail

@Composable
fun MovieDetailView(
    movieDetail: MovieDetail?,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 16.dp,
                vertical = 8.dp
            )
    ) {
        Row {
            AsyncImage(
                modifier = Modifier
                    .size(128.dp)
                    .clip(RoundedCornerShape(6.dp))
                    .background(MaterialTheme.colorScheme.outline),
                model = AppConstants.BASE_URL_IMAGE + movieDetail?.posterPath,
                contentDescription = "Poster of ${movieDetail?.originalTitle}",
                contentScale = ContentScale.Crop,
                onLoading = { Icons.Rounded.Clear },
                onError = { Icons.Rounded.Clear },
            )
            Column(
                modifier = Modifier
                    .wrapContentSize()
                    .height(128.dp)
                    .padding(16.dp)
            ) {
                Text(
                    text = "${movieDetail?.originalTitle} (${
                        movieDetail?.releaseDate?.substring(
                            0,
                            4
                        )
                    })",
                    style = MaterialTheme.typography.titleMedium,
                )
                Text(
                    text = "${movieDetail?.overview}",
                    style = MaterialTheme.typography.bodySmall,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}