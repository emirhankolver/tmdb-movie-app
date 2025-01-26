package com.emirhankolver.tmdbapp.ui.populars

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emirhankolver.tmdbapp.data.MovieDetail
import com.emirhankolver.tmdbapp.data.UiState
import com.emirhankolver.tmdbapp.domain.MovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PopularsViewModel @Inject constructor(
    private val useCase: MovieUseCase,
) : ViewModel() {

    private val _popularsList = MutableStateFlow<UiState<List<MovieDetail?>>>(UiState.Loading)
    val popularsList: StateFlow<UiState<List<MovieDetail?>>> = _popularsList

    init {
        loadPopularsList()
    }

    private fun loadPopularsList() = viewModelScope.launch(Dispatchers.IO) {
        try {
            val movies = useCase.getMoviePopular()
            delay(1000)
            _popularsList.emit(UiState.Success(movies.results ?: emptyList()))
        } catch (t: Throwable) {
            _popularsList.emit(UiState.Error(t.message ?: "Unknown Error"))
        }
    }
}