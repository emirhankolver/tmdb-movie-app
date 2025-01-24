package com.emirhankolver.tmdbapp.ui.home.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.emirhankolver.tmdbapp.common.AppConstants
import com.emirhankolver.tmdbapp.data.MovieDetail

@Composable
fun SliderItemView(
    screenWidth: Int,
    movieDetail: MovieDetail?
) {
    Box(
        modifier = Modifier
            .width(screenWidth.dp)
            .height(200.dp)
    ) {
        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            model = AppConstants.BASE_URL_IMAGE + movieDetail?.backdropPath,
            contentDescription = "Picture of ${movieDetail?.originalTitle}",
            contentScale = ContentScale.Crop,
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black.copy(alpha = 0.7f)
                        ),
                    )
                )
        )
        Column(
            modifier = Modifier
                .width(screenWidth.dp)
                .align(Alignment.BottomCenter)
                .padding(horizontal = 16.dp, vertical = 32.dp)
        ) {
            Text(
                text = "${movieDetail?.title} (${movieDetail?.releaseDate?.substring(0, 4)})",
                color = MaterialTheme.colorScheme.surface,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
            )
            Text(
                text = "Overview of the movie should be single line and centered veand centered ve",
                color = MaterialTheme.colorScheme.surface,
                fontSize = 12.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}