package com.emirhankolver.tmdbapp.ui.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.emirhankolver.tmdbapp.R
import com.emirhankolver.tmdbapp.common.AppConstants
import com.emirhankolver.tmdbapp.data.MovieDetail

@Composable
fun DetailScreen(
    navHostController: NavHostController,
    movieDetail: MovieDetail?,
) {

    Scaffold {
        LazyColumn(
            Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            item {
                Box {
                    AsyncImage(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .background(MaterialTheme.colorScheme.surfaceContainer),
                        model = AppConstants.BASE_URL_IMAGE + movieDetail?.backdropPath,
                        contentDescription = "Poster of ${movieDetail?.originalTitle}",
                        contentScale = ContentScale.Crop
                    )
                    IconButton(onClick = { navHostController.navigateUp() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Localized description",
                            tint = Color.White,
                        )
                    }
                }
            }
            item {
                Row(Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(R.drawable.ic_star),
                        contentDescription = null,
                        tint = Color(0xFFF9C712),
                    )
                    Text("${movieDetail?.voteAverage}", fontWeight = FontWeight.Medium)
                    Text(
                        "/10",
                        fontWeight = FontWeight.Medium,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = .50f)
                    )
                    Box(
                        Modifier
                            .padding(horizontal = 8.dp)
                            .size(4.dp)
                            .background(Color(0xFFF9C712))
                    )
                    Text("${movieDetail?.releaseDate}", fontWeight = FontWeight.Medium)
                }
            }
            item {
                Text(
                    "${movieDetail?.title}",
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
            item {
                Text(
                    "${movieDetail?.overview}",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}