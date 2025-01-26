package com.emirhankolver.tmdbapp.ui.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.emirhankolver.tmdbapp.R
import com.emirhankolver.tmdbapp.common.AppConstants
import com.emirhankolver.tmdbapp.data.MovieDetail
import com.emirhankolver.tmdbapp.ui.detail.components.DetailSummaryText
import com.emirhankolver.tmdbapp.ui.navigation.Routes
import com.emirhankolver.tmdbapp.utils.DateUtils

@Composable
fun DetailScreen(
    navHostController: NavHostController,
    movieDetail: MovieDetail?,
) {
    val viewModel: DetailViewModel = hiltViewModel()
    val state = viewModel.movieDetail.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.loadMovieDetails(id = movieDetail?.id)
    }

    Scaffold {
        Column(
            Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            LazyColumn(Modifier.weight(1f)) {
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
                                contentDescription = null,
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
                        Text(
                            "${movieDetail?.voteAverage}".substring(0, 3),
                            fontWeight = FontWeight.Medium
                        )
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
                        Text(
                            DateUtils.formatToLocalDate(movieDetail?.releaseDate),
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
                item {
                    Text(
                        "${movieDetail?.title} (${movieDetail?.releaseDate?.substring(0, 4)})",
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                }
                item {
                    DetailSummaryText(state.value)
                }
            }
            Button(
                {
                    navHostController.popBackStack()
                    navHostController.navigate(Routes.Populars.route)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp, vertical = 16.dp),
                contentPadding = PaddingValues(16.dp),
                colors = ButtonColors(
                    contentColor = Color.Black,
                    containerColor = Color(0xFFFFDC5E),
                    disabledContentColor = Color.Black,
                    disabledContainerColor = Color(0xFFFFDC5E),
                ),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("Discover Popular Movies")
            }
        }
    }
}