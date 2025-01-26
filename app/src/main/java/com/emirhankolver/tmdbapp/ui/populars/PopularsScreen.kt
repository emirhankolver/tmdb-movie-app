package com.emirhankolver.tmdbapp.ui.populars

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.emirhankolver.tmdbapp.data.UiState
import com.emirhankolver.tmdbapp.ui.components.ErrorCard
import com.emirhankolver.tmdbapp.ui.components.MovieDetailView
import com.emirhankolver.tmdbapp.ui.home.components.MovieDetailPlaceHolder
import com.emirhankolver.tmdbapp.ui.home.navigateToDetails

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PopularsScreen(navHostController: NavHostController) {
    val viewModel: PopularsViewModel = hiltViewModel()
    val state = viewModel.popularsList.collectAsState().value

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("Popular Movies", fontWeight = FontWeight.Medium)
                },
                navigationIcon = {
                    IconButton(onClick = { navHostController.navigateUp() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = null,
                        )
                    }
                },
            )
        }
    ) { initialPadding ->
        Box(Modifier.padding(initialPadding)) {
            when (state) {
                is UiState.Error -> {
                    ErrorCard(subtitle = state.message)
                }

                is UiState.Loading -> {
                    Column {
                        repeat(6) {
                            MovieDetailPlaceHolder()
                        }
                    }
                }

                is UiState.Success -> {
                    LazyColumn {
                        items(state.data) { details ->
                            MovieDetailView(details) {
                                navHostController.navigateUp()
                                navigateToDetails(
                                    navHostController,
                                    details,
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}